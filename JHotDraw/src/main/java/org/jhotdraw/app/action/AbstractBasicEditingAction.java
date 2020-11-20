/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.app.action;

import org.jhotdraw.util.ResourceBundleUtil;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import java.awt.*;
import java.awt.event.*;
import java.util.Optional;
import javax.swing.*;
import org.jhotdraw.app.EditableComponent;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.util.*;

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
    
    public Component getComponent(){
        Component component = KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();
        return component;
    }
    
    @FeatureEntryPoint(JHotDrawFeatures.BASIC_EDITING)
    public void actionPerformed(ActionEvent event) {
        Component component = (getComponent() != null) ? getComponent() : new NullComponent();
        preformAction(event, component);
    }

    protected abstract void preformAction(ActionEvent event, Component component);  
}
