package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.CreationTool;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.mockito.Mockito;

/**
 *
 * @author Daniel
 */
public class GivenSomeStateRect extends Stage<GivenSomeStateRect> {

    @ProvidedScenarioState
    private DrawingEditor editor;

    @ProvidedScenarioState
    private DefaultDrawingView view;

    @ProvidedScenarioState
    private CreationTool tool;

    @BeforeStage()
    private void mockController() {
        editor = Mockito.mock(DefaultDrawingEditor.class);

        view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());

        Mockito.when(editor.findView(view)).thenReturn(view);
        Mockito.when(editor.getActiveView()).thenReturn(view);

        editor.setActiveView(view);

    }

    public GivenSomeStateRect iWantToDrawARectangle() {
        mockController();
        tool = new CreationTool(new SVGRectFigure());
        tool.activate(editor);
        return self();
    }
}
