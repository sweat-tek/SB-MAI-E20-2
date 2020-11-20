package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Point;
import java.awt.event.MouseEvent;
import org.jhotdraw.draw.CreationTool;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Figure;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author Daniel
 */
public class WhenSomeActionRect extends Stage<WhenSomeActionRect> {

    @ExpectedScenarioState
    private CreationTool tool;
    @ExpectedScenarioState
    private DefaultDrawingView view;

    @ProvidedScenarioState
    private MouseEvent mouse;

    @ProvidedScenarioState
    protected Figure provided;

    Point start = new Point(5, 5);
    Point end = new Point(40, 40);

    @BeforeStage
    private void setup() {

        //Mouse mock setup
        mouse = Mockito.mock(MouseEvent.class);
        Mockito.when(mouse.getPoint()).thenReturn(start);
        Mockito.when(mouse.getX()).thenReturn(start.x);
        Mockito.when(mouse.getY()).thenReturn(start.y);
        Mockito.when(mouse.getSource()).thenReturn(view);
    }

    public WhenSomeActionRect clickAndDragMouse() {

        //simulate mouse press
        tool.mousePressed(mouse);
        assertThat(tool.getCreatedFigure()).isNotNull();

        //simulate mouse drag
        for (int i = 0; i < 20; i++) {
            tool.mouseDragged(dragMouse(i * 1, i + 5));
            provided = tool.getCreatedFigure();
        }

        //simulate mouse released
        tool.mouseReleased(mouse);
        return self();
    }

    private MouseEvent dragMouse(int x, int y) {
        Mockito.when(mouse.getPoint()).thenReturn(new Point(x, y));
        Mockito.when(mouse.getX()).thenReturn(x);
        Mockito.when(mouse.getY()).thenReturn(y);
        return mouse;
    }
}
