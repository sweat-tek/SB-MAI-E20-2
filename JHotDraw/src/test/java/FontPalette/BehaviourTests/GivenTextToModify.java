package FontPalette.BehaviourTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

/**
 *
 * @author Sander
 */
public class GivenTextToModify extends Stage<GivenTextToModify> {
    
    @ProvidedScenarioState
    private SVGTextFigure textFigure;
    
    @BeforeStage
    private void before() {
        textFigure = new SVGTextFigure();
    }
    
    GivenTextToModify someSelectedText() {
        textFigure.setText("This is a small paragraph.");
        return this;
    }
}
