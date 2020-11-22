/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui;

/**
 *
 * @author mathi
 */
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.util.Random;
import javax.swing.JComponent;

public class WhenStateIsChanged extends Stage<WhenStateIsChanged> {
    
    @ExpectedScenarioState
    FigureToolBar instance;
    
    @ProvidedScenarioState
    JComponent component;
    
    @ProvidedScenarioState
    int state;
    
    public WhenStateIsChanged changingStateToRandomState() {
        Random random = new Random();
        state = random.nextInt(2) + 1;
        component = instance.createDisclosedComponent(state);
        return self();
    }

}
