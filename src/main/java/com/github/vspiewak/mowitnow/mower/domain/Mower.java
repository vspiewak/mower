package com.github.vspiewak.mowitnow.mower.domain;

import com.github.vspiewak.mowitnow.mower.api.Engine;
import com.github.vspiewak.mowitnow.mower.api.Vehicule;
import com.github.vspiewak.mowitnow.mower.base.Direction;
import com.github.vspiewak.mowitnow.mower.base.Orientation;
import com.github.vspiewak.mowitnow.mower.base.Position;
import com.github.vspiewak.mowitnow.mower.base.Rotation;

/**
 * The Mower is a <code>Vehicule</code> implementation.
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
public class Mower implements Vehicule {

   private Position position;
   private Orientation orientation;

   private Engine engine = XEngine.get();

   public Mower(Position p, Orientation o) {
      this.position = p;
      this.orientation = o;
   }

   @Override
   public Position getPosition() {
      return this.position;
   }

   @Override
   public Orientation getOrientation() {
      return this.orientation;
   }

   @Override
   public boolean move(Direction direction) {
      Position nextPosition = getPosition().next(direction, getOrientation());
      this.position = engine.update(this, nextPosition);
      return getPosition().equals(nextPosition);
   }

   @Override
   public void rotate(Rotation r) {
      this.orientation = getOrientation().rotate(r);
   }

   @Override
   public String print() {
      return getPosition().getX() + " " + getPosition().getY() + " "
            + getOrientation().getCode();
   }

   @Override
   public String toString() {
      return print();
   }

}
