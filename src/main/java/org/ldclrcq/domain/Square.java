package org.ldclrcq.domain;

import java.util.List;

public class Square {
    private Long positionX;
    private Long positionY;
    private List<Plantation> plantation;
    private Garden garden;

    public Square(Long positionX, Long positionY, List<Plantation> plantation, Garden garden) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.plantation = plantation;
        this.garden = garden;
    }

    public Square() {
    }

    public Long getPositionX() {
        return positionX;
    }

    public void setPositionX(Long positionX) {
        this.positionX = positionX;
    }

    public Long getPositionY() {
        return positionY;
    }

    public void setPositionY(Long positionY) {
        this.positionY = positionY;
    }

    public List<Plantation> getPlantation() {
        return plantation;
    }

    public void setPlantation(List<Plantation> plantation) {
        this.plantation = plantation;
    }

    public Garden getGarden() {
        return garden;
    }

    public void setGarden(Garden garden) {
        this.garden = garden;
    }
}