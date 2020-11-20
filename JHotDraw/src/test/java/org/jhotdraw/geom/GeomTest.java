package org.jhotdraw.geom;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;

import static java.lang.Math.abs;
import static org.mockito.Mockito.when;

public class GeomTest {
    @Mock
    Point startPoint;
    @Mock
    Point endPoint;
    @Mock
    Point checkPoint;
    @Mock
    Rectangle rectangle;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        when(startPoint.getX()).thenReturn(1.5);
        when(startPoint.getY()).thenReturn(3.0);

        when(endPoint.getX()).thenReturn(1.5);
        when(endPoint.getY()).thenReturn(4.6);

        when(checkPoint.getX()).thenReturn(2.0);
        when(checkPoint.getY()).thenReturn(3.0);

        //Ensure that mocks are set up correctly
        Assert.assertNotNull(rectangle);
        Assert.assertNotNull(startPoint);
        Assert.assertNotNull(endPoint);
        Assert.assertNotNull(checkPoint);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void lineContainsPoint() {

    }

    @Test
    public void testLineContainsPoint() {
        double tolerance = 5.0;

        Geom.lineContainsPoint(startPoint, endPoint, checkPoint, tolerance);
        Assert.assertEquals(startPoint.getX(), endPoint.getX(), 0.0);
        Assert.assertTrue(abs(checkPoint.getX() - startPoint.getX()) <= tolerance);
        Assert.assertNotEquals(startPoint.getY(), endPoint.getY());


    }
}