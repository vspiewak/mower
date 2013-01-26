package com.github.vspiewak.mowitnow.mower.base;

public enum Move {

    FORWARD(1) /* BACKWARD(-1), RUN(3) */;

    private int distance;

    Move(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }
}
