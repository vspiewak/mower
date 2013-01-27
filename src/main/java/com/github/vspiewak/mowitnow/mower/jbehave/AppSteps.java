package com.github.vspiewak.mowitnow.mower.jbehave;

import static com.github.vspiewak.mowitnow.mower.app.AppFactory.newPosition;
import static org.fest.assertions.Assertions.assertThat;

import com.github.vspiewak.mowitnow.mower.config.Config;
import com.github.vspiewak.mowitnow.mower.config.MowerConfig;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.embedder.Embedder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.vspiewak.mowitnow.mower.base.Orientation;
import com.github.vspiewak.mowitnow.mower.config.MowerCommand;
import com.github.vspiewak.mowitnow.mower.exceptions.ParseException;

/**
 * JBehave application step builder
 *  
 * @author Vincent Spiewak
 * @since 1.0
 */
public class AppSteps extends Embedder {

   private static final Logger LOG = LoggerFactory.getLogger(AppSteps.class);

   private Config config = new Config();
   private MowerConfig currentMowerConfig;

   @Given("a lawn with a top right corner at $x $y")
   @Alias("a lawn $x $y")
   public void givenATopRightCorner(@Named("x") int x, @Named("y") int y) {
      config = new Config();
      config.setLawnTopRightCorner(newPosition(x, y));
   }

   @When("a mower starting at $x $y $o")
   @Alias("a mower $x $y $o")
   public void givenAMowerAt(@Named("x") int x, @Named("y") int y, @Named("o") String o)
         throws ParseException {

      currentMowerConfig = new MowerConfig();
      currentMowerConfig.setInitialPosition(newPosition(x, y));
      currentMowerConfig.setInitialOrientation(Orientation.parseOrientation(o));
   }

   @When("a list of commands $value")
   @Alias("doing $value")
   public void givenAListOfCommands(@Named("value") String value)
           throws ParseException {

      currentMowerConfig.setCommands(MowerCommand.parseCommands(value));
      config.addMowerConfig(currentMowerConfig);
   }

   @Then("the program should print $value")
   @Alias("it should print $value")
   public void thenAppShouldPrint(@Named("value") String expected) {

      String actual = config.execute();

      LOG.info("* JBehave assertion: ");
      LOG.info("-> actual:\n{}", actual);
      LOG.info("-> expected:\n{}", expected);

      assertThat(actual).isEqualTo(expected);
   }

}
