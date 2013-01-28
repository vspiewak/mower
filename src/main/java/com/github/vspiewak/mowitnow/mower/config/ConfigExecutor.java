package com.github.vspiewak.mowitnow.mower.config;

import java.util.ArrayList;
import java.util.List;

import com.github.vspiewak.mowitnow.mower.api.Engine;
import com.github.vspiewak.mowitnow.mower.domain.Lawn;
import com.github.vspiewak.mowitnow.mower.domain.Mower;
import com.github.vspiewak.mowitnow.mower.domain.XEngine;

/**
 * Sequential configuration executor
 *  
 * @author Vincent Spiewak
 * @since 1.0
 */
public class ConfigExecutor {

   public static final String LINE_SEPARATOR = System.getProperty("line.separator");

   private List<Mower> mowers = new ArrayList<Mower>();

   public void execute(Config config) {

      /* init engine */
      Engine engine = XEngine.get();
      engine.init(new Lawn(config.getLawnTopRightCorner()));

      /* for each mowers */
      for (MowerConfig mowerConfig : config.getMowerConfig()) {

         /* init mower */
         Mower mower = new Mower(mowerConfig.getInitialPosition(),
               mowerConfig.getInitialOrientation());

         /* collecting mower */
         mowers.add(mower);

         /* attach to the engine */
         engine.attach(mower);

         /* run every commands */
         for (MowerCommand command : mowerConfig.getCommands()) {
            command.execute(mower, command);
         }

      }

   }

   public String printMowers() {

      StringBuilder result = new StringBuilder();
      
      /* print each mower */
      for (Mower mower : this.mowers) {
         result.append(mower.print()).append(LINE_SEPARATOR);
      }
      
      /* remove last break line */
      result.setLength(result.length() - LINE_SEPARATOR.length());
      
      return result.toString();

   }

}
