package com.github.vspiewak.mowitnow.mower.base;

import org.testng.annotations.Test;
import com.github.vspiewak.mowitnow.mower.exceptions.ParseException;
import static org.fest.assertions.Assertions.assertThat;

public class OrientationTest {

    @Test
    public void given_north_orientation_rotate_left_expect_west() {

        assertThat(Orientation.NORTH.rotate(Rotation.LEFT)).isEqualTo(Orientation.WEST);

    }

    @Test
    public void given_west_orientation_rotate_left_expect_south() {

        assertThat(Orientation.WEST.rotate(Rotation.LEFT)).isEqualTo(Orientation.SOUTH);

    }

    @Test
    public void given_south_orientation_rotate_left_expect_east() {

        assertThat(Orientation.SOUTH.rotate(Rotation.LEFT)).isEqualTo(Orientation.EAST);

    }

    @Test
    public void given_east_orientation_rotate_left_expect_north() {

        assertThat(Orientation.EAST.rotate(Rotation.LEFT)).isEqualTo(Orientation.NORTH);

    }

    @Test
    public void given_north_orientation_rotate_right_expect_east() {

        assertThat(Orientation.NORTH.rotate(Rotation.RIGHT)).isEqualTo(Orientation.EAST);

    }

    @Test
    public void given_east_orientation_rotate_right_expect_south() {

        assertThat(Orientation.EAST.rotate(Rotation.RIGHT)).isEqualTo(Orientation.SOUTH);

    }

    @Test
    public void given_south_orientation_rotate_right_expect_weast() {

        assertThat(Orientation.SOUTH.rotate(Rotation.RIGHT)).isEqualTo(Orientation.WEST);

    }

    @Test
    public void given_west_orientation_rotate_right_expect_north() {

        assertThat(Orientation.WEST.rotate(Rotation.RIGHT)).isEqualTo(Orientation.NORTH);

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void given_an_orientation_rotate_null_expect_exception() {

        Orientation.NORTH.rotate(null);
    }

    @Test
    public void given_a_string_containing_n_expect_parse_return_orientation_north() throws ParseException {

        assertThat(Orientation.parseOrientation("N")).isEqualTo(Orientation.NORTH);

    }

    @Test(expectedExceptions = ParseException.class)
    public void given_a_string_containing_hello_expect_parse_return_parse_exception() throws ParseException {

        Orientation.parseOrientation("hello");

    }

    @Test(expectedExceptions = ParseException.class)
    public void given_a_string_null_expect_parse_return_parse_exception() throws ParseException {

        Orientation.parseOrientation(null);

    }
}
