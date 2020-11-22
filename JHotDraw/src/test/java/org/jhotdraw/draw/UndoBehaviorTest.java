package org.jhotdraw.draw;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class UndoBehaviorTest extends ScenarioTest<GivenFigureToUndo, WhenUndoing, ThenFigureUndone> {
    @Test
    public void undoingAFigure() {
        given().aBezierFigure();
        when().undoingFigure();
        then().figureIsUndone();
    }
}
