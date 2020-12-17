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

/**
 *
 * @author Jonas
 */
class WhenGrouping extends Stage<WhenGrouping> {
    @ProvidedScenarioState
    private DrawingEditor editor;

    public WhenGrouping grouping() {
        GroupAction instance = new GroupAction(editor);
        instance.actionPerformed(null);
        return this;
    }
}
