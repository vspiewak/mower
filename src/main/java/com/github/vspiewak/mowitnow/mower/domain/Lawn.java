package com.github.vspiewak.mowitnow.mower.domain;

import com.github.vspiewak.mowitnow.mower.api.Scene;
import com.github.vspiewak.mowitnow.mower.base.Position;

public class Lawn implements Scene {

	private Position topRight;
		
	public Lawn(Position topRight) {
		this.topRight = topRight;
	}

	@Override
	public boolean canMove(Position p) {
        return p.getX() >= 0 && p.getX() <= topRight.getX()
                && p.getY() >= 0 && p.getY() <= topRight.getY();
	}

}
