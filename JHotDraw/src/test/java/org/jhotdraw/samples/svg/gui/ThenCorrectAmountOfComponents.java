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
import javax.swing.JComponent;
import static org.junit.Assert.assertEquals;

public class ThenCorrectAmountOfComponents extends Stage<ThenCorrectAmountOfComponents> {
    
    @ExpectedScenarioState
    JComponent component;
    
    @ExpectedScenarioState
    int state;
    
    int expectedResult;
    
    public ThenCorrectAmountOfComponents correctAmountOfComponentsCreated() {
        if(state == 1){
            expectedResult = 1;
        }
        if(state == 2){
            expectedResult = 2;
        }
        assertEquals(expectedResult, component.getComponents().length);
        
        return self();
    }
}
