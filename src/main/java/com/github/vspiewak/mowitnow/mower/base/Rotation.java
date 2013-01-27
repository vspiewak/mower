package com.github.vspiewak.mowitnow.mower.base;

/**
 * This enum represent a rotation move.
 * <br>
 * It may also support <code>LEFT_HALF(45), RIGHT_HALF(-45)</code>.
 *  
 * @author Vincent Spiewak
 * @see Vehicule
 * @since 1.0
 */
public enum Rotation {

   LEFT(90), RIGHT(-90); 

   private int degree;

   private Rotation(int degree) {
      this.degree = degree;
   }

   public int getDegree() {
      return this.degree;
   }

}
