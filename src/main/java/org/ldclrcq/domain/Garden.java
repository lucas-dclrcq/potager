package org.ldclrcq.domain;

import java.util.List;

public class Garden {
    private Long id;
    private String name;
    private Long width;
    private Long height;
    private List<Square> tiles;

    public Garden(String name, Long width, Long height, List<Square> tiles) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.tiles = tiles;
    }

    public Garden() {
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

    public List<Square> getTiles() {
        return tiles;
    }

    public void setTiles(List<Square> tiles) {
        this.tiles = tiles;
    }
}
