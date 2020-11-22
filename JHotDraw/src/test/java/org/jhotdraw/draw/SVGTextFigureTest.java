package org.jhotdraw.draw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

import static org.mockito.Mockito.when;

/**
 *
 * @author Rene_
 */
public class SVGTextFigureTest {
    private SVGTextFigure svgTextFigure;
    
    @Mock
    private Rectangle2D rectangle;
    
    @Before
    public void setUp() throws Exception {
        svgTextFigure = new SVGTextFigure();
        MockitoAnnotations.initMocks(this);

        //Checks that mocks not are null 
        Assert.assertNotNull(svgTextFigure);
        Assert.assertNotNull(rectangle);
    }
    
    @Test
    public void TestBounds2D(){
    
    when(rectangle.getBounds2D()).thenReturn(new Rectangle((int) 0.0, (int) 0.0,
                (int) 0.0, (int) 0.0){
        });
        svgTextFigure.setText("");
        System.out.println("Recangle bounds: " + rectangle.getBounds2D());
        System.out.println("SVGFigure bounds: " + svgTextFigure.getTextShape().getBounds2D());
        Assert.assertEquals(rectangle.getBounds2D(), svgTextFigure.getTextShape().getBounds2D());
        Assert.assertTrue(svgTextFigure.isEmpty());
        System.out.println("TestBounds2D has success!");
    }
}
