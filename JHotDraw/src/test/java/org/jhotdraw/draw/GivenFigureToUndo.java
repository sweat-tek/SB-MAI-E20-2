package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GivenFigureToUndo extends Stage<GivenFigureToUndo> {

    @ProvidedScenarioState
    private DrawingView drawingView;
    @ProvidedScenarioState
    private BezierFigure figure;
    @ProvidedScenarioState
    private DrawingEditor editor;

    @BeforeStage
    private void before() {
        System.out.println("Setting up given stage");
        figure = new BezierFigure();
        editor = new DefaultDrawingEditor();
        drawingView = new DefaultDrawingView();
        drawingView.setDrawing(new DefaultDrawing());
        editor.setActiveView(drawingView);
    }

    public GivenFigureToUndo aBezierFigure() {
        System.out.println("Given set up");
        assertEquals(0, drawingView.getDrawing().getChildCount());
        drawingView.getDrawing().add(figure);
        assertTrue(drawingView.getDrawing().contains(figure));
        assertEquals(1, drawingView.getDrawing().getChildCount());
        return this;
    }
}
