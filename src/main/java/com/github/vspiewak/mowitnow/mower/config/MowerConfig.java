package com.github.vspiewak.mowitnow.mower.config;

import java.util.List;

import com.github.vspiewak.mowitnow.mower.base.Orientation;
import com.github.vspiewak.mowitnow.mower.base.Position;

/**
 * This represent a <code>Mower</code> configuration.
 * It include initial position/orientation and commands.
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
public class MowerConfig {

   private Position initialPosition;
   private Orientation initialOrientation;

   private List<MowerCommand> commands;

   public Position getInitialPosition() {
      return initialPosition;
   }

   public void setInitialPosition(Position initialPosition) {
      this.initialPosition = initialPosition;
   }

   public Orientation getInitialOrientation() {
      return initialOrientation;
   }

   public void setInitialOrientation(Orientation initialOrientation) {
      this.initialOrientation = initialOrientation;
   }

   public List<MowerCommand> getCommands() {
      return commands;
   }

   public void setCommands(List<MowerCommand> commands) {
      this.commands = commands;
   }

}
