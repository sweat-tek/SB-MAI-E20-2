/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;
/**
 *
 * @author mathi
 */
public class FigurePaletteBehaviour extends ScenarioTest<GivenFigureToolCreated, WhenStateIsChanged, ThenCorrectAmountOfComponents>{
    
    @Test
    public void ActivatedFigureToolShouldCreateTheCorrectAmountOfComponentsWhenTheStateIsChangedByClickingTool(){
        given().figureToolCreated();    
        when().changingStateToRandomState();
        then().correctAmountOfComponentsCreated();
    }
}
