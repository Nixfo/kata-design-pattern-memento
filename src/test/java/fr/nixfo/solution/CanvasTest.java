package fr.nixfo.solution;

import fr.nixfo.Position;
import fr.nixfo.Shape;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CanvasTest {

    @Test
    void should_create_a_canvas() {
        ɵCanvas canvas = new ɵCanvas("My canvas");

        canvas.addShape(new Shape("Triangle", List.of(new Position(1, 1), new Position(2, 2), new Position(1, 2))));
        canvas.addShape(new Shape("Segment", List.of(new Position(4, 2), new Position(3, 4))));
        canvas.modifyName("My modified canvas");

        assertEquals("My modified canvas has 2 shapes.", canvas.display());
    }


    @Test
    void should_restore_canvas_from_last_memento() {
        ɵCanvas canvas = new ɵCanvas("My canvas");

        canvas.addShape(new Shape("Triangle", List.of(new Position(1, 1), new Position(2, 2), new Position(1, 2))));
        canvas.addShape(new Shape("Segment", List.of(new Position(4, 2), new Position(3, 4))));
        canvas.addShape(new Shape("Square", List.of(new Position(1, 1), new Position(1, 2), new Position(2, 2), new Position(2, 1))));

        ɵCanvasMemento memento = canvas.saveToMemento();

        canvas.modifyName("My modified canvas");

        canvas.restoreFromMemento(memento);

        assertEquals("My canvas has 3 shapes.", canvas.display());
    }


    @Test
    void should_restore_canvas_from_first_memento() {
        ɵCanvas canvas = new ɵCanvas("My canvas");

        ɵCanvasMemento memento = canvas.saveToMemento();

        canvas.addShape(new Shape("Triangle", List.of(new Position(1, 1), new Position(2, 2), new Position(1, 2))));
        canvas.addShape(new Shape("Segment", List.of(new Position(4, 2), new Position(3, 4))));
        canvas.addShape(new Shape("Square", List.of(new Position(1, 1), new Position(1, 2), new Position(2, 2), new Position(2, 1))));

        ɵCanvasMemento mementoUnused = canvas.saveToMemento();

        canvas.modifyName("My modified canvas");

        canvas.restoreFromMemento(memento);

        assertEquals("My canvas has 0 shapes.", canvas.display());
    }
}
