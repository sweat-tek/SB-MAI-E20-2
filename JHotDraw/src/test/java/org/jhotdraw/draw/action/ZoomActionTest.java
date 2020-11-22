/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.jhotdraw.draw.DrawingView;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import static org.mockito.Mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 *
 * @author Simon Holland Flarup
 */
@RunWith(JUnitParamsRunner.class)
public class ZoomActionTest {

    @Captor ArgumentCaptor<Rectangle> captor;
    
    private DrawingView view;
    private AbstractButton button;
    private JComponent mockJComponent;

    public ZoomActionTest() {

    }

    @Before
    public void setUp() {
        view = mock(DrawingView.class);
        button = mock(AbstractButton.class);
        Rectangle rectangle = new Rectangle(10, 20, 120, 480);
        mockJComponent = mock(JComponent.class);
        when(mockJComponent.getVisibleRect()).thenReturn(rectangle);

        when(view.getComponent()).thenReturn(mockJComponent);
        when(view.getScaleFactor()).thenReturn((double) 1);
        
        
        captor = ArgumentCaptor.forClass(Rectangle.class);
    }

    private Rectangle setupViewRectangleCopy(Rectangle vRect) {
        Rectangle oldVRect = (Rectangle) vRect.clone();

        return oldVRect;
    }

    private void assertFalseZoom(Rectangle oldVRect, Rectangle vRect) {
        /*System.out.println("");
        System.out.println("oldVRect:");
        System.out.println(oldVRect);
        System.out.println("vRect:");
        System.out.println(vRect);
        System.out.println("");*/
        assertFalse(oldVRect.x == vRect.x && oldVRect.y == vRect.y && oldVRect.width == vRect.width && oldVRect.height == vRect.height);
    }

    private void assertTrueZoom(Rectangle oldVRect, Rectangle vRect) {
        assertTrue(oldVRect.x == vRect.x && oldVRect.y == vRect.y && oldVRect.width == vRect.width && oldVRect.height == vRect.height);
    }

    @Test
    @Parameters({"2.0", "3.0", "4.0", "5.0", "10.0", "100.0", "1000.0", "9999.0", "1.1", "-1", "0.1", "" + Double.MAX_VALUE, "" + Double.MIN_VALUE})
    public void testActionPerformed(double scaleFactor) {
        ZoomAction instance = new ZoomAction(view, scaleFactor, button);

        final Rectangle vRect = view.getComponent().getVisibleRect();
        Rectangle oldVRect = setupViewRectangleCopy(vRect);

        ActionEvent e = mock(ActionEvent.class);
        
        instance.actionPerformed(e);
        
        verify(view).setScaleFactor(scaleFactor);
        
        verify(mockJComponent, timeout(1000).times(1)).scrollRectToVisible(captor.capture());

        assertFalseZoom(oldVRect, captor.getValue());
    }

    @Test
    public void testActionPerformedOnSameScale() {
        ZoomAction instance = new ZoomAction(view, 1, button);

        final Rectangle vRect = view.getComponent().getVisibleRect();
        Rectangle oldVRect = setupViewRectangleCopy(vRect);

        ActionEvent e = mock(ActionEvent.class);
        instance.actionPerformed(e);
        
        verify(view).setScaleFactor(1);
    }

    @Test
    @Parameters({"1.0", "2.0", "3.0", "4.0", "5.0", "10.0", "100.0", "1000.0", "9999.0", "1.1", "-1", "0.1", "" + Double.MAX_VALUE, "" + Double.MIN_VALUE})
    public void testButtonLabel(double scaleFactor) {
        ZoomAction instance = new ZoomAction(view, scaleFactor, button);
        //Expected format
        String label = (int) (scaleFactor * 100) + " %";

        ActionEvent e = mock(ActionEvent.class);
        instance.actionPerformed(e);

        verify(button, atLeast(1)).setText(label);
    }
}
