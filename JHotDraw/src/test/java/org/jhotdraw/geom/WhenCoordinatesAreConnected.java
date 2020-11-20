/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.geom;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.jhotdraw.geom.BezierPath;
import org.jhotdraw.geom.Bounds2DCalculator;

/**
 *
 * @author morte
 */
public class WhenCoordinatesAreConnected extends Stage<WhenCoordinatesAreConnected>{
    @ExpectedScenarioState
    double x1;
    @ExpectedScenarioState
    double y1;
    @ExpectedScenarioState
    double x2;
    @ExpectedScenarioState
    double y2;
    
    @ProvidedScenarioState
    protected BezierPath bzPath = new BezierPath();
    
    public WhenCoordinatesAreConnected the_coordinates_are_connected(){
        assertThat(bzPath).isNotNull();
        bzPath.addPoint(x1, y1);
        bzPath.addPoint(x2, y2);
        assertThat(bzPath.size()).isEqualTo(2);
        return this;
    }
}
