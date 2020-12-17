/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action.behaviorTest;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author Simon Holland Flarup
 */
public class ZoomActionAcceptance extends ScenarioTest<GivenViewToZoom, WhenZooming, ThenZoom> {
    
    @Test
    public void should_zoom_2() {
        given().view_to_zoom();
        when().zooming(2);
        then().zoom();
    }
    
    @Test
    public void should_zoom_point_5() {
        given().view_to_zoom();
        when().zooming(0.5);
        then().zoom();
    }
}
