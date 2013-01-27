package com.github.vspiewak.mowitnow.mower.domain;

import com.github.vspiewak.mowitnow.mower.api.Scene;
import com.github.vspiewak.mowitnow.mower.base.Position;

/**
 * The Lawn is a rectangular <code>Scene</code>.
 * Bottom left corner position is {0,0} 
 *  
 * @author Vincent Spiewak
 * @see Scene
 * @since 1.0
 */
public class Lawn implements Scene {

   private Position topRight;

   public Lawn(Position topRight) {
      this.topRight = topRight;
   }

   
   @Override
   public boolean canMove(Position p) {
      return p.getX() >= 0 && p.getX() <= topRight.getX() && p.getY() >= 0
            && p.getY() <= topRight.getY();
   }

}
