package com.github.vspiewak.mowitnow.mower.base;

import static com.github.vspiewak.mowitnow.mower.AppFactory.newPosition;
import static org.fest.assertions.Assertions.assertThat;

import org.testng.annotations.Test;

import com.github.vspiewak.mowitnow.mower.exceptions.ParseException;

/**
 * Tests for the <code>Position</code> class.
 * 
 * @author Vincent Spiewak
 * @since 1.0
 */
public class PositionTest {

   @Test
   public void given_position_1_2_north_next_forward_expect_1_3() {

      assertThat(newPosition(1, 2).next(Direction.FORWARD, Orientation.NORTH)).isEqualTo(newPosition(1, 3));
   }

   @Test
   public void given_position_1_2_south_next_forward_expect_1_1() {

      assertThat(newPosition(1, 2).next(Direction.FORWARD, Orientation.SOUTH)).isEqualTo(newPosition(1, 1));
   }

   @Test
   public void given_position_1_2_east_next_forward_expect_2_2() {

      assertThat(newPosition(1, 2).next(Direction.FORWARD, Orientation.EAST)).isEqualTo(newPosition(2, 2));
   }

   @Test
   public void given_position_1_2_west_next_forward_expect_0_2() {

      assertThat(newPosition(1, 2).next(Direction.FORWARD, Orientation.WEST)).isEqualTo(newPosition(0, 2));

   }

   @Test
   public void given_a_string_containing_10_300_expect_parse_return_position_10_300() throws ParseException {

      assertThat(Position.parsePosition("10 300")).isEqualTo(newPosition(10, 300));

   }

   @Test(expectedExceptions = ParseException.class)
   public void given_a_string_expect_parse_return_parse_exception() throws ParseException {

      Position.parsePosition("github");

   }

   @Test(expectedExceptions = ParseException.class)
   public void given_a_string_null_expect_parse_return_parse_exception() throws ParseException {

      Position.parsePosition(null);

   }

   @Test(expectedExceptions = IllegalArgumentException.class)
   public void given_position_0_0_orientation_null_next_forward_expect_exception() {

      newPosition(0, 0).next(Direction.FORWARD, null);

   }

   @Test(expectedExceptions = IllegalArgumentException.class)
   public void given_position_0_0_orientation_north_next_null_expect_exception() {

      newPosition(0, 0).next(null, Orientation.NORTH);

   }

   @Test(expectedExceptions = IllegalArgumentException.class)
   public void given_position_0_0_orientation_null_null_next_expect_exception() {

      newPosition(0, 0).next(null, null);

   }
}
