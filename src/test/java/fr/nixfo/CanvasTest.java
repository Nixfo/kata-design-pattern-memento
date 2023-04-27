package fr.nixfo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CanvasTest {

    @Test
    void should_create_a_canvas() {
        Canvas canvas = new Canvas("My canvas");

        canvas.addShape(new Shape("Triangle", List.of(new Position(1, 1), new Position(2, 2), new Position(1, 2))));
        canvas.addShape(new Shape("Segment", List.of(new Position(4, 2), new Position(3, 4))));
        canvas.modifyName("My modified canvas");

        assertEquals("My modified canvas", canvas.getName());
        assertEquals(2, canvas.getShapes().size());
    }


    @Test
    void should_restore_canvas_from_last_memento() {
        Canvas canvas = new Canvas("My canvas");

        canvas.addShape(new Shape("Triangle", List.of(new Position(1, 1), new Position(2, 2), new Position(1, 2))));
        canvas.addShape(new Shape("Segment", List.of(new Position(4, 2), new Position(3, 4))));
        canvas.addShape(new Shape("Square", List.of(new Position(1, 1), new Position(1, 2), new Position(2, 2), new Position(2, 1))));

        // TODO create a memento here

        canvas.modifyName("My modified canvas");

        // TODO restore from the memento here

        assertEquals("My canvas", canvas.getName());
        assertEquals(3, canvas.getShapes().size());
    }


    @Test
    void should_restore_canvas_from_first_memento() {
        Canvas canvas = new Canvas("My canvas");

        // TODO create a memento here

        canvas.addShape(new Shape("Triangle", List.of(new Position(1, 1), new Position(2, 2), new Position(1, 2))));
        canvas.addShape(new Shape("Segment", List.of(new Position(4, 2), new Position(3, 4))));
        canvas.addShape(new Shape("Square", List.of(new Position(1, 1), new Position(1, 2), new Position(2, 2), new Position(2, 1))));

        // TODO create a memento here

        canvas.modifyName("My modified canvas");

        // TODO restore from the memento here

        assertEquals("My canvas", canvas.getName());
        assertEquals(0, canvas.getShapes().size());
    }
}
