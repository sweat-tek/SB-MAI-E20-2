package acceptanceTestLinkPalette;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.BezierTool;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.GridConstrainer;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.samples.svg.figures.LinkHandle;
import org.mockito.Mockito;
import org.junit.Assert;

/**
 *
 * @author alek
 */
class PressedAndSelectedFigure extends Stage<PressedAndSelectedFigure> {

    @ProvidedScenarioState
    DefaultDrawingView defaultDrawingView;
    @ProvidedScenarioState
    int xAxis = 408;
    @ProvidedScenarioState
    int yAxis = 127;
    @ProvidedScenarioState
    BezierTool bezierTool;
@ProvidedScenarioState
    DefaultDrawingEditor defaultDrawingEditor;
    GridConstrainer gridConstrainer;
    Drawing drawing;

    public PressedAndSelectedFigure figureSelected() {
        setUpMock();

        Assert.assertNotNull(bezierTool);
        Assert.assertNotNull(defaultDrawingEditor);
        Assert.assertNotNull(defaultDrawingView);
        Assert.assertNotNull(gridConstrainer);
        Assert.assertNotNull(drawing);

        givenMousePressed();

        return this;
    }

    public void setUpMock() {
        bezierTool = new BezierTool(new BezierFigure());
        defaultDrawingEditor = Mockito.mock(DefaultDrawingEditor.class);
        defaultDrawingView = Mockito.mock(DefaultDrawingView.class);
        gridConstrainer = Mockito.mock(GridConstrainer.class);
        drawing = Mockito.mock(QuadTreeDrawing.class);

        Mockito.when(defaultDrawingEditor.findView(defaultDrawingView)).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingView.viewToDrawing(new Point(xAxis, yAxis))).thenReturn(new Point2D.Double(xAxis, yAxis));
        Mockito.when(gridConstrainer.constrainPoint(new Point2D.Double(xAxis, yAxis))).thenReturn(new Point2D.Double(xAxis, yAxis));
        bezierTool.activate(defaultDrawingEditor);
        Mockito.when(defaultDrawingView.getConstrainer()).thenReturn(gridConstrainer);
        Mockito.when(bezierTool.getDrawing()).thenReturn(drawing);
        Mockito.when(bezierTool.getView()).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingView.getDrawing()).thenReturn(drawing);

    }

    public MouseEvent getMouseEvent(int x, int y) {
        MouseEvent mouseEventMock = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEventMock.getPoint()).thenReturn(new Point(x, y));
        Mockito.when(mouseEventMock.getX()).thenReturn(x);
        Mockito.when(mouseEventMock.getY()).thenReturn(y);
        Mockito.when(mouseEventMock.getSource()).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingView.viewToDrawing(new Point(xAxis, yAxis))).thenReturn(new Point2D.Double(xAxis, yAxis));
        return mouseEventMock;
    }

    public void givenMousePressed() {
        bezierTool.mousePressed(getMouseEvent(xAxis, yAxis));
    }

}
