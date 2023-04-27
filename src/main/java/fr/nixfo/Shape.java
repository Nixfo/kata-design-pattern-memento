package fr.nixfo;

import java.util.List;

public class Shape {
    private String name;
    private List<Position> points;

    public Shape(String name, List<Position> points) {
        this.name = name;
        this.points = points;
    }
}
