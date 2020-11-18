package org.jhotdraw.draw;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import static org.jhotdraw.draw.AttributeKeys.CANVAS_HEIGHT;
import static org.jhotdraw.draw.AttributeKeys.CANVAS_WIDTH;

class DrawingViewEventHandler implements FigureListener, CompositeFigureListener, HandleListener, FocusListener {

    private final DefaultDrawingView drawingView;

    public DrawingViewEventHandler(DefaultDrawingView drawingView) {
        this.drawingView = drawingView;
    }

    public void figureAdded(CompositeFigureEvent evt) {
        if (drawingView.getDrawing().getChildCount() == 1 && drawingView.getEmptyDrawingMessage() != null) {
            drawingView.repaint();
        } else {
            drawingView.repaintDrawingArea(evt.getInvalidatedArea());
        }
        drawingView.invalidateDimension();
    }

    public void figureRemoved(CompositeFigureEvent evt) {
        if (drawingView.getDrawing().getChildCount() == 0 && drawingView.getEmptyDrawingMessage() != null) {
            drawingView.repaint();
        } else {
            drawingView.repaintDrawingArea(evt.getInvalidatedArea());
        }
        drawingView.removeFromSelection(evt.getChildFigure());
        drawingView.invalidateDimension();
    }

    public void areaInvalidated(FigureEvent evt) {
        drawingView.repaintDrawingArea(evt.getInvalidatedArea());
        drawingView.invalidateDimension();
    }

    public void areaInvalidated(HandleEvent evt) {
        drawingView.repaint(evt.getInvalidatedArea());
        drawingView.invalidateDimension();
    }

    public void handleRequestSecondaryHandles(HandleEvent e) {
        drawingView.secondaryHandleOwner = e.getHandle();
        drawingView.secondaryHandles.clear();
        drawingView.secondaryHandles.addAll(drawingView.secondaryHandleOwner.createSecondaryHandles());
        for (Handle h : drawingView.secondaryHandles) {
            h.setView(drawingView);
            h.addHandleListener(drawingView.eventHandler);
        }
        drawingView.repaint();
    }

    public void focusGained(FocusEvent e) {
        //   repaintHandles();
        if (drawingView.editor != null) {
            drawingView.editor.setActiveView(drawingView);
        }
    }

    public void focusLost(FocusEvent e) {
        //   repaintHandles();
    }

    public void handleRequestRemove(HandleEvent e) {
        drawingView.selectionHandles.remove(e.getHandle());
        e.getHandle().dispose();
        drawingView.invalidateHandles();
        drawingView.repaint(e.getInvalidatedArea());
    }

    public void attributeChanged(FigureEvent e) {
        if (e.getSource() == drawingView.getDrawing()) {
            if (e.getAttribute().equals(CANVAS_HEIGHT) || e.getAttribute().equals(CANVAS_WIDTH)) {
                drawingView.validateViewTranslation();
            }
            drawingView.repaint();
        } else {
            drawingView.repaintDrawingArea(e.getInvalidatedArea());
        }
    }

    public void figureChanged(FigureEvent e) {
        drawingView.repaintDrawingArea(e.getInvalidatedArea());
    }

    public void figureHandlesChanged(FigureEvent e) { }
    public void figureAdded(FigureEvent e) { }
    public void figureRemoved(FigureEvent e) { }
    public void figureRequestRemove(FigureEvent e) { }
}
