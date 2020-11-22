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
import org.jhotdraw.draw.DrawingView;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author Simon Holland Flarup
 */
public class ZoomActionTest {

    private static DrawingView view;
    private static AbstractButton button;

    public ZoomActionTest() {
        view = mock(DrawingView.class);
        button = mock(AbstractButton.class);
        Rectangle rectangle = new Rectangle();
        JComponent mockJComponent = mock(JComponent.class);
        when(mockJComponent.getVisibleRect()).thenReturn(rectangle);

        when(view.getComponent()).thenReturn(mockJComponent);
        when(view.getScaleFactor()).thenReturn((double) 1);
    }

    private Rectangle setupViewRectangleCopy(Rectangle vRect) {
        Rectangle oldVRect = new Rectangle();
        oldVRect.x = vRect.x;
        oldVRect.y = vRect.y;
        oldVRect.width = vRect.width;
        oldVRect.height = vRect.height;

        return oldVRect;
    }

    private void assertFalseZoom(Rectangle oldVRect, Rectangle vRect) {
        System.out.println("");
        System.out.println("oldVRect:");
        System.out.println(oldVRect);
        System.out.println("vRect:");
        System.out.println(vRect);
        System.out.println("");
        assertFalse(oldVRect.x == vRect.x && oldVRect.y == vRect.y && oldVRect.width == vRect.width && oldVRect.height == vRect.height);
    }

    private void assertTrueZoom(Rectangle oldVRect, Rectangle vRect) {
        assertTrue(oldVRect.x == vRect.x && oldVRect.y == vRect.y && oldVRect.width == vRect.width && oldVRect.height == vRect.height);
    }

    private void testActionPerformed(double scaleFactor) {
        ZoomAction instance = new ZoomAction(view, scaleFactor, button);

        final Rectangle vRect = view.getComponent().getVisibleRect();
        Rectangle oldVRect = setupViewRectangleCopy(vRect);

        System.out.println("actionPerformed");
        ActionEvent e = mock(ActionEvent.class);
        instance.actionPerformed(e);

        assertFalseZoom(oldVRect, vRect);
    }

    public void testActionPerformedOnSameScale() {
        ZoomAction instance = new ZoomAction(view, 1, button);

        final Rectangle vRect = view.getComponent().getVisibleRect();
        Rectangle oldVRect = setupViewRectangleCopy(vRect);

        System.out.println("actionPerformedOnSameScale");
        ActionEvent e = mock(ActionEvent.class);
        instance.actionPerformed(e);

        assertTrueZoom(oldVRect, vRect);
    }

    private void testButtonLabel(double scaleFactor) {
        ZoomAction instance = new ZoomAction(view, scaleFactor, button);
        //Expected format
        String label = (int) (scaleFactor * 100) + " %";

        System.out.println("ButtonLabel");
        ActionEvent e = mock(ActionEvent.class);
        instance.actionPerformed(e);

        verify(button, atLeast(1)).setText(label);
    }
    
    private void setupVRect() {
        Rectangle vRect = view.getComponent().getVisibleRect();
        vRect.x = 10;
        vRect.y = 10;
        vRect.height = 120;
        vRect.width = 480;
    }

    private double[] scaleFactors = new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 10.0, 100.0, 1000.0, 9999.0, 1.1, -1, 0.1, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE + 0.1};

    /**
     * Test of actionPerformed method, of class ZoomAction.
     */
    @Test
    public void testZoomAction() {
        for (double scaleFactor : scaleFactors) {
            System.out.println("\nScaleFactor: " + scaleFactor);
            setupVRect();
            if (scaleFactor == 1) {
                testActionPerformedOnSameScale();
            } else {
                testActionPerformed(scaleFactor);
            }
        }
    }

    /**
     * Test of correct assignment of label to the zoom button
     */
    @Test
    public void testButtonLabelAssignment() {
        for (double scaleFactor : scaleFactors) {
            System.out.println("\nScaleFactor: " + scaleFactor);
            setupVRect();
            testButtonLabel(scaleFactor);
        }
    }
}
