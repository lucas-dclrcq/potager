package org.ldclrcq.application.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.ldclrcq.application.port.in.CultivateSquare;
import org.ldclrcq.application.port.out.SquareRepository;
import org.ldclrcq.domain.Square;
import org.ldclrcq.domain.SquareType;
import org.ldclrcq.domain.exception.NotFoundException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CultivateSquareUsecaseTest {

    CultivateSquare usecase;
    SquareRepository squareRepository;

    @BeforeEach
    void setup() {
        this.squareRepository = mock(SquareRepository.class);
        this.usecase = new CultivateSquareUsecase(squareRepository);
    }

    @Test
    void given_existing_square_should_set_to_cultivated() throws NotFoundException {
        // ARRANGE
        when(squareRepository.findByIdAndOwner(anyLong(), anyString()))
                .thenReturn(Optional.of(new Square(1L, 2L, 2L, null, SquareType.EMPTY)));
        when(squareRepository.update(any()))
                .thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0, Square.class));

        // ACT
        final var updatedSquare = usecase.execute("abc", 1L);

        // ASSERT
        assertThat(updatedSquare)
                .extracting(
                        Square::getType
                ).isEqualTo(SquareType.CULTIVATED);
        verify(squareRepository).findByIdAndOwner(1L, "abc");
    }

    @Test
    void given_unknown_square_should_throw() {
        // ARRANGE
        when(squareRepository.findByIdAndOwner(anyLong(), anyString()))
                .thenReturn(Optional.empty());

        // ACT
        // ASSERT
        assertThatThrownBy(() -> usecase.execute("abc", 1L))
                .isInstanceOf(NotFoundException.class);
        verify(squareRepository).findByIdAndOwner(1L, "abc");
    }
}