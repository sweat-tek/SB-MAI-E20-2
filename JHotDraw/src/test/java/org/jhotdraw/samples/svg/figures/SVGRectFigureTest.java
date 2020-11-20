/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.RoundRectangle2D.Double;
import java.awt.image.BufferedImage;
import java.util.Map;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.geom.Dimension2DDouble;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.jhotdraw.draw.AttributeKeys;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.times;

/**
 *
 * @author Daniel S.
 */
public class SVGRectFigureTest {

    private static SVGRectFigure instance;
    private static Graphics2D graph;
    private BufferedImage image;

    public SVGRectFigureTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        graph = Mockito.mock(Graphics2D.class);  //Creating a mock of Graphics2D
        instance = new SVGRectFigure(10d, 10d, 100d, 100d);
        instance.setArc(50, 50);

        //Creating something that can represent a graphic object with RGB values
        image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        graph = image.createGraphics(); //assigning image to the graphics mock

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testDrawFillNoArc() {
        ArgumentCaptor<Rectangle2D.Double> argument = ArgumentCaptor.forClass(Rectangle2D.Double.class);
        Rectangle2D testRect = new Rectangle2D.Double(1, 1, 5, 5);

        Graphics2D mockG = Mockito.mock(Graphics2D.class);
        mockG.fill(testRect);
        SVGRectFigure noArcRect = new SVGRectFigure(1, 1, 5, 5);
        noArcRect.drawFill(mockG);
        
        Mockito.verify(mockG, times(2)).fill(argument.capture());

        
        assert (argument.getValue().getClass() == Rectangle2D.Double.class);

    }

    @Test
    public void testDrawFillArc() {

        ArgumentCaptor<RoundRectangle2D.Double> argumentRound = ArgumentCaptor.forClass(RoundRectangle2D.Double.class);
        RoundRectangle2D roundRect = new RoundRectangle2D.Double(1, 1, 10, 10, 5, 5);

        Graphics2D mockG = Mockito.mock(Graphics2D.class);

        SVGRectFigure arcRect = new SVGRectFigure(0, 0, 100, 100, 10, 10);

        mockG.fill(roundRect);
       
        //testing that arc height and width are more then 0
        assert (arcRect.getArcHeight() > 0);
        assert (arcRect.getArcWidth() > 0);

        //Verify that that draw is called with the correct argument
        Mockito.verify(mockG, times(1)).fill(argumentRound.capture());
        //call draw 
        arcRect.drawFill(mockG);
      
        assertEquals(arcRect.getArcHeight(), argumentRound.getValue().archeight, 0.0);

    }

    @Test
    public void testDrawStroke() {

        SVGRectFigure rect = new SVGRectFigure(10, 10, 10, 10);

        rect.setAttribute(AttributeKeys.STROKE_COLOR, Color.orange);
        Map<AttributeKey, Object> attributes = rect.getAttributes();

        graph.setColor(new Color(255, 200, 0)); //Setting and creating orange color

        //drawing a rectangle
        rect.draw(graph);

        //Asserting that the two graphics are the same stroke color.
        assertEquals(attributes.get(AttributeKeys.STROKE_COLOR), graph.getPaint());
        //Asserting the wrong color
        assertNotEquals(new Color(10, 10, 10), graph.getPaint());
        assertNotEquals(new Color(10, 10, 10), attributes.get(AttributeKeys.STROKE_COLOR));
    }

    @Test
    public void testGetWidth() {
        double expResult = 100d;
        double result = instance.getWidth();

        //assert equals(true)
        assertEquals(expResult, result, 0.0);

        //assert different(false)
        assertNotEquals(50, result, 0.0);
    }

    @Test
    public void testGetHeight() {
        double expResult = 100d;
        double result = instance.getHeight();

        //assert equals(true)
        assertEquals(expResult, result, 0.0);

        //assert different(false)
        assertNotEquals(50, result, 0.0);
    }

    @Test
    public void testGetArcWidth() {

        RoundRectangle2D.Double roundRect = new RoundRectangle2D.Double();
        roundRect.setRoundRect(10, 10, 10, 10, 50, 50);

        //Expected arcWidth
        double expWidth = roundRect.arcwidth;

        //getArchWidth return half of the original width
        double result = instance.getArcHeight();

        //Assert that the computation is correct
        assertEquals(expWidth, result, 0.0);

    }

    @Test
    public void testGetArcHeight() {

        RoundRectangle2D.Double roundRect = new RoundRectangle2D.Double();
        roundRect.setRoundRect(10, 10, 10, 10, 50, 50);

        //Expected arcHeight
        double expHeight = roundRect.archeight;

        //getArchHeight return half of the original height
        double result = instance.getArcHeight();

        //Assert that the computation is correct
        assertEquals(expHeight, result, 0.0);
    }

    @Test
    public void testGetBounds() {
        SVGRectFigure rect = new SVGRectFigure();
        Rectangle2D.Double expResult = new Rectangle2D.Double();

        Rectangle2D.Double result = rect.getBounds();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDrawingArea() {

        //Create specific SVGrectangle instance
        SVGRectFigure instance = new SVGRectFigure(10d, 10d, 14d, 14d);

        //Creating rectangle with expecting result
        Rectangle2D.Double expResult = new Rectangle2D.Double(9d, 9d, 16d, 16d);

        //Get the drawing area from the instance var.
        //getDrawingArea grows the drawingArea in x,y axes
        Rectangle2D.Double result = instance.getDrawingArea();

        //Assert if the drawingArea has changed
        assertEquals(expResult, result);
    }

    @Test
    public void testContains() {

        //Creating two new points in 2d space
        //expected point val
        Point2D.Double p1 = new Point2D.Double(5, 5);

        //control point val
        Point2D.Double p2 = new Point2D.Double(100, 100);

        //Creating rectangle instance with coordinates x=5, y=5, w=10, h=10
        SVGRectFigure rect = new SVGRectFigure(5, 5, 10, 10);

        //checks if point p1 is inside the figure
        boolean result1 = rect.contains(p1);
        assertEquals(true, result1);

        //checks if point p2 is outside the figure
        boolean result2 = rect.contains(p2);
        assertEquals(false, result2);
    }

    @Test
    public void testSetBounds() {
        //Creating point2D points
        Point2D.Double anchor = new Point2D.Double(10, 10);
        Point2D.Double lead = new Point2D.Double(5, 5);

        //Creating rectangle with values x=0, y=0, w=0, h=0
        SVGRectFigure rect = new SVGRectFigure();

        //Testing for 0 val before creating bounds
        assertTrue(rect.getX() == 0);
        assertTrue(rect.getY() == 0);

        //Setting the bounds with point2D values
        rect.setBounds(anchor, lead);

        //Testing that bound is set correctly
        assertTrue(rect.getX() == 5);
        assertTrue(rect.getY() == 5);
    }

    @Test
    public void testTransform() {

        //Transform creation
        AffineTransform tx = new AffineTransform();

        //Rectangle init with x=35, y=25, w=65, h=65
        SVGRectFigure rect = new SVGRectFigure(35, 25, 65, 65);

        //X and Y before transform check
        assertTrue(rect.getX() == 35 && rect.getY() == 25);

        //new position
        tx.translate(55, 55);

        //transform the rectangle
        rect.transform(tx);

        //X and Y after transform check
        assertFalse(rect.getX() == 35 && rect.getY() == 25);

    }

    @Test
    public void testSetArc_double_double() {
        //init w,h values
        double w = 10;
        double h = 10;

        //New instance creation
        SVGRectFigure instance = new SVGRectFigure(20, 20, 20, 20);

        //Set the height and the width
        instance.setArc(w, h);

        //assert that the computation is true
        assertTrue(instance.getArcHeight() == 10);

        //assert that the computation is  flase
        assertFalse(instance.getArcHeight() == 20);

    }

    @Test
    public void testGetArc() {
        Dimension2DDouble expResult = new Dimension2DDouble(50, 50);
        Dimension2DDouble result = instance.getArc();
        assertEquals(expResult, result);
    }

    @Test
    public void testClone() {
        //creating rectangle that will serve as the original
        SVGRectFigure originalRect = new SVGRectFigure(10, 10, 10, 10, 10, 10);

        //Creating a clone rectangle from the original
        SVGRectFigure cloneRect = originalRect.clone();

        //Check that clone not just returns the original rectangle
        assertNotSame(cloneRect, originalRect);

        //Check if the clone is the correct type
        assertThat(cloneRect, instanceOf(SVGRectFigure.class));

        //Check if the fields are cloned correctly:
        //same bounds
        assertEquals(cloneRect.getBounds(), originalRect.getBounds());

        //Same stroke
        assertEquals(cloneRect.getStroke(), originalRect.getStroke());

        //same x and y
        assertTrue(cloneRect.getX() == originalRect.getX() && cloneRect.getY() == originalRect.getY());

        //same drawing area
        assertEquals(cloneRect.getDrawingArea(), originalRect.getDrawingArea());

    }

    @Test
    public void testIsEmpty() {

        //Creating default rect with x=0, y=0, w=0, h=0
        SVGRectFigure rect1 = new SVGRectFigure();

        //Rectangle should be empty with w and h == 0
        assertTrue(rect1.isEmpty());

        //Creating new rect with values 10 for each field
        SVGRectFigure rect2 = new SVGRectFigure(10, 10, 10, 10);

        //isEmpty should return false since w and h is 10
        assertFalse(rect2.isEmpty());
    }

}
