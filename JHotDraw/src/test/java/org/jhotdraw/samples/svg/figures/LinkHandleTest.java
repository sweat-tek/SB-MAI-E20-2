package org.jhotdraw.samples.svg.figures;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.BezierTool;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.GridConstrainer;
import org.jhotdraw.draw.HandleAttributeKeys;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.spy;
import static org.junit.Assert.*;

/**
 * @author Aleksander G. Duszkiewicz
 * @version 1.0 2020-11-17 Created.
 */
public class LinkHandleTest {

    @Mock
    BezierFigure bezierFigure;
    @Mock
    LinkHandle linkHandle;
    @Mock
    LinkHandle linkHandleTest;
    @Mock
    DefaultDrawingView defaultDrawingView;
    @Mock
    DefaultDrawingEditor defaultDrawingEditor;
    @Mock
    GridConstrainer gridConstrainer;
    @Mock
    Drawing drawing;
    @Mock
    BezierTool bezierTool;
    @Mock
    int xAxis = 250;
    @Mock
    int yAxis = 150;

    public void setUpMock() {
        bezierTool = new BezierTool(new BezierFigure());
        defaultDrawingEditor = spy(new DefaultDrawingEditor());
        defaultDrawingView = spy(new DefaultDrawingView());
        gridConstrainer = Mockito.mock(GridConstrainer.class);
        drawing = Mockito.mock(QuadTreeDrawing.class);

        // view, drawing and editor mock for the figure. 
        Mockito.when(defaultDrawingEditor.getActiveView()).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingEditor.findView(defaultDrawingView)).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingView.viewToDrawing(new Point(xAxis, yAxis))).thenReturn(new Point2D.Double(xAxis, yAxis));
        Mockito.when(gridConstrainer.constrainPoint(new Point2D.Double(xAxis, yAxis))).thenReturn(new Point2D.Double(xAxis, yAxis));
        bezierTool.activate(defaultDrawingEditor);
        Mockito.when(defaultDrawingView.getConstrainer()).thenReturn(gridConstrainer);
        Mockito.when(bezierTool.getDrawing()).thenReturn(drawing);
        Mockito.when(bezierTool.getView()).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingView.getDrawing()).thenReturn(drawing);
        // Creates path on BezierFigure, and sets points that is used in linkHandle
        MouseEvent mouseEventMock = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEventMock.getPoint()).thenReturn(new Point(xAxis, yAxis));
        Mockito.when(mouseEventMock.getX()).thenReturn(xAxis);
        Mockito.when(mouseEventMock.getY()).thenReturn(yAxis);
        Mockito.when(mouseEventMock.getSource()).thenReturn(defaultDrawingView);
        Mockito.when(defaultDrawingView.viewToDrawing(new Point(xAxis, yAxis))).thenReturn(new Point2D.Double(xAxis, yAxis));
        // Pressed on BezierFigure, that creates the figure so that we can call getCreatedFigure()
        bezierTool.mousePressed(mouseEventMock);

        bezierFigure = (BezierFigure) bezierTool.getCreatedFigure();
        linkHandle = Mockito.mock(LinkHandle.class);
        linkHandleTest = spy(new LinkHandle(bezierFigure));
        // LinkHandle mock
        Mockito.doReturn(linkHandle).when(linkHandleTest).makeLinkHandle(bezierFigure);
    }

    public LinkHandleTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        setUpMock();
        // Set the view, editor, active handler and handleAtrribute
        defaultDrawingEditor.setHandleAttribute(HandleAttributeKeys.HANDLE_SIZE, 7);
        defaultDrawingView.setEditor(defaultDrawingEditor);
        linkHandleTest.setView(defaultDrawingView);
        defaultDrawingView.setActiveHandle(linkHandleTest);
    }

    @After
    public void tearDown() {
        bezierTool = null;
        defaultDrawingEditor = null;
        defaultDrawingView = null;
        gridConstrainer = null;
        drawing = null;
        bezierFigure = null;
        xAxis = 0;
        yAxis = 0;
    }

    @Test
    public void testBasicGetBounds() {
        System.out.println("testBasicGetBounds()");
        Rectangle actualRectangle = linkHandleTest.basicGetBounds();
        Rectangle expectedRectangle = new Rectangle(222, 143, 14, 7);
        assertEquals(expectedRectangle, actualRectangle);
        System.out.println();
        // Expected Rectangle [222, 143, 14, 7];
    }
}
