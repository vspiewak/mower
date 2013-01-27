package com.github.vspiewak.mowitnow.mower.domain;

import com.github.vspiewak.mowitnow.mower.api.Scene;
import com.github.vspiewak.mowitnow.mower.base.Position;

/**
 * The Lawn is a rectangular <code>Scene</code>.<br>
 * Bottom left corner position is {0,0}
 * <p> 
 * new Lawn(1,2) will produce:
 * <pre>
 * +-----+-----+
 * | 0,2 | 1,2 |
 * +-----+-----+
 * | 0,1 | 1,1 |
 * +-----+-----+
 * | 0,0 | 1,0 |
 * +-----+-----+
 * </pre>
 *
 * @author Vincent Spiewak
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
