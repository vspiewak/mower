package com.github.vspiewak.mowitnow.mower.domain;

import static com.github.vspiewak.mowitnow.mower.AppFactory.newMower;
import static com.github.vspiewak.mowitnow.mower.AppFactory.newPosition;
import static com.github.vspiewak.mowitnow.mower.AppFactory.setup;
import static org.fest.assertions.Assertions.assertThat;

import org.testng.annotations.Test;

import com.github.vspiewak.mowitnow.mower.api.Vehicule;
import com.github.vspiewak.mowitnow.mower.base.Move;
import com.github.vspiewak.mowitnow.mower.base.Orientation;
import com.github.vspiewak.mowitnow.mower.base.Position;
import com.github.vspiewak.mowitnow.mower.base.Rotation;

/**
 * Tests for the <code>Mower</code> class.
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
public class MowerTest {

   @Test()
   public void given_mower_oriented_north_rotate_left_expect_west_and_not_moved() {

      Position initialPosition = newPosition(2, 2);
      Vehicule mower = newMower(initialPosition, Orientation.NORTH);
      setup(5, 5, mower);
      mower.rotate(Rotation.LEFT);

      assertThat(mower.getOrientation()).isEqualTo(Orientation.WEST);
      assertThat(mower.getPosition()).isEqualTo(initialPosition);

   }

   @Test
   public void given_mower_oriented_east_rotate_right_expect_south_and_not_moved() {

      Position initialPosition = newPosition(2, 2);
      Vehicule mower = newMower(initialPosition, Orientation.EAST);
      setup(5, 5, mower);
      mower.rotate(Rotation.RIGHT);

      assertThat(mower.getOrientation()).isEqualTo(Orientation.SOUTH);
      assertThat(mower.getPosition()).isEqualTo(initialPosition);

   }

   @Test
   public void given_lawn_5_5_mower_2_2_north_forward_expect_2_3() {

      Vehicule mower = newMower(2, 2, Orientation.NORTH);
      setup(5, 5, mower);
      mower.move(Move.FORWARD);

      assertThat(mower.getPosition()).isEqualTo(newPosition(2, 3));

   }

   @Test
   public void given_lawn_5_5_mower_0_0_south_forward_expect_0_0() {

      Vehicule mower = newMower(0, 0, Orientation.SOUTH);
      setup(5, 5, mower);
      mower.move(Move.FORWARD);

      assertThat(mower.getPosition()).isEqualTo(newPosition(0, 0));

   }

   @Test
   public void given_lawn_5_5_mower_5_3_east_forward_expect_5_3() {

      Vehicule mower = newMower(5, 3, Orientation.EAST);
      setup(5, 5, mower);
      mower.move(Move.FORWARD);

      assertThat(mower.getPosition()).isEqualTo(newPosition(5, 3));

   }

   @Test
   public void given_lawn_5_5_mower_4_5_north_forward_expect_4_5() {

      Vehicule mower = newMower(4, 5, Orientation.NORTH);
      setup(5, 5, mower);
      mower.move(Move.FORWARD);

      assertThat(mower.getPosition()).isEqualTo(newPosition(4, 5));

   }

}
