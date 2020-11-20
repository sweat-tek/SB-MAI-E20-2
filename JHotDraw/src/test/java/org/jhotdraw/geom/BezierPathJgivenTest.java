/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.geom;

import org.junit.Test;

import com.tngtech.jgiven.junit.ScenarioTest;


/**
 *
 * @author morte
 */
public class BezierPathJgivenTest extends ScenarioTest<GivenCoordinates, WhenCoordinatesAreConnected, ThenBezierPath> {

    @Test
    public void a_number_of_coordinates_can_be_made_into_a_valid_bezier_path() {
        given().the_first_x_coordinate().
                and().the_first_y_coordinate().
                and().the_second_x_coordinate().
                and().the_second_y_coordinate();
        
        when().the_coordinates_are_connected();
        
        then().the_bezier_curve_has_been_created();
    }
}
