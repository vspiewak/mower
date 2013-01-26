package com.github.vspiewak.mowitnow.mower;

import com.github.vspiewak.mowitnow.mower.api.Engine;
import com.github.vspiewak.mowitnow.mower.api.Scene;
import com.github.vspiewak.mowitnow.mower.api.Vehicule;
import com.github.vspiewak.mowitnow.mower.base.Orientation;
import com.github.vspiewak.mowitnow.mower.base.Position;
import com.github.vspiewak.mowitnow.mower.domain.Lawn;
import com.github.vspiewak.mowitnow.mower.domain.Mower;
import com.github.vspiewak.mowitnow.mower.domain.XEngine;

public class AppFactory {

   public static Position newPosition(int x, int y) {
      return new Position(x, y);
   }

   public static Vehicule newMower(Position p, Orientation o) {
      return new Mower(p, o);
   }

   public static Scene newLawn(Position p) {
      return new Lawn(p);
   }

   public static void setup(Scene scene) {
      Engine engine = XEngine.get();
      engine.clear();
      engine.init(scene);
   }

   public static Vehicule newMower(int x, int y, Orientation o) {
      return new Mower(newPosition(x, y), o);
   }

   public static Scene newLawn(int x, int y) {
      return new Lawn(newPosition(x, y));
   }

   public static void setup(int x, int y) {
      setup(newLawn(x, y));
   }

   public static void setup(int x, int y, Vehicule... vehicules) {

      /* setup engine & lawn */
      setup(x, y);

      /* add all vehicules */
      for (Vehicule vehicule : vehicules) {
         XEngine.get().attach(vehicule);
      }
   }

}
