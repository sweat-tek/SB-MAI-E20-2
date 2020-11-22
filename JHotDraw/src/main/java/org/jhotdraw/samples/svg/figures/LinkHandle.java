/*
 * @(#)LinkHandle.java  1.0  2009-04-16
 *
 * Copyright (c) 2009 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and
 * contributors of the JHotDraw project ("the copyright holders").
 * You may not use, copy or modify this software, except in
 * accordance with the license agreement you entered into with
 * the copyright holders. For details see accompanying license terms.
 */
package org.jhotdraw.samples.svg.figures;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.draw.*;
import java.awt.*;
import java.awt.geom.*;
import org.jhotdraw.app.JHotDrawFeatures;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * The LinkHandle indicates when a figure has a link.
 *
 * @author Werner Randelshofer
 * @version 1.0 2009-04-16 Created.
 */
public class LinkHandle extends AbstractHandle {

    /**
     * Creates a new instance.
     *
     * @param owner
     */
    public LinkHandle(Figure owner) {
        super(owner);
    }

    @Override
    public void setView(DrawingView view) {
        this.view = view;
    }

    public LinkHandle makeLinkHandle(Figure owner) {
        return new LinkHandle(owner);
    }

    @Override
    public DrawingView getView() {
        return view;
    }

    @Override
    public boolean contains(Point point) {
        return false;
    }

    public void setDrawingEditor(DrawingEditor drawingEditor) {
        this.view.setEditor(drawingEditor);
    }

    /**
     * Draws this handle.
     *
     * @param graphics Graphics2D
     */
    @FeatureEntryPoint(JHotDrawFeatures.LINK_PALETTE)
    @Override
    public void draw(Graphics2D graphics) {
        if (LINK.get(getOwner()) != null && LINK.get(getOwner()).trim().length() > 0) {
            graphics.setColor((Color) getEditor().getHandleAttribute(HandleAttributeKeys.OVERFLOW_HANDLE_STROKE_COLOR));
            Rectangle rectangle = basicGetBounds();
            graphics.drawLine(rectangle.x + (rectangle.width / 2) - 1, rectangle.y, rectangle.x, rectangle.y);
            graphics.drawLine(rectangle.x, rectangle.y, rectangle.x, rectangle.y + rectangle.height - 1);
            graphics.drawLine(rectangle.x, rectangle.y + rectangle.height - 1, rectangle.x + (rectangle.width / 2) - 1, rectangle.y + rectangle.height - 1);
            graphics.drawLine(rectangle.x + (rectangle.width / 3), rectangle.y + rectangle.height / 2, rectangle.x + rectangle.width - 1, rectangle.y + rectangle.height / 2);
            graphics.drawLine(rectangle.x + rectangle.width - 1, rectangle.y + rectangle.height / 2, (int) (rectangle.x + rectangle.width * .75 - 1), (int) (rectangle.y + rectangle.height * .25));
            graphics.drawLine(rectangle.x + rectangle.width - 1, rectangle.y + rectangle.height / 2, (int) (rectangle.x + rectangle.width * .75 - 1), (int) (rectangle.y + rectangle.height * .75));
        }
    }

    /**
     *
     * @return Rectangle of basic bounds
     */
    @Override
    protected Rectangle basicGetBounds() {
        Rectangle2D.Double rectangleDoubleBoundsDouble = getOwner().getBounds();
        Point2D.Double pointDouble = new Point2D.Double(rectangleDoubleBoundsDouble.x + rectangleDoubleBoundsDouble.width, rectangleDoubleBoundsDouble.y + rectangleDoubleBoundsDouble.height);
        if (TRANSFORM.get(getOwner()) != null) {
            TRANSFORM.get(getOwner()).transform(pointDouble, pointDouble);
        }
        Rectangle rectangle = new Rectangle(view.drawingToView(pointDouble));

        int handleSize = getHandlesize();

        rectangle.x -= handleSize * 4;
        rectangle.y -= handleSize;
        rectangle.width = handleSize * 2;
        rectangle.height = handleSize;
        return rectangle;
    }

    @Override
    public void trackStart(Point anchor, int modifiersEx) {
    }

    @Override
    public void trackStep(Point anchor, Point lead, int modifiersEx) {
    }

    @Override
    public void trackEnd(Point anchor, Point lead, int modifiersEx) {
    }

    @Override
    public String getToolTipText(Point point) {
        String f = LINK.get(getOwner());
        return f != null
                ? ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels").
                        getString("handle.link.toolTipText")
                : "";
    }

}
