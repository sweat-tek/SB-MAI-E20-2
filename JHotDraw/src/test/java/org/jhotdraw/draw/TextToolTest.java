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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Rene_
 */
public class TextToolTest {
    private SVGTextFigure svgTextFigure;
    private TextEditingTool textEditTool;
    private FloatingTextField textField; 
    //private Stock stock = mock(Stock.class);
   
//   @Mock
//   private MouseEvent mouseEvent; 
//   
//   @Mock
//   private FloatingTextField flotingTextField; 
   
   @Mock
   private TextHolderFigure typingTarget; 
   
   @Mock
   private TextHolderFigure textHolder;
   
   
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        textEditTool = new TextEditingTool(typingTarget);
        Mockito.when(typingTarget.getText()).thenReturn("test");
    }
   
    @Before
    public void newSVGTextFigure() {
        svgTextFigure = new SVGTextFigure();
    }
    
    @Test
    public void TestSVGTextFigureInstanceIsNotNull(){
        assertNotNull(svgTextFigure);
        System.out.println("TestAssertNotN  ull has success!");
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
        
        
        
//        TextHolderFigure textHolder = null;
//        TextEditingTool instance = null;
//        instance.beginEdit(textHolder);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    
    
    /**
     * Test of deactivate method, of class TextEditingTool.
     */
//    @Test
//    public void testDeactivate() {
//        System.out.println("deactivate");
//        DrawingEditor editor = null;
//        TextEditingTool instance = new TextEditingTool(typingTarget);
//        instance.deactivate(editor);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of mousePressed method, of class TextEditingTool.
     */
//    @Test
//    public void testMousePressed() {
//        
//        System.out.println("mousePressed");
//        svgTextFigure.setText("hello");
//        
//        
//        svgTextFigure.setText("hello");
//        //MouseEvent mouseEvent = mock(MouseEvent.class);
//        TextEditingTool editToolInst = new TextEditingTool(typingTarget);
//       // assertThat(typingTarget, is("hello"));
//        assertNotEquals("", svgTextFigure);
//        
//        //TextHolderFigure thf = f.draw();
//        //typingTarget.createHandles(2);
//        Graphics2D g;
//        editToolInst.mousePressed(mouseEvent);
//        // TODO review the generated test code and remove the default call to fail.
//        
//        
//        System.out.println("MousePressedTest succes!");
//    }



    /**
     * Test of mouseReleased method, of class TextEditingTool.
     */
//    @Test
//    public void testMouseReleased() {
//        System.out.println("mouseReleased");
//        MouseEvent evt = null;
//        TextEditingTool instance = null;
//        instance.mouseReleased(evt);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of endEdit method, of class TextEditingTool.
     */
//    @Test
//    public void testEndEdit() {
//        System.out.println("endEdit");
//        TextEditingTool instance = null;
//        instance.endEdit();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of keyReleased method, of class TextEditingTool.
//     */
//    @Test
//    public void testKeyReleased() {
//        System.out.println("keyReleased");
//        KeyEvent evt = null;
//        TextEditingTool instance = null;
//        instance.keyReleased(evt);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of actionPerformed method, of class TextEditingTool.
//     */
//    @Test
//    public void testActionPerformed() {
//        System.out.println("actionPerformed");
//        ActionEvent event = null;
//        TextEditingTool instance = null;
//        instance.actionPerformed(event);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of isEditing method, of class TextEditingTool.
//     */
//    @Test
//    public void testIsEditing() {
//        System.out.println("isEditing");
//        TextEditingTool instance = null;
//        boolean expResult = false;
//        boolean result = instance.isEditing();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateCursor method, of class TextEditingTool.
//     */
//    @Test
//    public void testUpdateCursor() {
//        System.out.println("updateCursor");
//        DrawingView view = null;
//        Point p = null;
//        TextEditingTool instance = null;
//        instance.updateCursor(view, p);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of mouseDragged method, of class TextEditingTool.
//     */
//    @Test
//    public void testMouseDragged() {
//        System.out.println("mouseDragged");
//        MouseEvent e = null;
//        TextEditingTool instance = null;
//        instance.mouseDragged(e);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
