package org.jhotdraw.samples.svg.figures;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.geom.BezierPath;
import org.jhotdraw.geom.BezierPathIterator;


import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.*;


public class SVGPathFigureTest {
    private SVGPathFigure pathFigure;
    @Before
    public void setUp() {
        pathFigure = new SVGPathFigure();


    }

    @After
    public void tearDown() {

    }

    @Test
    public void testAdd() {
        SVGBezierFigure bezierFigure = mock(SVGBezierFigure.class);
        when(bezierFigure.getDrawingArea()).thenReturn(new Rectangle2D.Double(0, 0, 19, 19));
        pathFigure.add(bezierFigure);
        System.out.println(pathFigure.getChild(0).getDrawingArea());
        assertTrue(pathFigure.getChild(1).equals(bezierFigure));
    }
}