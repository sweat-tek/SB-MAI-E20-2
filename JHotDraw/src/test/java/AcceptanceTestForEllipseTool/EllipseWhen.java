/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AcceptanceTestForEllipseTool;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.figures.Dimensions;
import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;

/**
 *
 * @author Jonas
 */
public class EllipseWhen extends Stage<EllipseWhen> {
    @ExpectedScenarioState
    private SVGEllipseFigure svgEllipseFigure; 
    @ExpectedScenarioState
    private Dimensions dimensions;
    
    public EllipseWhen userDrawsEllipseWithGivenDimensions() {
        EllipseGiven eg = new EllipseGiven();
        eg.userSpecifiedDimensions();
        svgEllipseFigure = new SVGEllipseFigure(dimensions);
        return self();
    }
}
