package com.github.vspiewak.mowitnow.mower.setup;

import com.github.vspiewak.mowitnow.mower.exceptions.ParseException;

public interface AppSetupBuilder {

   void parse() throws ParseException;

   AppSetup getSetup();

}