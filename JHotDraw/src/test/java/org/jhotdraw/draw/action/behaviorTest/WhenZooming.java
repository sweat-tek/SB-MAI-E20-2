/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action.behaviorTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import javax.swing.AbstractButton;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.action.ZoomAction;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Simon Holland Flarup
 */
class WhenZooming extends Stage<WhenZooming>{
    @ProvidedScenarioState
    private DrawingEditor editor;
    
    @ProvidedScenarioState
    private double scaleFactor;
    
    public WhenZooming zooming(double scaleFactor) {
        this.scaleFactor = scaleFactor;
        ZoomAction instance = new ZoomAction(editor.getActiveView(), scaleFactor, mock(AbstractButton.class));
        instance.actionPerformed(null);
        return this;
    }
}
