/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action.BehaviorTest;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author Jonas
 */
public class GroupActionAcceptanceTest extends ScenarioTest<GivenFiguresToGroup, WhenGrouping, ThenGroup>{
    
    @Test
    public void should_group_figures() {
        given().selected_bezier_figures();
        when().grouping();
        then().one_selected_group();
    }
    
    @Test
    public void no_figures_to_group() {
        given().unselected_bezier_figures();
        when().grouping();
        then().no_selected_group();
    }
    
    @Test
    public void should_group_a_group() {
        given().selected_group_figure();
        when().grouping();
        then().one_selected_group();
    }
    
    @Test
    public void should_group_two_groups_figures() {
        given().two_selected_group_figures();
        when().grouping();
        then().one_selected_group();
    }
}
