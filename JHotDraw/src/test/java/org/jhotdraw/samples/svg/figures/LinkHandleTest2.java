/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.BezierTool;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.GridConstrainer;
import org.jhotdraw.draw.QuadTreeDrawing;
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

public class LinkHandleTest2 {

    private BezierFigure owner;
    @Mock
    private LinkHandle ah;
    private static DefaultDrawingView view; 
    private static Rectangle2D.Double b; 
    private static Point2D.Double p;
    private static Rectangle r;
    private static Point point;
    private static DefaultDrawingEditor editor;
    private LinkHandle ahTest;
    private QuadTreeDrawing qtd;
    private GridConstrainer gc;
    private BezierTool bt;

    public void setUpMock() {
        owner = new BezierFigure();
        owner.addNode(new BezierPath.Node(10, 10));
        owner.addNode(new BezierPath.Node(20, 20));
        ahTest = spy(new LinkHandle(owner));
//        bt = new BezierTool(owner);
//        ah = Mockito.mock(LinkHandle.class);
//        view = Mockito.mock(DefaultDrawingView.class);
//        editor = Mockito.mock(DefaultDrawingEditor.class);
//        qtd = Mockito.mock(QuadTreeDrawing.class);
//        gc = Mockito.mock(GridConstrainer.class);
        DrawingView dv = new DefaultDrawingView();
        DrawingEditor de = new DefaultDrawingEditor();
//      Mockito.when(editor.getActiveView()).thenReturn(view);
//        Mockito.when(editor.findView(view)).thenReturn(view);
//        Mockito.when(view.viewToDrawing(new Point(10, 10))).thenReturn(new Point2D.Double(10, 10));
//        Mockito.when(gc.constrainPoint(new Point2D.Double(10, 10))).thenReturn(new Point2D.Double(10, 10));
//        bt.activate(editor);
//        Mockito.when(view.getConstrainer()).thenReturn(gc);
//        Mockito.when(bt.getDrawing()).thenReturn(qtd);
//        Mockito.when(bt.getView()).thenReturn(view);
//        Mockito.when(view.getDrawing()).thenReturn(qtd);

        ah = Mockito.mock(LinkHandle.class);
        Mockito.doReturn(ah).when(ahTest).makeLinkHandle(owner);
        //bt.activate(de);
        //de.setTool(bt);
        de.setActiveView(dv);
        ahTest.setView(dv);

    }

    public LinkHandleTest2() {
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
        Rectangle actualRectangle = ahTest.basicGetBounds();
       
        Rectangle expectedRectangle = new Rectangle(16, 19, 2, 1);
        System.out.println("expected:" + expectedRectangle.toString());
        System.out.println("actual:" + actualRectangle.toString());
        assertEquals(expectedRectangle, actualRectangle);
        // Expected Rectangle [16, 19, 2, 1];
    }
}
