package com.github.vspiewak.mowitnow.mower.api;

import com.github.vspiewak.mowitnow.mower.base.Position;

public interface Engine {

	void init(Scene scene);
	void clear();
	
	void attach(Vehicule vehicule);
	void detach(Vehicule vehicule);

    boolean canMove(Position p);

	Position update(Vehicule vehicule, Position newPosition);

}
