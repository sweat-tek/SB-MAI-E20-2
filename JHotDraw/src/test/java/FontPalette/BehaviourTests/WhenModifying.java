package FontPalette.BehaviourTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

/**
 *
 * @author Sander
 */
public class WhenModifying extends Stage<WhenModifying> {
    
    @ExpectedScenarioState
    private SVGTextFigure textFigure;
    
    WhenModifying modifyingFontSize() {
        textFigure.setFontSize(86);
        return this;
    }
}
