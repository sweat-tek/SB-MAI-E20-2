/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action.BehaviorTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.action.GroupAction;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Jonas
 */
class ThenGroup extends Stage<ThenGroup>{

    @ProvidedScenarioState
    private DrawingEditor editor;

    public ThenGroup one_selected_group() {
        assertTrue(editor.getActiveView().getSelectionCount() == 1);
        return this;
    }
    
    public ThenGroup no_selected_group() {
        assertTrue(editor.getActiveView().getSelectionCount() == 0);
        return this;
    }
}

//instance = new GroupAction(editor);
