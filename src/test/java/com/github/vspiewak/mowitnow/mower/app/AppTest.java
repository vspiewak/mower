package com.github.vspiewak.mowitnow.mower.app;

import static org.fest.assertions.Assertions.assertThat;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


/**
 * Tests for the <code>App</code> class.
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
public class AppTest {

   @Test
   public void launch_app_no_arguments() {

      String args[] = new String[0];
      int exitStatus = App.run(args);

      assertThat(exitStatus).isEqualTo(App.EXIT_FAILURE_BAD_ARGS);
   }

   @Test
   public void launch_app_bad_file() {

      String args[] = { "" };
      int exitStatus = App.run(args);

      assertThat(exitStatus).isEqualTo(App.EXIT_FAILURE_CANT_READ_FILE);
   }

    @Test
    public static void launch_app_with_empty_file() throws IOException {

        File tempFile = File.createTempFile(App.class.getSimpleName(), ".txt");

        String args[] = { tempFile.getAbsolutePath() };
        int exitStatus = App.run(args);

        assertThat(exitStatus).isEqualTo(App.EXIT_FAILURE_PARSE_EXCEPTION);

    }

   @Test
   public static void launch_app_with_file() {

      String args[] = { "src/test/resources/commands.txt" };
      int exitStatus = App.run(args);

      assertThat(exitStatus).isEqualTo(App.EXIT_SUCCESS);

   }

   public static void main(String... args) {
      launch_app_with_file();
   }

}
