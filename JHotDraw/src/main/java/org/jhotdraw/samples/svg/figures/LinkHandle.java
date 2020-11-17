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

    private int handleSize;
    private boolean handleSizeSet;

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
    public boolean contains(Point p) {
        return false;
    }

    public void setDrawingEditor(DrawingEditor d) {
        this.view.setEditor(d);
    }

    /**
     * Draws this handle.
     *
     * @param g Graphics2D
     */
    @FeatureEntryPoint(JHotDrawFeatures.LINK_PALETTE)
    @Override
    public void draw(Graphics2D g) {
        if (LINK.get(getOwner()) != null && LINK.get(getOwner()).trim().length() > 0) {
            g.setColor((Color) getEditor().getHandleAttribute(HandleAttributeKeys.OVERFLOW_HANDLE_STROKE_COLOR));
            Rectangle r = basicGetBounds();
            g.drawLine(r.x + (r.width / 2) - 1, r.y, r.x, r.y);
            g.drawLine(r.x, r.y, r.x, r.y + r.height - 1);
            g.drawLine(r.x, r.y + r.height - 1, r.x + (r.width / 2) - 1, r.y + r.height - 1);
            g.drawLine(r.x + (r.width / 3), r.y + r.height / 2, r.x + r.width - 1, r.y + r.height / 2);
            g.drawLine(r.x + r.width - 1, r.y + r.height / 2, (int) (r.x + r.width * .75 - 1), (int) (r.y + r.height * .25));
            g.drawLine(r.x + r.width - 1, r.y + r.height / 2, (int) (r.x + r.width * .75 - 1), (int) (r.y + r.height * .75));
        }
    }

    /**
     *
     * @return
     */
    @Override
    protected Rectangle basicGetBounds() {
        Rectangle2D.Double b = getOwner().getBounds();
        Point2D.Double p = new Point2D.Double(b.x + b.width, b.y + b.height);
        if (TRANSFORM.get(getOwner()) != null) {
            TRANSFORM.get(getOwner()).transform(p, p);
        }
        Rectangle r = new Rectangle(view.drawingToView(p));
        try {
            handleSize = getHandlesize();
        } catch (NullPointerException e) {
            handleSize = 1; // Default random value
        }
        r.x -= handleSize * 4;
        r.y -= handleSize;
        r.width = handleSize * 2;
        r.height = handleSize;
        return r;
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
    public String getToolTipText(Point p) {
        String f = LINK.get(getOwner());
        return f != null
                ? ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels").//
                        getString("handle.link.toolTipText")
                : "";
    }

}
