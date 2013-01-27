package com.github.vspiewak.mowitnow.mower.base;

/**
 * The Direction represent a <code>Vehicule</code> move.<br>
 * It may also support <code>BACKWARD(-1) or RUN(3)</code>
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
public enum Direction {

    FORWARD(1);

    private int distance;

    Direction(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
    
}
