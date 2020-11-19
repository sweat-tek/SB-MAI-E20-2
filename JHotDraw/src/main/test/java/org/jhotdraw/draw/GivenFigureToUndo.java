package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GivenFigureToUndo extends Stage<GivenFigureToUndo> {

    @ProvidedScenarioState
    private Drawing drawing;

    @BeforeStage
    private void before() {
        System.out.println("Setting up given stage");
        drawing = new DefaultDrawing();
    }

    public GivenFigureToUndo aBezierFigure() {
        Figure bezierFigure = new BezierFigure();
        drawing.add(bezierFigure);
        assertTrue(drawing.contains(bezierFigure));
        assertEquals(1, drawing.getChildCount());
        return this;
    }
}
