package org.ldclrcq.domain;

import java.time.Duration;
import java.util.Set;

public class Plant {
    private Long id;
    private String name;
    private PlantationPattern plantationPattern;
    private Duration timeToHarvest;

    private Set<Plant> positiveAssociations;

    private Set<Plant> negativeAssociations;

    public Plant(String name, PlantationPattern plantationPattern, Duration timeToHarvest) {
        this.name = name;
        this.plantationPattern = plantationPattern;
        this.timeToHarvest = timeToHarvest;
    }

    public Plant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
