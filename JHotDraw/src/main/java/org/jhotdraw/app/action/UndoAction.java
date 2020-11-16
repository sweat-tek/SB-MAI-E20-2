/*
 * @(#)UndoAction.java  2.0  2006-06-15
 *
 * Copyright (c) 1996-2007 by the original authors of JHotDraw
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
import org.jhotdraw.util.*;
import org.jhotdraw.app.Application;

/**
 * Undoes the last user action.
 * In order to work, this action requires that the View returns a view-specific 
 * undo action when invoking getAction(UndoAction.ID) on the View.
 *
 *
 * @author Werner Randelshofer
 * @version 2.0 2006-06-15 Reworked.
 * <br>1.0 October 9, 2005 Created.
 */
public class UndoAction extends AbstractUndoRedoAction {
    public final static String ID = "edit.undo";

    /** Creates a new instance. */
    public UndoAction(Application app) {
        super(app, ID);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
        setPropertyChangeListener();
    }
}
