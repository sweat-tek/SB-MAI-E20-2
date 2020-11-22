package org.jhotdraw.app.action;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.app.View;
import org.jhotdraw.util.ResourceBundleUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class AbstractUndoRedoAction extends AbstractViewAction{

    private PropertyChangeListener redoActionPropertyListener = new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            String name = evt.getPropertyName();
            if (name.equals(AbstractAction.NAME)) {
                putValue(AbstractAction.NAME, evt.getNewValue());
            } else if (name.equals("enabled")) {
                updateEnabledState();
            }
        }
    };
    private String ID;
    private ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");

    /**
     * Creates a new instance.
     *
     * @param app
     */
    public AbstractUndoRedoAction(Application app, String id) {
        super(app);
        this.ID = id;
        labels.configureAction(this, ID);
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
        assert p != null: "The view is null";
        super.installViewListeners(p);
        if (p.getAction(ID) != null) {
            p.getAction(ID).addPropertyChangeListener(redoActionPropertyListener);
        }
    }
    /**
     * Installs listeners on the view object.
     */
    @Override protected void uninstallViewListeners(View p) {
        assert p != null: "The view is null";
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
}
