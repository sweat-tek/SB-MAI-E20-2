package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.event.MouseEvent;
import org.mockito.Mockito;

/**
 *
 * @author Daniel
 */
public class ThenSomeOutcomeRect extends Stage<ThenSomeOutcomeRect> {

    @ExpectedScenarioState
    protected SVGRectFigure rect;

    public ThenSomeOutcomeRect rectangleMoved() {
        
     
        return self();
    }
}
