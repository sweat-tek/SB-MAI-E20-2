/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author JogGez
 */
public abstract class AbstractBasicEditingAction extends AbstractAction {
    public ResourceBundleUtil labels;

    AbstractBasicEditingAction(String ID) {
        labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
    }
}
