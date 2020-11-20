package org.jhotdraw.samples.svg.figures;

import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.TextAreaEditingTool;
import org.jhotdraw.geom.Insets2D;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import static org.mockito.Mockito.when;

public class SVGTextAreaFigureTest {
    private SVGTextAreaFigure svgTextAreaFigure;
    @Mock
    private Point2D.Double p;
    @Mock
    private Point2D.Double anchor;
    @Mock
    private Point2D.Double lead;
    @Mock
    private TextAreaEditingTool textAreaEditingTool;
    @Mock
    AttributeKey<AffineTransform> TRANSFORM;
    @Mock
    private Rectangle2D r;
    @Mock
    private Insets2D.Double insets;


    @Before
    public void setUp() throws Exception {
        svgTextAreaFigure = new SVGTextAreaFigure();
        MockitoAnnotations.initMocks(this);

        //Ensure all mocks are setup correctly
        Assert.assertNotNull(p);
        Assert.assertNotNull(svgTextAreaFigure);
        Assert.assertNotNull(anchor);
        Assert.assertNotNull(lead);
        Assert.assertNotNull(insets);
    }

    @After
    public void tearDown() throws Exception {
        svgTextAreaFigure = null;
    }

    @Test
    public void contains() throws NoninvertibleTransformException {

        when(r.getBounds2D()).thenReturn(new Rectangle((int) 0.0, (int) 0.0,
                (int) 0.0, (int) 0.0){
        });
        svgTextAreaFigure.setText("");
        System.out.println(p);
        when(p.getX()).thenReturn(1.0);
        when(p.getY()).thenReturn(2.0);
        //p = (Point2D.Double) TRANSFORM.get(svgTextAreaFigure).inverseTransform(p, new Point2D.Double());

        //Assert.assertEquals(r.getBounds2D(), svgTextAreaFigure.getTextShape().getBounds2D());
        Assert.assertTrue(svgTextAreaFigure.isEmpty());
    }

    @Test
    public void isTextOverflow() {
        svgTextAreaFigure.setBounds(new Point2D.Double(2.0, 2.0), new Point2D.Double(5.0, 3.0));
        insets.set(2.0, 0.01, 3.0, 0.01);
        Assert.assertEquals(3.0, svgTextAreaFigure.getBounds().getWidth(), 0.01);
        Assert.assertEquals(1.0, svgTextAreaFigure.getBounds().getHeight(), 0.01);
        Assert.assertTrue(svgTextAreaFigure.getPreferredTextSize(svgTextAreaFigure.getBounds().width - insets.left -
                insets.right).height > svgTextAreaFigure.getBounds().height - insets.top - insets.bottom);

    }

    @Test
    public void setBounds() {
        anchor.x = 35;
        anchor.y = 12;
        lead.x = 10;
        lead.y = 3;
        Assert.assertEquals(25, Math.max(0.1, Math.abs(lead.x - anchor.x)), 0.5);
        Assert.assertEquals(9, Math.max(0.1, Math.abs(lead.y - anchor.y)), 0.5);
    }


    @Test
    public void getTool() {
        Assert.assertTrue(svgTextAreaFigure.isEditable());
        Assert.assertFalse(svgTextAreaFigure.contains(p));
    }

    @Test
    public void isEmpty() {
        svgTextAreaFigure.setText("");
        Assert.assertNotNull(svgTextAreaFigure.getText());
        Assert.assertEquals(0, svgTextAreaFigure.getText().length());
    }
}