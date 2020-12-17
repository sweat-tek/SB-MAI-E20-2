
package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author Daniel
 */
public class JGivenRectangleToolTest extends ScenarioTest<GivenSomeStateRect, WhenSomeActionRect, ThenSomeOutcomeRect> {

    @Test
    public void rectangleCreationTest() {

        given().iWantToDrawARectangle();

        when().clickAndDragMouse();

        then().rectangleCreated();
    }
}
