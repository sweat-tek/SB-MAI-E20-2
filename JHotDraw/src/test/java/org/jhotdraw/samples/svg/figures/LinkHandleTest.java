package org.jhotdraw.samples.svg.figures;

import java.awt.Rectangle;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.geom.BezierPath;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.spy;
import static org.junit.Assert.*;

public class LinkHandleTest {

    private BezierFigure bezierFigure;
    @Mock
    private LinkHandle linkHandle;
    private LinkHandle linkHandleTest;

    public void setUpMock() {
        bezierFigure = new BezierFigure();
        bezierFigure.addNode(new BezierPath.Node(10, 10));
        bezierFigure.addNode(new BezierPath.Node(20, 20));
        linkHandleTest = spy(new LinkHandle(bezierFigure));
        
        DrawingView defaultDrawingView = new DefaultDrawingView();
        DrawingEditor defaultDrawingEditor = new DefaultDrawingEditor();

        linkHandle = Mockito.mock(LinkHandle.class);
        Mockito.doReturn(linkHandle).when(linkHandleTest).makeLinkHandle(bezierFigure);

        defaultDrawingEditor.setActiveView(defaultDrawingView);
        linkHandleTest.setView(defaultDrawingView);
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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testBasicGetBounds() {
        System.out.println("testBasicGetBounds()");
        Rectangle actualRectangle = linkHandleTest.basicGetBounds();
       
        Rectangle expectedRectangle = new Rectangle(16, 19, 2, 1);
        System.out.println("expected:" + expectedRectangle.toString());
        System.out.println("actual:" + actualRectangle.toString());
        assertEquals(expectedRectangle, actualRectangle);
        // Expected Rectangle [16, 19, 2, 1];
    }
}