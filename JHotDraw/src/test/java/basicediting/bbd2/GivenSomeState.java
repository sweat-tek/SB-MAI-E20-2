package basicediting.bbd2;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import static org.junit.Assert.assertFalse;

public class GivenSomeState extends Stage<GivenSomeState> {

    @ProvidedScenarioState
    private DrawingEditor editor;
   
    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);
    }

    public GivenSomeState a_figure_exists() {

        Figure f1 = new BezierFigure();
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().addToSelection(f1);

        assertFalse(editor.getActiveView().getDrawing().getChildren().isEmpty());
        return this;
//        return self();
    }

}
