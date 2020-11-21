/*
 * @(#)TextAreaCreationTool.java  2.3.1  2009-09-29
 *
 * Copyright (c) 1996-2009 by the original authors of JHotDraw
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

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.app.JHotDrawFeatures;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Map;

/**
 * A tool to create new or edit existing figures that implement the TextHolderFigure
 * interface, such as TextAreaFigure. The figure to be created is specified by a
 * prototype.
 * <p>
 * To create a figure using the TextAreaCreationTool, the user does the following mouse
 * gestures on a DrawingView:
 * <ol>
 * <li>Press the mouse button over the DrawingView. This defines the
 * start point of the Figure bounds.</li>
 * <li>Drag the mouse while keeping the mouse button pressed, and then release
 * the mouse button. This defines the end point of the Figure bounds.</li>
 * </ol>
 * When the user has performed these mouse gesture, the TextAreaCreationTool overlays
 * a text area over the drawing where the user can enter the text for the Figure.
 * <p>
 * To edit an existing text figure using the TextAreaCreationTool, the user does the
 * following mouse gesture on a DrawingView:
 * </p>
 * <ol>
 * <li>Press the mouse button over a Figure on the DrawingView.</li>
 * </ol>
 * <p>
 * The TextAreaCreationTool then uses Figure.findFigureInside to find a Figure that
 * implements the TextHolderFigure interface and that is editable. Then it overlays
 * a text area over the drawing where the user can enter the text for the Figure.
 * </p>
 * <p>
 * XXX - Maybe this class should be split up into a CreateTextAreaTool and
 * a EditTextAreaTool.
 * </p>
 *
 * @author Werner Randelshofer
 * @version 2.3.1 2009-03-29 Editing of a TextArea which is behind another figure
 * did not work. Partially implemented undoable edit handling.
 * <br>2.3 2008-05-17 Honor toolDoneAfterCreation property.
 * <br>2.2 2007-11-25 Added variable isForCreationOnly.
 * <br>2.1 2007-08-22 Added support for property 'toolDoneAfterCreation'.
 * <br>2.0 2006-01-14 Changed to support double precison coordinates.
 * <br>1.0 2003-12-01 Derived from JHotDraw 5.4b1.
 * @see TextHolderFigure
 * @see FloatingTextArea
 */
public class TextAreaCreationTool extends CreationTool implements ActionListener {

    private FloatingTextArea textArea;
    private TextHolderFigure typingTarget;
    /**
     * Rubberband color of the tool. When this is null, the tool does not
     * draw a rubberband.
     */
    private Color rubberbandColor = null;

    /** Creates a new instance. */
    public TextAreaCreationTool(TextHolderFigure prototype) {
        super(prototype);
    }

    public TextAreaCreationTool(TextHolderFigure prototype, Map<AttributeKey,Object> attributes) {
        super(prototype, attributes);
    }

    /**
     * Sets the rubberband color for the tool. Setting this to null, disables
     * the rubberband.
     *
     * @param c Rubberband color or null.
     */
    public void setRubberbandColor(Color c) {
        rubberbandColor = c;
    }

    @Override
    public void deactivate(DrawingEditor editor) {
       //endEdit();
        super.deactivate(editor);
    }

    /**
     * Creates a new figure at the mouse location.
     * If editing is in progress, this finishes editing.
     */
    @Override
    @FeatureEntryPoint(JHotDrawFeatures.TEXT_AREA_TOOL)
    public void mousePressed(MouseEvent e) {
        TextHolderFigure textHolder = null;

        DrawingView v = getView();
        Point2D.Double p = v.viewToDrawing(e.getPoint());

        Figure pressedFigure = getFigure(v, p);
        pressedFigure = getFigureInDrawing(p, pressedFigure);
        checkTextHolderFigure(textHolder, pressedFigure);
        isToolDone(e);
    }

    private void isToolDone(MouseEvent e) {
        if (typingTarget != null) {
            endTextAreaEdit();
            if (isToolDoneAfterCreation()) {
                fireToolDone();
            }
        } else {
            super.mousePressed(e);
        }
    }

    public Figure getFigure(DrawingView v, Point2D.Double p) {
        Figure pressedFigure = null;
        for (Figure f : v.getSelectedFigures()) {
            if (f.contains(p)) {
                pressedFigure = f;
                break;
            }
        }
        return pressedFigure;
    }

    private void checkTextHolderFigure(TextHolderFigure textHolder, Figure pressedFigure) {
        if (pressedFigure instanceof TextHolderFigure) {
            textHolder = (TextHolderFigure) pressedFigure;
        }

        if (textHolder != null) {
            createdFigure = null;
            beginEdit(textHolder, textArea, typingTarget);
        }
    }

    private Figure getFigureInDrawing(Point2D.Double p, Figure pressedFigure) {
        if (pressedFigure == null) {
            pressedFigure = getDrawing().findFigureInside(p);
        }
        return pressedFigure;
    }


    /**
     * This method allows subclasses to do perform additonal user interactions
     * after the new figure has been created.
     * The implementation of this class just invokes fireToolDone.
     */
    @Override
    protected void creationFinished(Figure createdFigure) {
        getView().clearSelection();
        getView().addToSelection(createdFigure);
        //beginEdit((TextHolderFigure) createdFigure);
    }
    /*
    public void mouseDragged(java.awt.event.MouseEvent e) {
    }
     */

    @Override
    public void draw(Graphics2D g) {
        if (createdFigure != null && rubberbandColor != null) {
            g.setColor(rubberbandColor);
            g.draw(getView().drawingToView(createdFigure.getBounds()));
        }
    }


    @FeatureEntryPoint(JHotDrawFeatures.TEXT_AREA_TOOL)
    protected void endTextAreaEdit() {
        if (typingTarget != null) {
            typingTarget.willChange();
            final String newText = textArea.getText();

            if (newText.length() > 0) {
                typingTarget.setText(newText);
            } else {
                removeFigure();
            }
            textAreaEndEdit(textArea, typingTarget);
        }
    }

    private void removeFigure() {
        if (createdFigure != null) {
            getDrawing().remove((Figure) getAddedFigure());
            // XXX - Fire undoable edit here!!
        } else {
            typingTarget.setText("");
        }
    }

    public void actionPerformed(ActionEvent event) {
        //endEdit();
        if (isToolDoneAfterCreation()) {
            fireToolDone();
        }
    }
}
