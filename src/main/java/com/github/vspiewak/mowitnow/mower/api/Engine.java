package com.github.vspiewak.mowitnow.mower.api;

import com.github.vspiewak.mowitnow.mower.base.Position;

/**
 * Engine interface of the game/simulation.
 * It's responsible for the physics (like collisions) and rendering.
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
public interface Engine {

   /**
    * Init the engine with the <code>Scene</code>.
    * It ensure to start from a fresh "world"
    * 
    * @param scene
    * @see #clear()
    */
   void init(Scene scene);

   /**
    * Clear the engine. 
    * Remove all configuration
    */ 
   void clear();

   /**
    * Attach an element to the engine.
    * An exception is thrown if the <code>Vehicule</code> position is invalid.
    *  
    * @param vehicule
    */
   void attach(Vehicule vehicule);

   /**
    * Remove a <code>Vehicule</code> to the engine.
    * 
    * @param vehicule
    */
   void detach(Vehicule vehicule);

   /**
    * Return true if the <code>Position</code> is valid.
    * It takes in consideration the <code>Scene</code> and the collisions.
    * 
    * @param position
    * @return true if the position is valid
    */
   boolean canMove(Position position);

   /**
    * Update a <code>Position</code> in the engine.
    * It return the updated position after physics considerations (collision/bounce)
    *  
    * @param vehicule
    * @param newPosition
    * @return the final position in the game/simulation
    */
   Position update(Vehicule vehicule, Position newPosition);

}
