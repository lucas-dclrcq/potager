package org.ldclrcq.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GardenTest {
    @Test
    void given_garden_with_squares_should_group_by_row() {
        // ARRANGE
        final var garden = new Garden();
        garden.setSquares(List.of(
                new Square(4L, 0L, 1L, null, null),
                new Square(1L, 0L, 0L, null, null),
                new Square(3L, 1L, 1L, null, null),
                new Square(2L, 1L, 0L, null, null)
        ));

        // ACT
        final var squaresByRow = garden.getSquaresByRow();

        // ASSERT
        assertThat(squaresByRow.get(0).squares())
                .extracting(Square::getId)
                .containsExactly(1L, 2L);

        assertThat(squaresByRow.get(1).squares())
                .extracting(Square::getId)
                .containsExactly(4L, 3L);
    }

    @Test
    void given_garden_with_height_and_width_should_generate_squares() {
        // ARRANGE
        final var myGarden = new Garden("a-b-c-d", "My garden", 2L, 2L, null);

        // ACT
        myGarden.createSquares();

        // ASSERT
        assertThat(myGarden.getSquares())
                .hasSize(4)
                .containsExactly(
                        Square.create(0L, 0L),
                        Square.create(1L, 0L),
                        Square.create(0L, 1L),
                        Square.create(1L, 1L)
                );
    }

    @Test
    void given_garden_with_no_width_should_throw_exception() {
        // ARRANGE
        final var myGarden = new Garden("a-b-c-d", "My garden", null, 2L, null);

        // ACT
        // ASSERT
        assertThatThrownBy(myGarden::createSquares)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void given_garden_with_no_height_should_throw_exception() {
        // ARRANGE
        final var myGarden = new Garden("a-b-c-d", "My garden", 2L, null, null);

        // ACT
        // ASSERT
        assertThatThrownBy(myGarden::createSquares)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void given_garden_with_squares_should_throw_exception() {
        // ARRANGE
        final var myGarden = new Garden("a-b-c-d", "My garden", 2L, 2L, new ArrayList<>());

        // ACT
        // ASSERT
        assertThatThrownBy(myGarden::createSquares)
                .isInstanceOf(IllegalStateException.class);
    }
}