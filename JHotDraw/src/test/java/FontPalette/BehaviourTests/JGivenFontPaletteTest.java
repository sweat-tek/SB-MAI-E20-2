package FontPalette.BehaviourTests;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author Sander
 */
public class JGivenFontPaletteTest extends ScenarioTest<GivenTextToModify, WhenModifying, ThenTextHasChanged> {
    
    @Test
    public void selectingFontSizeResultsInNewFontSize() {
        given().someSelectedText();
        
        when().modifyingFontSize();
        
        then().theFontSizeHasChanged();
    }
}
