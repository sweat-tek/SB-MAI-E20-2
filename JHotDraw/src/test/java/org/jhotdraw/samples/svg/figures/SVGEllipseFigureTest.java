/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Jonas
 */
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

    /**
     * Test of getX method, of class SVGEllipseFigure.
     */
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
    /**
     * Test of getY method, of class SVGEllipseFigure.
     */
    @Test
    public void testGetY() {
        SVGEllipseFigure expected = new SVGEllipseFigure(new Dimensions(1, 2, 3, 4));
        assertEquals(expected.getY(), testFigure.getY(),2.0);
    }

//    /**
//     * Test of transform method, of class SVGEllipseFigure.
//     */
//    @Test
//    public void testTransform() {
//        System.out.println("transform");
//        AffineTransform tx = null;
//        SVGEllipseFigure instance = new SVGEllipseFigure();
//        instance.transform(tx);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
