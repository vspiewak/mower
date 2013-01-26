package com.github.vspiewak.mowitnow.mower.base;

import com.github.vspiewak.mowitnow.mower.exceptions.ParseException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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

    public Position next(Move move, Orientation orientation) {

        if(move == null) {
            throw new IllegalArgumentException("Unknown move: " + move);
        }

        if(orientation == null) {
            throw new IllegalArgumentException("Unknown orientation: " + orientation);
        }

        /* Just some maths */
        double theta = Math.toRadians(orientation.getDegree());
        int newX = this.x + (int)(move.getDistance() * Math.round(Math.cos(theta)));
        int newY = this.y + (int)(move.getDistance() * Math.round(Math.sin(theta)));
        return new Position(newX, newY);

    }

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        return (x == position.x && y == position.y);
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
