package com.github.vspiewak.mowitnow.mower.base;

/**
 * The Move represent a <code>Vehicule</code> move.<br>
 * It may also support <code>BACKWARD(-1), RUN(3)</code>
 * 
 * @author Vincent Spiewak
 * @see Vehicule
 * @since 1.0
 */
public enum Move {

    FORWARD(1);

    private int distance;

    Move(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
    
}
