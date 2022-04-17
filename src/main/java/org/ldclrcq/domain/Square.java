package org.ldclrcq.domain;

import java.util.List;
import java.util.Objects;

public class Square implements Comparable<Square> {
    private Long id;
    private Long positionX;
    private Long positionY;

    private Long gardenId;

    private List<Plantation> plantation;
    private SquareType type;
    public Square(Long id, Long positionX, Long positionY, List<Plantation> plantation, SquareType type) {
        this.id = id;
        this.positionX = positionX;
        this.positionY = positionY;
        this.plantation = plantation;
        this.type = type;
    }

    public Square() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGardenId() {
        return gardenId;
    }

    public void setGardenId(Long gardenId) {
        this.gardenId = gardenId;
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

    public SquareType getType() {
        return type;
    }

    public void setType(SquareType type) {
        this.type = type;
    }

    public static Square create(Long x, Long y) {
        return new Square(null, x, y, null, SquareType.EMPTY);
    }

    @Override
    public int compareTo(Square o) {
        if (Objects.equals(o.getPositionY(), this.getPositionY())) {
            return this.getPositionX().compareTo(o.getPositionX());
        }

        if (this.getPositionY() < o.getPositionY()) {
            return -1;
        }

        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        Square square = (Square) o;
        return Objects.equals(getId(), square.getId()) && Objects.equals(getPositionX(), square.getPositionX()) && Objects.equals(getPositionY(), square.getPositionY()) && Objects.equals(getPlantation(), square.getPlantation()) && getType() == square.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPositionX(), getPositionY(), getPlantation(), getType());
    }
}