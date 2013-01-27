package com.github.vspiewak.mowitnow.mower.base;

import com.github.vspiewak.mowitnow.mower.exceptions.ParseException;

/**
 * The Orientation represent a classic mathematical unit circle 
 * (see: <a href="http://en.wikipedia.org/wiki/Unit_circle">Wikipedia</a>).
 * <br>
 * It may also support 
 * <code>
 * NORTH_EAST(45, "NE"), 
 * NORTH_WEST(135, "NW"), 
 * SOUTH_WEST(225, "SW"), 
 * SOUTH_EAST(315, "SE").
 * </code>
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
public enum Orientation {

   EAST(0, "E"), NORTH(90, "N"), WEST(180, "W"), SOUTH(270, "S");

   private static final int MAX_DEGREE = 360;
   
   private int degree;
   private String code;

   private Orientation(int degree, String code) {
      this.degree = degree;
      this.code = code;
   }

   public int getDegree() {
      return this.degree;
   }

   public String getCode() {
      return this.code;
   }

   public Orientation rotate(Rotation rotation) {

      if (rotation == null) {
         throw new IllegalArgumentException("rotation can't be null");
      }

      int newDegree = (MAX_DEGREE + this.degree + rotation.getDegree()) % MAX_DEGREE;
      return fromDegree(newDegree);

   }

   public Orientation fromDegree(final int degree) {

      Orientation values[] = Orientation.values();
      for (int i = 0; i < values.length; i++) {
         if (degree == values[i].getDegree()) {
            return values[i];
         }
      }

      throw new IllegalArgumentException("Unknown orientation with degree: " + degree);
   }

   public static Orientation parseOrientation(String s) throws ParseException {

      if (s != null && s.length() == 1) {
         for (Orientation o : values()) {
            if (o.getCode().equals(s)) {
               return o;
            }
         }
      }

      throw new ParseException("Parse orientation error: " + s);
   }

   @Override
   public String toString() {
      return this.name();
   }
}
