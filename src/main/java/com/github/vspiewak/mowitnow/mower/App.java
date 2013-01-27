package com.github.vspiewak.mowitnow.mower;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.vspiewak.mowitnow.mower.exceptions.ParseException;
import com.github.vspiewak.mowitnow.mower.setup.AppSetup;
import com.github.vspiewak.mowitnow.mower.setup.AppSetupBuilder;
import com.github.vspiewak.mowitnow.mower.setup.AppSetupFileBuilder;

/**
 * This is the main entry for the application.
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
public final class App {

   private static final Logger LOG = LoggerFactory.getLogger(App.class);
   
   /* exit status */
   public static final int EXIT_SUCCESS = 0;
   public static final int EXIT_FAILURE_BAD_ARGS = 1;
   public static final int EXIT_FAILURE_CANT_READ_FILE = 2;
   private static final int EXIT_FAILURE_PARSE_EXCEPTION = 3;

   /* printed help */
   private static final String HELP_USAGE = "Mower: usage ...";

   /* hide utility class constructor */
   private App() { }
   
   /**
    * Run the application
    * 
    * @param arguments from command line
    * @return exit status
    */
   public static int run(String... args) {

            /* print help if bad args (double check) */
      if (args.length != 1 || args[0] == null) {

         LOG.info(HELP_USAGE);
         return EXIT_FAILURE_BAD_ARGS;

      }

      /* handle file */
      File file = new File(args[0]);

      /* check file */
      if (!file.canRead()) {
         LOG.error("Can't read the file '{}' at '{}'", file.getName(), file.getAbsolutePath());
         return EXIT_FAILURE_CANT_READ_FILE;
      }

      /* parse file */
      try {

         AppSetupBuilder build = new AppSetupFileBuilder(file);
         build.parse();

         AppSetup setup = build.getSetup();
         String result = setup.execute();

         /* log/print the result */
         LOG.info("{}", result);

      } catch (ParseException e) {
         LOG.error("Parsing error : " + e);
         return EXIT_FAILURE_PARSE_EXCEPTION;
      }

      return EXIT_SUCCESS;
   }

   public static void main(String... args) {

      int exitStatus = run(args);
      System.exit(exitStatus);

   }

}
