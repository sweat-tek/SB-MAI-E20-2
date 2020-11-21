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
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

public class GivenFigureToolCreated extends Stage<GivenFigureToolCreated> {
    
    @ProvidedScenarioState
    FigureToolBar instance;
    
    public GivenFigureToolCreated figureToolCreated() {
        instance = new FigureToolBar();
        return self();
    }
}
