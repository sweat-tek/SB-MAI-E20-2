package basicediting.bdd;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.assertj.swing.fixture.JPanelFixture;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.SVGDrawingPanel;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class ThenSomeOutcome extends Stage<ThenSomeOutcome> {

    @ExpectedScenarioState
    JPanelFixture panel;

    public ThenSomeOutcome the_figure_is_deleted() {

        SVGDrawingPanel drawingPanel = (SVGDrawingPanel) panel.target();
        List<Figure> figures = drawingPanel.getView().getDrawing().getChildren();

        assertTrue(figures.isEmpty());
        return self();
    }
}