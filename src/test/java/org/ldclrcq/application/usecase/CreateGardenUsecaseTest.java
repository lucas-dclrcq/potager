package org.ldclrcq.application.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.ldclrcq.application.port.in.CreateGarden;
import org.ldclrcq.application.port.out.GardenRepository;
import org.ldclrcq.domain.Garden;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CreateGardenUsecaseTest {
    GardenRepository gardenRepository;
    CreateGarden createGarden;

    @BeforeEach
    void setup() {
        gardenRepository = mock(GardenRepository.class);
        createGarden = new CreateGardenUsecase(gardenRepository);
    }

    @Test
    void should_create_garden() {
        // ARRANGE
        final var toCreate = new Garden();
        toCreate.setName("My beautiful garden");
        toCreate.setHeight(1L);
        toCreate.setWidth(2L);
        when(gardenRepository.create(any())).thenAnswer(invocationOnMock -> {
            final var argument = invocationOnMock.getArgument(0, Garden.class);
            argument.setId(22L);
            return argument;
        });

        // ACT
        final var created = createGarden.execute(toCreate);

        // ASSERT
        assertThat(created)
                .extracting(Garden::getId, Garden::getName, Garden::getHeight, Garden::getWidth)
                .containsExactly(22L, "My beautiful garden", 1L, 2L);
        verify(gardenRepository).create(toCreate);
    }
}