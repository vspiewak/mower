package com.github.vspiewak.mowitnow.mower.api;

import com.github.vspiewak.mowitnow.mower.base.Move;
import com.github.vspiewak.mowitnow.mower.base.Rotation;

/**
 * The Vehicule interface represent an <code>Element</code>
 * with <code>Move</code> and <code>Rotation</code> capabilities.
 * 
 * @author Vincent Spiewak
 * @see Element
 * @see Move
 * @see Rotation
 * @since 1.0
 */
public interface Vehicule extends Element {

   boolean move(Move m);

   void rotate(Rotation r);

}
