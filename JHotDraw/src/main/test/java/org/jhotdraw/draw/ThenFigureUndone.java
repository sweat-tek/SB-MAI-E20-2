package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import static org.junit.Assert.assertEquals;

public class ThenFigureUndone extends Stage<ThenFigureUndone> {

    @ExpectedScenarioState
    private DrawingView drawingView;

    public ThenFigureUndone figureIsUndone() {
        assertEquals(0,drawingView.getDrawing().getChildCount());
        return this;
    }
}
