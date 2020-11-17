package acceptanceTestLinkPalette;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.BezierTool;

/**
 *
 * @author alek
 */
class LinkAddedToFigure extends Stage<LinkAddedToFigure> {

    @ExpectedScenarioState
    BezierTool bezierTool;

    @ExpectedScenarioState
    int xAxis;

    @ExpectedScenarioState
    int yAxis;

    public LinkAddedToFigure linkAddedToFigure() {
        //BezierFigure resultFigure = bezierTool.getLastFigure();
        return this;

    }
}
