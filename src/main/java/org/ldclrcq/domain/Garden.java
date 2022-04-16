package org.ldclrcq.domain;

import java.util.*;

public class Garden {
    private Long id;
    private String ownerId;
    private String name;
    private Long width;
    private Long height;
    private List<Square> squares;

    public Garden(String ownerId, String name, Long width, Long height, List<Square> squares) {
        this.ownerId = ownerId;
        this.name = name;
        this.width = width;
        this.height = height;
        this.squares = squares;
    }

    public Garden() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public List<Square> getSquares() {
        return squares;
    }

    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }

    public List<GardenRow> getSquaresByRow() {
        if (squares == null) {
            return null;
        }

        final Map<Long, GardenRow> rows = new HashMap<>();

        for (var square : squares) {
            if (!rows.containsKey(square.getPositionY())) {
                rows.put(square.getPositionY(), new GardenRow(new TreeSet<>()));
            }

            rows.get(square.getPositionY()).squares().add(square);
        }

        return rows.values().stream().toList();
    }

    public void createSquares() {
        if (this.squares != null) {
            throw new IllegalStateException("Cannot generate squares because this garden has some already");
        }

        if (this.height == null || this.width == null) {
            throw new IllegalStateException("Cannot generate squares because this garden has no height or width");
        }

        this.squares = new ArrayList<>();

        for (long row = 0; row < height; row++) {
            for (long column = 0; column < width; column++) {
                this.squares.add(Square.create(column, row));
            }
        }
    }
}
