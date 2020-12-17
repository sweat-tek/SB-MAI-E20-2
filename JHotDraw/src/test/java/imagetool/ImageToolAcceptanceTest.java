package imagetool;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class ImageToolAcceptanceTest extends ScenarioTest<GivenImageToolPressed, WhenImageAdded, ThenImageDataIsAddedToFigure> {

    @Test
    public void imageShouldBeAdded() {
        System.out.println("ImageTool acceptance test");
        
        given().imageToolPressed();
        when().ImageAdded();
        then().imageDataIsAddedToFigure();

    }

}
