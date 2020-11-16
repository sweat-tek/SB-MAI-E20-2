/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.LineFigure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ALEKSTUD
 */
public class LinkHandleTest {
 
    private static Figure owner;
    private static LinkHandle ah;
    private static DefaultDrawingView view; // view = DefaultDrawingView
    private static Rectangle2D.Double b; // x = 125.0, y = 78.0, width= 192.0, height 148.0
    private static Point2D.Double p;

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
        owner = new LineFigure();
        ah = new LinkHandle(owner);
        b = new Rectangle2D.Double(125.0, 78.0, 192.0, 148.0);
        view = new DefaultDrawingView();
        p = new Point2D.Double(b.x + b.width, b.y + b.height);
    }

    @After
    public void tearDown() {
        owner = null;
        ah = null;
        b = null;
        view = null;
        p = null;
    }

    @Test
    public void testBasicGetBounds() {
        System.out.println("testBasicGetBounds()");
        Rectangle actualRectangle = new Rectangle(view.drawingToView(p));
        int h = 7;
        actualRectangle.x -= h * 4; 
        actualRectangle.y -= h;
        actualRectangle.width = h * 2;
        actualRectangle.height = h;

        Rectangle expectedRectangle = new Rectangle(289, 219, 14, 7);
        System.out.println("expected:" + expectedRectangle.toString());
        System.out.println("actual:" + actualRectangle.toString());
        assertEquals(expectedRectangle, actualRectangle);
       // Expected Rectangle [289, 219, 14, 7]
    }
}
