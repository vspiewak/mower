package com.github.vspiewak.mowitnow.mower.api;

import com.github.vspiewak.mowitnow.mower.base.Orientation;
import com.github.vspiewak.mowitnow.mower.base.Position;

public interface Element {

   Position getPosition();

   Orientation getOrientation();

   String print();

}
