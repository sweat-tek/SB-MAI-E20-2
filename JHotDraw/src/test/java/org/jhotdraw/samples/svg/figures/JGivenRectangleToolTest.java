
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author Daniel
 */
public class JGivenRectangleToolTest extends ScenarioTest<GivenSomeStateRect, WhenSomeActionRect, ThenSomeOutcomeRect> {

    @Test
    public void movingRectangleTest() {

        given().some_rectangleFigure();

        when().selectRectangle().and().pressArrowKeys();

        then().rectangleMoved();
    }
}
