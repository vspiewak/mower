package com.github.vspiewak.mowitnow.mower.exceptions;

/**
 * This ParseException can be thrown during <code>AppSetup</code> parsing.
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
public class ParseException extends Exception {

   private static final long serialVersionUID = 7778419683047315807L;

   public ParseException(String message) {
      super(message);
   }

}