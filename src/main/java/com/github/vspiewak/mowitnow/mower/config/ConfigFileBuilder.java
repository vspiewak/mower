package com.github.vspiewak.mowitnow.mower.config;

import java.io.File;
import java.util.Scanner;

import com.github.vspiewak.mowitnow.mower.base.Orientation;
import com.github.vspiewak.mowitnow.mower.base.Position;
import com.github.vspiewak.mowitnow.mower.exceptions.ParseException;

/**
 * File based configuration builder.
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
public class ConfigFileBuilder implements ConfigBuilder {

   /* UTF-8 only */
   public static final String CHARSET_UTF_8 = "UTF-8";

   private File file;
   private Config config;

   public ConfigFileBuilder(File file) {

      this.config = new Config();
      this.file = file;
   }

   /**
    * Parse the file according to the specifications format
    */
   @Override
   public void parse() throws ParseException {

      /* parse file */
      try {

         Scanner scanner = new Scanner(file, CHARSET_UTF_8);

         MowerConfig mowerConfig = null;

         int lineNumber = 1;

         do {

            boolean even = lineNumber % 2 == 0;
            String line = scanner.nextLine();

            /* if nothing in the file */
            if ((line == null || line.isEmpty()) && lineNumber == 1) {

                throw new ParseException("Nothing found in the file: " + file);

            /* first line: lawn top right position */
            } else if(lineNumber == 1) {

               Position lawnTopRight = Position.parsePosition(line);
               config.setLawnTopRightCorner(lawnTopRight);

            /* even line: mower init */
            } else if (even) {

               int lastWhitespace = line.lastIndexOf(' ');
               Position p = Position.parsePosition(line.substring(0, lastWhitespace));
               Orientation o = Orientation.parseOrientation(line.substring(lastWhitespace).trim());

               mowerConfig = new MowerConfig();
               mowerConfig.setInitialPosition(p);
               mowerConfig.setInitialOrientation(o);

            /* odd line: mower commands */
            } else {

               mowerConfig.setCommands(MowerCommand.parseCommands(line));
               config.addMowerConfig(mowerConfig);
            }

            lineNumber++;

         } while(scanner.hasNextLine());


      } catch (Exception e) {
         throw new ParseException("Exception: " + e.getMessage());
      }

   }

   @Override
   public Config getConfig() {
      return this.config;
   }

}
