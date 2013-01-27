package com.github.vspiewak.mowitnow.mower.jbehave;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JBehave application scenario.
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
/* JUnit-runnable JBehave stories */
public class AppScenarios extends JUnitStory {

   private static final Logger LOG = LoggerFactory.getLogger(AppScenarios.class);
   
   /* this requires to start maven from the project directory */
   private static final String JBEHAVE_STORIES_URL = "file://"                   
                                                   + System.getProperty("user.dir")
                                                   + "/src/test/resources/stories/";

   @Override
   public Configuration configuration() {
      URL storyURL = null;
      try {
         storyURL = new URL(JBEHAVE_STORIES_URL);
      } catch (MalformedURLException e) {
         LOG.error("JBehave Stories Malformed URI: ", e);
      }
      return new MostUsefulConfiguration().useStoryLoader(
            new LoadFromRelativeFile(storyURL)).useStoryReporterBuilder(
                        new StoryReporterBuilder().
                           withDefaultFormats());
   }

   @Override
   public List<CandidateSteps> candidateSteps() {
      return new InstanceStepsFactory(configuration(), new AppSteps())
            .createCandidateSteps();
   }

   @Test
   @Override
   public void run() throws Throwable {
      super.run();
   }
}
