package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WhenUndoing extends Stage<WhenUndoing> {

    @ExpectedScenarioState
    private DrawingView drawingView;
    @ExpectedScenarioState
    private BezierFigure figure;
    @ExpectedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private BezierTool bezierTool;

    @BeforeStage
    public void before() {
        System.out.println("Setting up when state");
        bezierTool = new BezierTool(figure);
        bezierTool.activate(editor);
    }

    public WhenUndoing undoingFigure() {
        bezierTool.fireUndoEvent(figure, drawingView);
        assertFalse(drawingView.getDrawing().contains(figure));
        return this;
    }
}
