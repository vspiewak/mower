package com.github.vspiewak.mowitnow.mower.config;

import com.github.vspiewak.mowitnow.mower.exceptions.ParseException;

/**
 * This Builder interface for the application configuration.
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
public interface ConfigBuilder {

   /**
    * Parse and build a configuration.
    * 
    * @throws ParseException
    */
   void parse() throws ParseException;

   /**
    * Accessor to retrieve the configuration after parse()
    * 
    * @return the configuration
    * @see #parse()
    */
   Config getConfig();

}