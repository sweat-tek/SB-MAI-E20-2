/*
 * @(#)TextAreaEditingTool.java  1.0  2009-04-16
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
package org.jhotdraw.draw;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

import org.jhotdraw.geom.*;
import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoableEdit;

/**
 * A tool to edit existing figures that implement the TextHolderFigure
 * interface, such as TextAreaFigure.
 * <p>
 * To edit an existing text figure using the TextAreaEditingTool, the user does the
 * following mouse gesture on a DrawingView:
 * </p>
 * <ol>
 * <li>Press the mouse button over a Figure on the DrawingView.</li>
 * </ol>
 * <p>
 * The TextAreaEditingTool then uses Figure.findFigureInside to find a Figure that
 * implements the TextHolderFigure interface and that is editable. Then it overlays
 * a text area over the drawing where the user can enter the text for the Figure.
 * </p>
 *
 * @author Werner Randelshofer
 * @version 1.0 2009-04-16 Refactored from TextAreaTool.
 *
 * @see TextHolderFigure
 * @see FloatingTextArea
 */
public class TextAreaEditingTool extends AbstractTool implements ActionListener {

    private FloatingTextArea textArea;
    private TextHolderFigure typingTarget;

    /** Creates a new instance. */
    public TextAreaEditingTool(TextHolderFigure typingTarget) {
        this.typingTarget = typingTarget;
    }


    @Override
    public void deactivate(DrawingEditor editor) {
        endTextAreaEdit();
        //endEdit();

        super.deactivate(editor);
    }

    /**
     * Creates a new figure at the mouse location.
     * If editing is in progress, this finishes editing.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (typingTarget != null) {
            beginEdit(typingTarget);
            updateCursor(getView(), e.getPoint());
        }
    }


    @Override
    public void draw(Graphics2D g) {
    }



    private void endTextAreaEdit() {
        UndoableEdit edit = null;
        if (typingTarget != null) {
            typingTarget.willChange();

            final TextHolderFigure editedFigure = typingTarget;
            final String oldText = typingTarget.getText();
            final String newText = textArea.getText();

            if (newText.length() > 0) {
                typingTarget.setText(newText);
            } else {
                typingTarget.setText("");
            }
            edit = endEdit(textArea, typingTarget);
        }
        //getDrawing().fireUndoableEditHappened(edit);

        getDrawing().fireUndoableEditHappened(edit);

        typingTarget.changed();
        typingTarget = null;

        textArea.endOverlay();
    }


    protected void beginEdit(TextHolderFigure textHolder) {
        if (textArea == null) {
            textArea = new FloatingTextArea();
        }
        beginEdit(typingTarget, textArea, typingTarget);
    }
/*
    protected void endEdit() {
        if (typingTarget != null) {
            typingTarget.willChange();

            final TextHolderFigure editedFigure = typingTarget;
            final String oldText = typingTarget.getText();
            final String newText = textArea.getText();

            if (newText.length() > 0) {
                typingTarget.setText(newText);
            } else {
                typingTarget.setText("");
            }

            UndoableEdit edit = new AbstractUndoableEdit() {

                @Override
                public String getPresentationName() {
                    ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                    return labels.getString("attribute.text.text");
                }

                @Override
                public void undo() {
                    super.undo();
                    editedFigure.willChange();
                    editedFigure.setText(oldText);
                    editedFigure.changed();
                }

                @Override
                public void redo() {
                    super.redo();
                    editedFigure.willChange();
                    editedFigure.setText(newText);
                    editedFigure.changed();
                }
            };
            getDrawing().fireUndoableEditHappened(edit);

            typingTarget.changed();
            typingTarget = null;

            textArea.endOverlay();
        }
        //	        view().checkDamage();
    }*/

    public void actionPerformed(ActionEvent event) {
        endTextAreaEdit();
        //endEdit();
            fireToolDone();
    }

    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
