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

/**
 *
 * @author morte
 */
public class ThenBezierPath extends Stage<ThenBezierPath>{

    @ExpectedScenarioState
    BezierPath bzPath;
    
    public ThenBezierPath the_bezier_curve_has_been_created() {
        assertThat(bzPath.size()).isGreaterThan(1);
        assertThat(bzPath.getBounds2D()).isNotNull();
        
        return this;
    }
}
