/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action.behaviorTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Simon Holland Flarup
 */
class ThenZoom extends Stage<ThenZoom>{
    @ProvidedScenarioState
    private DrawingEditor editor;
    
    @ProvidedScenarioState
    private double scaleFactor;
    
    public ThenZoom zoom() {
        assertTrue(editor.getActiveView().getScaleFactor() == scaleFactor);
        
        return this;
    }
}
