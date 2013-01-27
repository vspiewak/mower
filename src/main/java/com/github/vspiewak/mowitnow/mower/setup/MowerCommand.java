package com.github.vspiewak.mowitnow.mower.setup;

import java.util.ArrayList;
import java.util.List;

import com.github.vspiewak.mowitnow.mower.base.Direction;
import com.github.vspiewak.mowitnow.mower.base.Rotation;
import com.github.vspiewak.mowitnow.mower.domain.Mower;
import com.github.vspiewak.mowitnow.mower.exceptions.ParseException;

/**
 * This represent a <code>Mower</code> command.
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
public enum MowerCommand {

   ROTATE_LEFT('G'), ROTATE_RIGHT('D'), MOVE_FORWARD('A');

   private char code;

   private MowerCommand(char code) {
      this.code = code;
   }

   public char getCode() {
      return this.code;
   }

   /**
    * Execute a <code>MowerCommand</code> on the given <code>Mower</code>
    * 
    * @param mower
    * @param command
    */
   public void execute(Mower mower, MowerCommand command) {

      switch (command) {
      case ROTATE_LEFT:
         mower.rotate(Rotation.LEFT);
         break;
      case ROTATE_RIGHT:
         mower.rotate(Rotation.RIGHT);
         break;
      case MOVE_FORWARD:
         mower.move(Direction.FORWARD);
         break;
      default:
         throw new IllegalArgumentException("Mower command unsupported: " + command);
      }

   }

   public static MowerCommand parseCommand(char c) throws ParseException {

      for (MowerCommand cmd : values()) {
         if (cmd.getCode() == c) {
            return cmd;
         }
      }

      throw new ParseException("Parse MowerCommand error: " + c);
   }

   public static List<MowerCommand> parseCommands(String s) throws ParseException {

      List<MowerCommand> commands = new ArrayList<MowerCommand>();

      if (s != null && s.length() > 0) {

         for (char c : s.toCharArray()) {
            commands.add(parseCommand(c));
         }

         return commands;
      }

      throw new ParseException("Parse MowerCommand(s) error: " + s);
   }

}
