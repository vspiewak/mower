package com.github.vspiewak.mowitnow.mower.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.vspiewak.mowitnow.mower.exceptions.ParseException;

/**
 * This class represent a position on a <code>Scene<code>.
 *  
 * @author Vincent Spiewak
 * @since 1.0
 */
public class Position {

   /* strong rules: start and finish with a number, a single space, a number */
   private static final Pattern PARSE_PATTERN = Pattern.compile("^(\\d+)[ ](\\d+)$");

   private int x;
   private int y;

   public Position(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public int getX() {
      return x;
   }

   public int getY() {
      return y;
   }

    /**
     * Return the next position after a move
     *
     * @param direction
     * @param orientation
     * @return new position
     */
   public Position next(Direction direction, Orientation orientation) {

      if (direction == null) {
         throw new IllegalArgumentException("Unknown direction: " + direction);
      }

      if (orientation == null) {
         throw new IllegalArgumentException("Unknown orientation: " + orientation);
      }

      /* Just some maths */
      double theta = Math.toRadians(orientation.getDegree());
      int newX = this.x + (int) (direction.getDistance() * Math.round(Math.cos(theta)));
      int newY = this.y + (int) (direction.getDistance() * Math.round(Math.sin(theta)));
      return new Position(newX, newY);

   }

    /**
     * Return a position from a string representation
     *
     * @param s
     * @return new position
     * @throws ParseException if malformed string
     */
   public static Position parsePosition(String s) throws ParseException {

      if (s != null) {

         Matcher m = PARSE_PATTERN.matcher(s);

         if (m.matches()) {

            int x = Integer.parseInt(m.group(1));
            int y = Integer.parseInt(m.group(2));
            return new Position(x, y);

         }

      }
      throw new ParseException("Parse position error: " + s);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) { return true; }
      if (o == null || getClass() != o.getClass()) { return false; }
      
      Position position = (Position) o;
      return (x == position.x && y == position.y);
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + x;
      result = prime * result + y;
      return result;
   }

   @Override
   public String toString() {
      return "Position{" + "x=" + x + ", y=" + y + '}';
   }
}
