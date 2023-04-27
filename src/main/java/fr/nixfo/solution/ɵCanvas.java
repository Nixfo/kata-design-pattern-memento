package fr.nixfo.solution;

import fr.nixfo.Shape;

import java.util.ArrayList;
import java.util.List;

public class ɵCanvas {
    private String name;
    private List<Shape> shapes;

    public ɵCanvas(String name) {
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

    public ɵCanvasMemento saveToMemento() {
        ɵCanvasMementoInternal memento = new ɵCanvasMementoInternal();

        memento.setName(this.name);
        memento.setShapes(List.copyOf(this.shapes));

        return memento;
    }

    public void restoreFromMemento(ɵCanvasMemento memento) {
        var state = (ɵCanvasMementoInternal) memento;

        this.name = state.getName();
        this.shapes = state.getShapes();
    }

    private class ɵCanvasMementoInternal implements ɵCanvasMemento {
        private String name;
        private List<Shape> shapes;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Shape> getShapes() {
            return this.shapes;
        }

        public void setShapes(List<Shape> shapes) {
            this.shapes = shapes;
        }
    }
}
