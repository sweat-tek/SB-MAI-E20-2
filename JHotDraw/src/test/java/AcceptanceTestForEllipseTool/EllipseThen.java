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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EllipseThen extends Stage<EllipseThen>{

    @ExpectedScenarioState
    private SVGEllipseFigure svgEllipseFigure; 
    @ExpectedScenarioState
    private Dimensions dimensions;
    
    public EllipseThen figureHasBeenCreated(){
        SVGEllipseFigure result = svgEllipseFigure;
        SVGEllipseFigure expected = new SVGEllipseFigure(new Dimensions(100, 400, 100, 400));
        assertNotNull(result);
        assertEquals(expected.getX(), result.getX(), 0);
        assertEquals(expected.getY(), result.getY(), 0);
        assertEquals(expected.getHeight(), result.getHeight(), 0);
        assertEquals(expected.getWidth(), result.getWidth(), 0);
        return self();
    }
}
