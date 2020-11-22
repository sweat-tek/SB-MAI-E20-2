package org.jhotdraw.geom;

import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.samples.svg.figures.SVGBezierFigure;
import org.jhotdraw.samples.svg.figures.SVGPathFigure;
import org.junit.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class BezierPathTest  {
    private BezierPath bezierPath;

    @Before
    public void setUp() throws Exception {
        bezierPath = new BezierPath();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getBounds2DNoPoint() {
        assertTrue(bezierPath.getBounds2D().height == 0);
        assertTrue(bezierPath.getBounds2D().width == 0);
        assertTrue(bezierPath.getBounds2D().x == 0);
        assertTrue(bezierPath.getBounds2D().y == 0);
    }

    @Test
    public void getBounds2DSinglePoint() {
        bezierPath.addPoint(10, 0);
        assertTrue(bezierPath.getBounds2D().height == 0);
        assertTrue(bezierPath.getBounds2D().width == 0);
        assertTrue(bezierPath.getBounds2D().x == 10);
        assertTrue(bezierPath.getBounds2D().y == 0);
    }

    @Test
    public void getBounds2DTwoPoints() {
        bezierPath.addPoint(10, 0);
        bezierPath.addPoint(0, 10);
        assertTrue(bezierPath.getBounds2D().height == 10);
        assertTrue(bezierPath.getBounds2D().width == 10);
        assertTrue(bezierPath.getBounds2D().x == 0);
        assertTrue(bezierPath.getBounds2D().y == 0);
    }

    @Test
    public void getBounds2DFourPoints() {
        addBasicRectangleToPath(0,0,10,10);
        assertTrue(bezierPath.getBounds2D().height == 10);
        assertTrue(bezierPath.getBounds2D().width == 10);
        assertTrue(bezierPath.getBounds2D().x == 0);
        assertTrue(bezierPath.getBounds2D().y == 0);
    }

    @Test
    public void getBounds2DTwoNegativePoints() {
        bezierPath.addPoint(-10, 0);
        bezierPath.addPoint(0, 10);
        assertTrue(bezierPath.getBounds2D().height == 10);
        assertTrue(bezierPath.getBounds2D().width == 10);
        assertTrue(bezierPath.getBounds2D().x == -10);
        assertTrue(bezierPath.getBounds2D().y == 0);
    }

    @Test
    public void containsNegativeNumbersShouldReturnFalse() {
        addBasicRectangleToPath(0,0,10,10);
        Rectangle2D rectToBeChecked = new Rectangle2D.Double(-2, -2, -2, -2);
        boolean expected = true;
        boolean returned = bezierPath.contains(rectToBeChecked);
        assertNotEquals(expected, returned);
    }

    @Test
    public void containsNegativeNumbersShouldReturnTrue() {
        addBasicRectangleToPath(-10,0,10,10);
        Rectangle2D rectToBeChecked = new Rectangle2D.Double(-2, 2, 2, 2);
        boolean expected = true;
        boolean returned = bezierPath.contains(rectToBeChecked);
        assertEquals(expected, returned);
    }

    @Test
    public void containsPositiveNumbersShouldReturnTrue() {
        addBasicRectangleToPath(0,0,10,10);
        Rectangle2D rectToBeChecked = new Rectangle2D.Double(2, 2, 2, 2);
        boolean expected = true;
        boolean returned = bezierPath.contains(rectToBeChecked);
        assertEquals(expected, returned);
    }

    @Test
    public void containsPositiveNumbersShouldReturnFalse() {
        addBasicRectangleToPath(0,0,10,10);
        Rectangle2D rectToBeChecked = new Rectangle2D.Double(200, 2, 2, 2);
        boolean expected = false;
        boolean returned = bezierPath.contains(rectToBeChecked);
        assertEquals(expected, returned);
    }

    private void addBasicRectangleToPath(double x, double y, double height, double width){
        bezierPath.addPoint(x+width, y);
        bezierPath.addPoint(x+width, y+height);
        bezierPath.addPoint(x, y+height);
        bezierPath.addPoint(x, y);
    }

}