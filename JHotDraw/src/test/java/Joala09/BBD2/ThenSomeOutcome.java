package Joala09.BBD2;

import Joala09.BDD.*;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.assertj.swing.fixture.JPanelFixture;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.SVGDrawingPanel;

import java.util.List;
import javax.swing.JTextField;

import static junit.framework.TestCase.assertTrue;
import org.jhotdraw.draw.DrawingEditor;

public class ThenSomeOutcome extends Stage<ThenSomeOutcome> {

    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;
    

    public ThenSomeOutcome the_figure_is_deleted() {

        List<Figure> figures = editor.getActiveView().getDrawing().getChildren();       
        assertTrue(figures.isEmpty());

        return this;
    }
}