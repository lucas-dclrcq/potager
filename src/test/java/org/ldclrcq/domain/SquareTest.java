package org.ldclrcq.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SquareTest {
    @Test
    void given_square_0_0_and_square_0_0_should_return_0() {
        // ARRANGE
        final var square = new Square(1L, 0L, 0L, null, null);
        final var otherSquare = new Square(1L, 0L, 0L, null, null);

        // ACT
        final var comparison = square.compareTo(otherSquare);

        // ASSERT
        assertThat(comparison).isEqualTo(0);
    }

    @Test
    void given_square_0_0_and_square_0_1_should_return_minus1() {
        // ARRANGE
        final var square = new Square(1L, 0L, 0L, null, null);
        final var otherSquare = new Square(1L, 0L, 1L, null, null);

        // ACT
        final var comparison = square.compareTo(otherSquare);

        // ASSERT
        assertThat(comparison).isEqualTo(-1);
    }

    @Test
    void given_square_0_1_and_square_0_0_should_return_1() {
        // ARRANGE
        final var square = new Square(1L, 0L, 1L, null, null);
        final var otherSquare = new Square(1L, 0L, 0L, null, null);

        // ACT
        final var comparison = square.compareTo(otherSquare);

        // ASSERT
        assertThat(comparison).isEqualTo(1);
    }

    @Test
    void given_square_0_0_and_square_1_0_should_return_minus1() {
        // ARRANGE
        final var square = new Square(1L, 0L, 0L, null, null);
        final var otherSquare = new Square(1L, 1L, 0L, null, null);

        // ACT
        final var comparison = square.compareTo(otherSquare);

        // ASSERT
        assertThat(comparison).isEqualTo(-1);
    }

    @Test
    void given_square_1_0_and_square_0_0_should_return_1() {
        // ARRANGE
        final var square = new Square(1L, 1L, 0L, null, null);
        final var otherSquare = new Square(1L, 0L, 0L, null, null);

        // ACT
        final var comparison = square.compareTo(otherSquare);

        // ASSERT
        assertThat(comparison).isEqualTo(1);
    }

    @Test
    void given_x_and_y_should_create_default_square() {
        // ARRANGE
        long x = 0;
        long y = 1;

        // ACT
        final var square = Square.create(x, y);

        // ASSERT
        assertThat(square)
                .extracting(
                        Square::getId,
                        Square::getPositionX,
                        Square::getPositionY,
                        Square::getPlantation,
                        Square::getType
                ).containsExactly(
                        null,
                        0L,
                        1L,
                        null,
                        SquareType.EMPTY
                );
    }
}