package org.jhotdraw.draw;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BezierToolTest {

    private DefaultDrawing drawing;
    private BezierFigure bezierFigure;

    @Before
    public void setUp() throws Exception {
        System.out.println("Setting up.");
        drawing = new DefaultDrawing();
        bezierFigure = new BezierFigure();
        drawing.add(bezierFigure);
        bezierFigure = new BezierFigure();
        drawing.add(bezierFigure);
        assertTrue(drawing.getChildren().contains(bezierFigure));
        assertEquals(2, drawing.getChildCount());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Tearing down.");
        bezierFigure = null;
        drawing = null;
    }

    @Test
    public void undo() {
        System.out.println("Testing undo event.");
        int latestDrawingIndex = drawing.getChildren().lastIndexOf(bezierFigure);
        BezierFigure latestFigure = (BezierFigure) drawing.getChild(latestDrawingIndex);
        drawing.remove(latestFigure);
        assertFalse(drawing.getChildren().contains(latestFigure));
        assertEquals(1, drawing.getChildCount());

        BezierFigure remainingFigure = (BezierFigure) drawing.getChild(latestDrawingIndex-1);
        drawing.remove(remainingFigure);
        assertFalse(drawing.getChildren().contains(remainingFigure));
        assertEquals(0, drawing.getChildCount());
    }

    @Test
    public void redo() {
        System.out.println("Testing redo event.");
        int latestDrawing = drawing.getChildren().lastIndexOf(bezierFigure);
        BezierFigure latestFigure = (BezierFigure) drawing.getChild(latestDrawing);
        drawing.remove(latestFigure);
        assertFalse(drawing.getChildren().contains(latestFigure));
        assertEquals(1, drawing.getChildCount());
        drawing.add(latestFigure);
        assertTrue(drawing.getChildren().contains(latestFigure));
        assertEquals(2, drawing.getChildCount());
    }
}