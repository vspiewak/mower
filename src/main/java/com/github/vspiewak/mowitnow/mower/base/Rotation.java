package com.github.vspiewak.mowitnow.mower.base;

public enum Rotation {

    LEFT(90), RIGHT(-90) /* LEFT_HALF(45), RIGHT_HALF(-45) */;

    private int degree;

    private Rotation(int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return this.degree;
    }


}
