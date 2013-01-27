package com.github.vspiewak.mowitnow.mower.api;

import com.github.vspiewak.mowitnow.mower.base.Orientation;
import com.github.vspiewak.mowitnow.mower.base.Position;

/**
 * The Element interface represent any element of the game/simulation.
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
public interface Element {

   Position getPosition();

   Orientation getOrientation();

   String print();

}
