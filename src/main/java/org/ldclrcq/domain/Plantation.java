package org.ldclrcq.domain;

import java.time.LocalDate;

public class Plantation {
    private Square square;
    private Plant plant;
    private LocalDate plannedDate;
    private LocalDate plantationDate;
    private LocalDate harvestDate;
    private PlantationType type;

    public Plantation(Square square, Plant plant, LocalDate plannedDate, LocalDate plantationDate, LocalDate harvestDate, PlantationType type) {
        this.square = square;
        this.plant = plant;
        this.plannedDate = plannedDate;
        this.plantationDate = plantationDate;
        this.harvestDate = harvestDate;
        this.type = type;
    }

    public Plantation() {
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public LocalDate getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(LocalDate plannedDate) {
        this.plannedDate = plannedDate;
    }

    public LocalDate getPlantationDate() {
        return plantationDate;
    }

    public void setPlantationDate(LocalDate plantationDate) {
        this.plantationDate = plantationDate;
    }

    public LocalDate getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(LocalDate harvestDate) {
        this.harvestDate = harvestDate;
    }

    public PlantationType getType() {
        return type;
    }

    public void setType(PlantationType type) {
        this.type = type;
    }
}
