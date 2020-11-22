/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.geom;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

/**
 *
 * @author morte
 */
public class GivenCoordinates extends Stage<GivenCoordinates> {

    @ProvidedScenarioState
    double x1;
    @ProvidedScenarioState
    double y1;
    @ProvidedScenarioState
    double x2;
    @ProvidedScenarioState
    double y2;
    
    public GivenCoordinates the_first_x_coordinate(){
        x1 = 5.0f;
        return this;
    }
    public GivenCoordinates the_first_y_coordinate(){
        y1 = 3.0f;
        return this;
    }
    public GivenCoordinates the_second_x_coordinate(){
        x2 = 8.0f;
        return this;
    }
    public GivenCoordinates the_second_y_coordinate(){
        y2 = 10.0f;
        return this;
    }
}
