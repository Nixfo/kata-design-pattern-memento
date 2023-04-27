package fr.nixfo;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    private String name;
    private List<Shape> shapes;

    public Canvas(String name) {
        this.name = name;
        this.shapes = new ArrayList<>();
    }

    public void modifyName(String newName) {
        this.name = newName;
    }

    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    public String getName() {
        return name;
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
