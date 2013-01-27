package com.github.vspiewak.mowitnow.mower.api;

import com.github.vspiewak.mowitnow.mower.base.Position;

/**
 * The Scene interface represent a field.
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
public interface Scene {

   /**
    * Return true if the a <code>Element</code> can be at this <code>Position</code>
    * 
    * @param position
    * @return true if valid
    */
   boolean canMove(Position p);

}
