package AcceptanceTestForEllipseTool;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.samples.svg.figures.Dimensions;
import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;


public class EllipseGiven extends Stage<EllipseGiven> {
    
    @ProvidedScenarioState
    private Dimensions dimensions;
    @ProvidedScenarioState
    private SVGEllipseFigure svgEllipseFigure; 
    
    public EllipseGiven userSpecifiedDimensions() {
        dimensions = new Dimensions(100, 400, 100, 400);
        return self();
    }
}
