/*
 * @(#)AbstractHandle.java  2.0  2008-05-11
 *
 * Copyright (c) 1996-2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.draw;

import java.util.Collection;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.undo.*;
import java.util.*;

/**
 * AbstractHandle.
 *
 * @author Werner Randelshofer
 * @version 2.0 2008-05-11 Handle attributes are now retrieved from
 * DrawingEditor.
 * <br>1.0 2003-12-01 Derived from JHotDraw 5.4b1.
 */
public abstract class AbstractHandle implements Handle, FigureListener {

    final private Figure owner;
    protected DrawingView view;
    protected EventListenerList listenerList = new EventListenerList();
    /**
     * The bounds of the abstract handle.
     */
    private Rectangle bounds;

    /**
     * Creates a new instance.
     *
     * @param owner
     */
    public AbstractHandle(Figure owner) {
        if (owner == null) {
            throw new IllegalArgumentException("owner must not be null");
        }
        this.owner = owner;
        owner.addFigureListener(this);
    }

    protected int getHandlesize() {
        return getEditor().getHandleAttribute(HandleAttributeKeys.HANDLE_SIZE);
    }

    /**
     * Adds a listener for this handle.
     *
     * @param handleListener
     */
    @Override
    public void addHandleListener(HandleListener handleListener) {
        listenerList.add(HandleListener.class, handleListener);
    }

    /**
     * Removes a listener for this handle.
     *
     * @param handleListener
     */
    @Override
    public void removeHandleListener(HandleListener handleListener) {
        listenerList.remove(HandleListener.class, handleListener);
    }

    @Override
    public Figure getOwner() {
        return owner;
    }

    @Override
    public void setView(DrawingView view) {
        this.view = view;
    }

    public DrawingView getView() {
        return view;
    }

    public DrawingEditor getEditor() {
        return view.getEditor();
    }

    /**
     * Notify all listenerList that have registered interest for notification on
     * this event type.
     *
     * @param invalidatedArea
     */
    protected void fireAreaInvalidated(Rectangle invalidatedArea) {
        HandleEvent event = null;
        // Notify all listeners that have registered interest for
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == HandleListener.class) {
                // Lazily create the event:
                if (event == null) {
                    event = new HandleEvent(this, invalidatedArea);
                }
                ((HandleListener) listeners[i + 1]).areaInvalidated(event);
            }
        }
    }

    /**
     * Notify all listenerList that have registered interest for notification on
     * this event type.
     *
     * @param edit
     */
    protected void fireUndoableEditHappened(UndoableEdit edit) {
        view.getDrawing().fireUndoableEditHappened(edit);
    }

    /**
     * Notify all listenerList that have registered interest for notification on
     * this event type.
     *
     * @param invalidatedArea
     */
    protected void fireHandleRequestRemove(Rectangle invalidatedArea) {
        HandleEvent event = null;
        // Notify all listeners that have registered interest for
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == HandleListener.class) {
                // Lazily create the event:
                if (event == null) {
                    event = new HandleEvent(this, invalidatedArea);
                }
                ((HandleListener) listeners[i + 1]).handleRequestRemove(event);
            }
        }
    }

    /**
     * Notify all listenerList that have registered interest for notification on
     * this event type.
     */
    protected void fireHandleRequestSecondaryHandles() {
        HandleEvent event = null;
        // Notify all listeners that have registered interest for
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == HandleListener.class) {
                // Lazily create the event:
                if (event == null) {
                    event = new HandleEvent(this, null);
                }
                ((HandleListener) listeners[i + 1]).handleRequestSecondaryHandles(event);
            }
        }
    }

    /**
     * Draws this handle.
     *
     * @param graphics2D
     */
    @Override
    public void draw(Graphics2D graphics2D) {
        drawCircle(graphics2D,
                (Color) getEditor().getHandleAttribute(HandleAttributeKeys.HANDLE_FILL_COLOR),
                (Color) getEditor().getHandleAttribute(HandleAttributeKeys.HANDLE_STROKE_COLOR));
    }

    protected void drawCircle(Graphics2D graphics2D, Color fill, Color stroke) {
        Rectangle rectangle = getBounds();
        if (fill != null) {
            graphics2D.setColor(fill);
            graphics2D.fillOval(rectangle.x + 1, rectangle.y + 1, rectangle.width - 2, rectangle.height - 2);
        }
        if (stroke != null) {
            graphics2D.setStroke(new BasicStroke());
            graphics2D.setColor(stroke);
            graphics2D.drawOval(rectangle.x, rectangle.y, rectangle.width - 1, rectangle.height - 1);

            if (getView().getActiveHandle() == this) {
                graphics2D.fillOval(rectangle.x + 2, rectangle.y + 2, rectangle.width - 4, rectangle.height - 4);
            }
        }
    }

    protected void drawRectangle(Graphics2D graphics2D, Color fill, Color stroke) {
        if (fill != null) {
            Rectangle rectangle = getBounds();
            graphics2D.setColor(fill);
            rectangle.x += 1;
            rectangle.y += 1;
            rectangle.width -= 2;
            rectangle.height -= 2;
            graphics2D.fill(rectangle);
        }
        graphics2D.setStroke(new BasicStroke());
        if (stroke != null) {
            Rectangle rectangle = getBounds();
            rectangle.width -= 1;
            rectangle.height -= 1;
            graphics2D.setColor(stroke);
            graphics2D.draw(rectangle);
            if (getView().getActiveHandle() == this) {
                rectangle.x += 2;
                rectangle.y += 2;
                rectangle.width -= 3;
                rectangle.height -= 3;
                graphics2D.fill(rectangle);
            }
        }
    }

    protected void drawDiamond(Graphics2D graphics2D, Color fill, Color stroke) {
        if (stroke != null) {
            Rectangle rectangle = getBounds();
            rectangle.grow(1, 1);
            GeneralPath generalPath = new GeneralPath();
            generalPath.moveTo(rectangle.x + rectangle.width / 2f, rectangle.y);
            generalPath.lineTo(rectangle.x + rectangle.width, rectangle.y + rectangle.height / 2f);
            generalPath.lineTo(rectangle.x + rectangle.width / 2f, rectangle.y + rectangle.height);
            generalPath.lineTo(rectangle.x, rectangle.y + rectangle.height / 2f);
            generalPath.closePath();
            graphics2D.setColor(stroke);
            graphics2D.fill(generalPath);
        }
        if (fill != null) {
            Rectangle r = getBounds();
            GeneralPath generalPath = new GeneralPath();
            generalPath.moveTo(r.x + r.width / 2f, r.y);
            generalPath.lineTo(r.x + r.width, r.y + r.height / 2f);
            generalPath.lineTo(r.x + r.width / 2f, r.y + r.height);
            generalPath.lineTo(r.x, r.y + r.height / 2f);
            generalPath.closePath();
            graphics2D.setColor(fill);
            graphics2D.fill(generalPath);
        }
        if (stroke != null && getView().getActiveHandle() == this) {
            Rectangle r = getBounds();
            r.grow(-1, -1);
            GeneralPath p = new GeneralPath();
            p.moveTo(r.x + r.width / 2f, r.y);
            p.lineTo(r.x + r.width, r.y + r.height / 2f);
            p.lineTo(r.x + r.width / 2f, r.y + r.height);
            p.lineTo(r.x, r.y + r.height / 2f);
            p.closePath();
            graphics2D.setColor(stroke);
            graphics2D.fill(p);
        }
    }

    @Override
    public boolean contains(Point point) {
        return getBounds().contains(point);
    }

    @Override
    public void invalidate() {
        bounds = null;
    }

    @Override
    public void dispose() {
        owner.removeFigureListener(this);
        //owner = null;
    }

    /**
     * Sent when a region used by the figure needs to be repainted.The
     * implementation of this method assumes that the handle is located on the
     * bounds of the figure or inside the figure. If the handle is located
     * elsewhere this method must be reimpleted by the subclass.
     *
     * @param figureEvent
     */
    @Override
    public void areaInvalidated(FigureEvent figureEvent) {
        updateBounds();
    }

    /**
     * Sent when a figure was added.
     *
     * @param figureEvent
     */
    @Override
    public void figureAdded(FigureEvent figureEvent) {
        // Empty
    }

    /**
     * Sent when a figure was removed.
     * @param figureEvent
     */
    @Override
    public void figureRemoved(FigureEvent figureEvent) {
        // Empty
    }

    /**
     * Sent when a figure requests to be removed.
     *
     * @param figureEvent
     */
    @Override
    public void figureRequestRemove(FigureEvent figureEvent) {
        // Empty
    }

    /**
     * Sent when the bounds or shape of a figure has changed.
     *
     * @param figureEvent
     */
    @Override
    public void figureChanged(FigureEvent figureEvent) {
        updateBounds();
    }

    /**
     * Returns a cursor for the handle.
     *
     * @return Cursor
     */
    @Override
    public Cursor getCursor() {
        return Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
    }

    /**
     * Returns true, if the given handle is an instance of the same class or of
     * a subclass of this handle,.
     *
     * @param handle
     * @return boolean
     */
    @Override
    public boolean isCombinableWith(Handle handle) {
        return getClass().isAssignableFrom(handle.getClass());
    }

    @Override
    public void keyTyped(KeyEvent evt) {
    }

    @Override
    public void keyReleased(KeyEvent evt) {
    }

    @Override
    public void keyPressed(KeyEvent evt) {
    }

    @Override
    public final Rectangle getBounds() {
        if (bounds == null) {
            bounds = basicGetBounds();
        }
        return (Rectangle) bounds.clone();
    }

    @Override
    public Rectangle getDrawingArea() {
        Rectangle rectangle = getBounds();
        rectangle.grow(2, 2); // grow by two pixels to take antialiasing into account

        return rectangle;
    }

    protected abstract Rectangle basicGetBounds();

    protected void updateBounds() {
        Rectangle newBounds = basicGetBounds();
        if (bounds == null || !newBounds.equals(bounds)) {
            if (bounds != null) {
                fireAreaInvalidated(getDrawingArea());
            }
            bounds = newBounds;
            fireAreaInvalidated(getDrawingArea());
        }
    }

    /**
     * Tracks a double click.
     *
     * @param point
     * @param modifiersEx
     */
    @Override
    public void trackDoubleClick(Point point, int modifiersEx) {
    }

    @Override
    public void attributeChanged(FigureEvent figureEvent) {
    }

    @Override
    public void viewTransformChanged() {
        invalidate();
    }

    @Override
    public Collection<Handle> createSecondaryHandles() {
        return Collections.emptyList();
    }

    @Override
    public String getToolTipText(Point point) {
        return null;
    }

    /**
     * 
     * @param figureEvent
     */
    @Override
    public void figureHandlesChanged(FigureEvent figureEvent) {
    }
}
