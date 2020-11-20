/*
 * @(#)DuplicateAction.java  1.0  February 27, 2006
 *
 * Copyright (c) 1996-2006 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */

package org.jhotdraw.app.action;

import java.awt.*;
import java.awt.event.*;
import org.jhotdraw.app.EditableComponent;

/**
 * DuplicateAction.
 *
 * @author Werner Randelshofer.
 * @version 1.0 February 27, 2006 Created.
 */
public class DuplicateAction extends AbstractBasicEditingAction {
    public final static String ID = "edit.duplicate";
    
    /** Creates a new instance. */
    public DuplicateAction() {
        super(ID);
    }

    @Override
    protected void preformAction(ActionEvent event, Component component) {
        if (component instanceof EditableComponent) {
            ((EditableComponent) component).duplicate();
        } else {
            component.getToolkit().beep();
        }
        
    }
}