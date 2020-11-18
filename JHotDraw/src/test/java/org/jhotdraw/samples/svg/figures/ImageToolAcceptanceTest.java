package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class ImageToolAcceptanceTest extends ScenarioTest<GivenImageToolPressed, WhenImageAdded, ThenSVGImageFigureIsCreatedWithData> {

    @Test
    public void imageShouldBeAdded() {
        System.out.println("ImageTool acceptance test");

        given().imageToolPressed();
        when().ImageAdded();
        then().figureIsCreatedWithData();
    }

}
