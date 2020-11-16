package org.jhotdraw.draw;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BezierToolTest {

    private DefaultDrawing drawing;
    private BezierFigure bezierFigure;
    private BezierTool bezierTool;

    @Before
    public void setUp() throws Exception {
        System.out.println("Setting up.");
        drawing = new DefaultDrawing();
        bezierTool = new BezierTool(bezierFigure);
        bezierFigure = new BezierFigure();
        drawing.add(bezierFigure);
        assertTrue(drawing.getChildren().contains(bezierFigure));
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Tearing down.");
        bezierTool = null;
        bezierFigure = null;
        drawing = null;
    }

    @Test
    public void undo() {
        System.out.println("Testing undo event.");
        drawing.remove(bezierFigure);
        assertFalse(drawing.getChildren().contains(bezierFigure));
    }

    @Test
    public void redo() {
        System.out.println("Testing redo event.");
        drawing.remove(bezierFigure);
        assertFalse(drawing.getChildren().contains(bezierFigure));
        drawing.add(bezierFigure);
        assertTrue(drawing.getChildren().contains(bezierFigure));
    }
}