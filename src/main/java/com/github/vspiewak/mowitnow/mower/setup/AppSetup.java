package com.github.vspiewak.mowitnow.mower.setup;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.vspiewak.mowitnow.mower.api.Engine;
import com.github.vspiewak.mowitnow.mower.base.Position;
import com.github.vspiewak.mowitnow.mower.domain.Lawn;
import com.github.vspiewak.mowitnow.mower.domain.Mower;
import com.github.vspiewak.mowitnow.mower.domain.XEngine;

public class AppSetup {

   private static final Logger log = LoggerFactory.getLogger(AppSetup.class);

   /* CRLF evilness... */
   public static final String LINE_SEPARATOR = System.getProperty("line.separator");

   private Position lawnTopRightCorner;
   private List<MowerSetup> mowerSetupList;

   public AppSetup() {
      mowerSetupList = new ArrayList<MowerSetup>();
   }

   public Position getLawnTopRightCorner() {
      return lawnTopRightCorner;
   }

   public void setLawnTopRightCorner(Position lawnTopRightCorner) {
      this.lawnTopRightCorner = lawnTopRightCorner;
   }

   public List<MowerSetup> getMowerSetup() {
      return mowerSetupList;
   }

   public void addMowerSetup(MowerSetup setup) {
      this.mowerSetupList.add(setup);
   }

   public String execute() {

      /* hold result */
      StringBuilder result = new StringBuilder();

      /* init engine */
      Engine engine = XEngine.get();
      engine.init(new Lawn(getLawnTopRightCorner()));

      List<Mower> mowers = new ArrayList<Mower>();

      /* for each mowers */
      for (MowerSetup mowerSetup : mowerSetupList) {

         /* init mower */
         Mower mower = new Mower(mowerSetup.getInitialPosition(),
               mowerSetup.getInitialOrientation());

         /* attach to the engine */
         engine.attach(mower);

         /* adding to the list */
         mowers.add(mower);

         /* run every commands */
         for (MowerCommand command : mowerSetup.getCommands()) {
            command.execute(mower, command);
         }

      }

      /* collect each mower.print() */
      if (!mowers.isEmpty()) {
         for (Mower mower : mowers) {
            result.append(mower.print()).append(LINE_SEPARATOR);
         }
         /* remove last breakline */
         result.setLength(result.length() - LINE_SEPARATOR.length());
      }

      return result.toString();

   }

}
