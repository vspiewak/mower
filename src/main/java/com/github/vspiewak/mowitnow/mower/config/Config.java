package com.github.vspiewak.mowitnow.mower.config;

import java.util.ArrayList;
import java.util.List;

import com.github.vspiewak.mowitnow.mower.base.Position;

/**
 * This class represent the application configuration.
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
public class Config {

   private Position lawnTopRightCorner;
   private List<MowerConfig> mowerConfigList;

   public Config() {
      mowerConfigList = new ArrayList<MowerConfig>();
   }

   public Position getLawnTopRightCorner() {
      return lawnTopRightCorner;
   }

   public void setLawnTopRightCorner(Position lawnTopRightCorner) {
      this.lawnTopRightCorner = lawnTopRightCorner;
   }

   public List<MowerConfig> getMowerConfig() {
      return mowerConfigList;
   }

   public void addMowerConfig(MowerConfig config) {
      this.mowerConfigList.add(config);
   }

}
