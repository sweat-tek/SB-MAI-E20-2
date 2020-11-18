
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;


/**
 *
 * @author Daniel
 */
public class GivenSomeStateRect extends Stage<GivenSomeStateRect> {

    @ProvidedScenarioState
    private SVGRectFigure rect;
    
    public GivenSomeStateRect some_rectangleFigure() {
        rect = new SVGRectFigure(15,15,30,30);
        return self();
    }
}
