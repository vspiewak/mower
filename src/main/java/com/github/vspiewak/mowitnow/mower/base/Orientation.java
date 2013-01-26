package com.github.vspiewak.mowitnow.mower.base;

import com.github.vspiewak.mowitnow.mower.exceptions.ParseException;

public enum Orientation {

   EAST(0, "E"), NORTH(90, "N"), WEST(180, "W"), SOUTH(270, "S");
   /* NORTH_EAST(45, "NE"), NORTH_WEST(135, "NW"), SOUTH_WEST(225, "SW"), SOUTH_EAST(315, "SE"); */

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

      int newDegree = (360 + this.degree + rotation.getDegree()) % 360;
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
