package org.jhotdraw.app.action;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.app.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class AbstractUndoRedoAction extends AbstractViewAction{

    private PropertyChangeListener redoActionPropertyListener;
    private String ID;

    /**
     * Creates a new instance.
     *
     * @param app
     */
    public AbstractUndoRedoAction(Application app) {
        super(app);
    }

    protected void updateEnabledState() {
        boolean isEnabled = false;
        Action realRedoAction = getRealRedoAction();
        if (realRedoAction != null) {
            isEnabled = realRedoAction.isEnabled();
        }
        setEnabled(isEnabled);
    }

    @Override protected void updateView(View oldValue, View newValue) {
        super.updateView(oldValue, newValue);
        if (newValue != null && newValue.getAction(ID) !=  null) {
            putValue(AbstractAction.NAME, newValue.getAction(ID).
                    getValue(AbstractAction.NAME));
            updateEnabledState();
        }
    }
    /**
     * Installs listeners on the view object.
     */
    @Override protected void installViewListeners(View p) {
        super.installViewListeners(p);
        if (p.getAction(ID) != null) {
            p.getAction(ID).addPropertyChangeListener(redoActionPropertyListener);
        }
    }
    /**
     * Installs listeners on the view object.
     */
    @Override protected void uninstallViewListeners(View p) {
        super.uninstallViewListeners(p);
        if (p.getAction(ID) != null) {
            p.getAction(ID).removePropertyChangeListener(redoActionPropertyListener);
        }
    }

    @FeatureEntryPoint(JHotDrawFeatures.UNDO_REDO)
    public void actionPerformed(ActionEvent e) {
        Action realRedoAction = getRealRedoAction();
        if (realRedoAction != null) {
            realRedoAction.actionPerformed(e);
        }
    }

    private Action getRealRedoAction() {
        return (getActiveView() == null) ? null : getActiveView().getAction(ID);
    }

    public PropertyChangeListener setPropertyChangeListener() {
        redoActionPropertyListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String name = evt.getPropertyName();
                if (name == AbstractAction.NAME) {
                    putValue(AbstractAction.NAME, evt.getNewValue());
                } else if (name == "enabled") {
                    updateEnabledState();
                }
            }
        };
        return redoActionPropertyListener;
    }

    public String setID(String ID) {
        return this.ID = ID;
    }
}
