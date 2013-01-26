package com.github.vspiewak.mowitnow.mower.setup;

import com.github.vspiewak.mowitnow.mower.exceptions.ParseException;
import com.github.vspiewak.mowitnow.mower.setup.AppSetup;

public interface AppSetupBuilder {

	public void parse() throws ParseException;

	public AppSetup getSetup();

}