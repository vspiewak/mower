package com.github.vspiewak.mowitnow.mower.domain;

import static com.github.vspiewak.mowitnow.mower.AppFactory.newLawn;
import static com.github.vspiewak.mowitnow.mower.AppFactory.newPosition;
import static org.fest.assertions.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.vspiewak.mowitnow.mower.base.Position;

public class LawnTest {

   @Test
   public void given_lawn_2_3_expect_position_1_2_inside() {

      assertThat(newLawn(2, 3).canMove(newPosition(1, 2))).isEqualTo(true);

   }

   @Test
   public void given_lawn_2_3_expect_position_x_negative_outside() {

      assertThat(newLawn(2, 3).canMove(newPosition(-1, 2))).isEqualTo(false);

   }

   @Test(dataProvider = "positions_inside_lawn_2_3_provider")
   public void given_a_lawn_2_3_expect_range_0_0_to_2_3_is_inside(Position position) {

      assertThat(newLawn(2, 3).canMove(position)).isEqualTo(true);

   }

   @Test(dataProvider = "positions_outside_lawn_2_3_provider")
   public void given_a_lawn_2_3_expect_funny_range_is_outside(Position position) {

      assertThat(newLawn(2, 3).canMove(position)).isEqualTo(false);

   }

   @DataProvider(name = "positions_inside_lawn_2_3_provider")
   public Object[][] positions_inside_lawn_2_3_provider() {

      return new Object[][] {

      { newPosition(0, 0) }, 
      { newPosition(0, 1) }, 
      { newPosition(0, 2) },
      { newPosition(0, 3) },
      { newPosition(1, 0) },
      { newPosition(1, 1) },
      { newPosition(1, 2) },
      { newPosition(1, 3) },
      { newPosition(2, 0) },
      { newPosition(2, 1) },
      { newPosition(2, 2) },
      { newPosition(2, 3) },
      
      };
   }

   @DataProvider(name = "positions_outside_lawn_2_3_provider")
   public Object[][] positions_outside_lawn_2_3_provider() {

      return new Object[][] {

      { newPosition(-1, 0) }, 
      { newPosition(0, -1) }, 
      { newPosition(-1, -1) },
      { newPosition(2, 4) }, 
      { newPosition(3, 4) }, 
      { newPosition(3, 3) },

      };
   }

}
