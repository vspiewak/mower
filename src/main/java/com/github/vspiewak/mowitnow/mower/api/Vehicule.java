package com.github.vspiewak.mowitnow.mower.api;

import com.github.vspiewak.mowitnow.mower.base.Move;
import com.github.vspiewak.mowitnow.mower.base.Rotation;

public interface Vehicule extends Element {

	boolean move(Move m);
	void rotate(Rotation r);

}
