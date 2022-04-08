package org.ldclrcq.domain;

import java.time.Duration;

public class Plant {
    private String name;
    private PlantationPattern plantationPattern;
    private Duration timeToHarvest;

    public Plant(String name, PlantationPattern plantationPattern, Duration timeToHarvest) {
        this.name = name;
        this.plantationPattern = plantationPattern;
        this.timeToHarvest = timeToHarvest;
    }

    public Plant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlantationPattern getPlantationPattern() {
        return plantationPattern;
    }

    public void setPlantationPattern(PlantationPattern plantationPattern) {
        this.plantationPattern = plantationPattern;
    }

    public Duration getTimeToHarvest() {
        return timeToHarvest;
    }

    public void setTimeToHarvest(Duration timeToHarvest) {
        this.timeToHarvest = timeToHarvest;
    }
}
