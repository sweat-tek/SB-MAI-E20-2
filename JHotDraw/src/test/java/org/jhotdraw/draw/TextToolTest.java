package org.jhotdraw.draw;

import java.awt.Color;
import java.awt.geom.Point2D;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Rene_
 */
public class TextToolTest {
    private SVGTextFigure svgTextFigure;
    private FloatingTextField textField; 
   
   @Mock
   private TextHolderFigure typingTarget; 
   
   @Mock
   private TextHolderFigure textHolder;
   
   
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.when(typingTarget.getText()).thenReturn("test");
    }
   
    @Before
    public void newSVGTextFigure() {
        svgTextFigure = new SVGTextFigure();
    }
    
    @Test
    public void TestSVGTextFigureInstanceIsNotNull(){
        assertNotNull(svgTextFigure);
        System.out.println("TestAssertNotNull has success!");
    }
    
    @Test
    public void TestTextFigureHasText(){
        assertEquals("Test", "Text", svgTextFigure.getText());
        System.out.println("TestTextFigureHasText has success!");
    }
    
    @Test
    public void TestFillColor(){
        Color fillColor = svgTextFigure.getFillColor();
        assert fillColor != null; 
        assertEquals("Test of fill color", Color.white, fillColor);
        System.out.println("TestFillColor has success!");
    }
    
    @Test
    public void TestChangesOfCoordinates(){
        Point2D.Double[] coordinates = svgTextFigure.getCoordinates();
        svgTextFigure.setCoordinates(new Point2D.Double[]{new Point2D.Double(0,0)});
        assertArrayEquals("Test of changing coordinates", coordinates, svgTextFigure.getCoordinates());
        System.out.println("TestChangesOfCoordinates has success!");
    }
    
     /**
     * Test of beginEdit method, of class TextEditingTool.
     * NOT DONE!!! 
     */
    @Test
    public void testBeginEdit() {
        System.out.println("beginEdit");
        assertNull(textField);
        textField = new FloatingTextField();
       
        
        assertNotNull(typingTarget);
        assertNotEquals(textHolder, typingTarget);
        //textEditTool.endEdit();
        // endEdit() - nullpointer?? 
        
        //typingTarget = textHolder;

        //textEditTool.endEdit();
        //verify(textEditTool).endEdit();
        System.out.println("TestBeginEdit has success!");
    }
}
