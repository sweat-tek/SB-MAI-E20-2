package FontPalette.BehaviourTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Sander
 */
public class ThenTextHasChanged extends Stage<ThenTextHasChanged> {
    
    @ExpectedScenarioState
    private SVGTextFigure textFigure;
    
    ThenTextHasChanged theFontSizeHasChanged() {
        assertEquals(86, textFigure.getFontSize(), 0);
        return this;
    }
}
