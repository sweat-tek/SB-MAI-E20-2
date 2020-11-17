package acceptanceTestLinkPalette;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 * @author Aleksander G. Duszkiewicz
 * @version 1.0 2020-11-17 Created.
 */
public class AcceptanceTestLinkPalette extends ScenarioTest<PressedAndSelectedFigure, InputLinkAndTargetText, LinkAddedToFigure> {

    @Test
    public void linkAddedToFigure() {
        given().figureSelected();
        when().hasInputLinkAndTargetText();
        then().linkAddedToFigure();
    }
}
