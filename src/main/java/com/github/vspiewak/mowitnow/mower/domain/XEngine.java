package com.github.vspiewak.mowitnow.mower.domain;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.vspiewak.mowitnow.mower.api.Engine;
import com.github.vspiewak.mowitnow.mower.api.Scene;
import com.github.vspiewak.mowitnow.mower.api.Vehicule;
import com.github.vspiewak.mowitnow.mower.base.Position;

public enum XEngine implements Engine {

   INSTANCE;

   private static final Logger log = LoggerFactory.getLogger(XEngine.class);

   private Scene scene;
   private Map<Position, Vehicule> vehicules;

   private XEngine() {
      vehicules = new HashMap<Position, Vehicule>();
   }

   @Override
   public void init(Scene scene) {
      clear();
      this.scene = scene;
   }

   @Override
   public void attach(Vehicule vehicule) {

      Position position = vehicule.getPosition();

      /* check vehicule position */
      if (!canMove(position)) {
         throw new IllegalArgumentException("Can't add the vehicule at: " + position);
      }

      /* add it */
      vehicules.put(position, vehicule);
      log.debug("add - stack {}", vehicules);

   }

   @Override
   public void detach(Vehicule vehicule) {
      vehicules.remove(vehicule);
   }

   @Override
   public boolean canMove(Position p) {
      return (getScene().canMove(p) && !vehicules.containsKey(p));
   }

   @Override
   public Position update(Vehicule vehicule, Position newPosition) {

      /* defensive-way: no update */
      Position returnedPosition = vehicule.getPosition();
      log.debug("update - from: {} to: {}", vehicule, newPosition);

      /* if outside of scene */
      if (!getScene().canMove(newPosition)) {

         log.warn("scene constraint: {} can't update at {}", vehicule, newPosition);

         /* if vehicule collision */
      } else if (vehicules.containsKey(newPosition)) {

         Vehicule collisionVehicule = vehicules.get(newPosition);
         log.warn("collision between {} and {}", vehicule, collisionVehicule);

         /* vehicule is free to update */
      } else {

         /* update vehicule position */
         vehicules.remove(vehicule.getPosition());
         vehicules.put(newPosition, vehicule);
         returnedPosition = newPosition;
      }

      log.debug("update - return: {}", returnedPosition);

      return returnedPosition;

   }

   @Override
   public void clear() {
      this.scene = null;
      vehicules.clear();
   }

   private Scene getScene() {
      return this.scene;
   }

   public static Engine get() {
      return INSTANCE;
   }

}
