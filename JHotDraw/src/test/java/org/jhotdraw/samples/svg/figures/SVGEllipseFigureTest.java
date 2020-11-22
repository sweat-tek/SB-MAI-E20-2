package org.jhotdraw.samples.svg.figures;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;
import org.jhotdraw.draw.ConnectionFigure;
import org.jhotdraw.draw.Connector;
import org.jhotdraw.draw.Handle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SVGEllipseFigureTest {
    SVGEllipseFigure testFigure;
    Dimensions d;
    
    
    public SVGEllipseFigureTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        d = new Dimensions(1, 2, 3, 4);
        testFigure = new SVGEllipseFigure(d);
    }
    
    @After
    public void tearDown() {
        d = null;
        testFigure = null;
    }

    @Test
    public void testGetX() {
        SVGEllipseFigure expected = new SVGEllipseFigure(new Dimensions(1, 2, 3, 4));
        assertEquals(expected.getX(), testFigure.getX(),1.0);
    }

    @Test
    public void testGetBounds() {
        SVGEllipseFigure expected = new SVGEllipseFigure(new Dimensions(1, 2, 3, 4));
        Rectangle2D.Double result = expected.getBounds();
        assertEquals(expected.getBounds(), result);
    }

    @Test
    public void testGetY() {
        SVGEllipseFigure expected = new SVGEllipseFigure(new Dimensions(1, 2, 3, 4));
        assertEquals(expected.getY(), testFigure.getY(),2.0);
    }
}
