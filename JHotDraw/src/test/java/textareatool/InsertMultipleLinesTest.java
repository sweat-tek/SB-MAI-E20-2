package textareatool;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class InsertMultipleLinesTest extends ScenarioTest<GivenTextAreaFiguresAreMade, WhenTextHasBeenAdded, ThenTextAreaContainsText> {
    @Test
    public void insertMultipleLines(){
        given()
            .textAreaFiguresMade();
        when()
            .aTextAreaIsWrittenTo();
        then()
            .multipleLinesHaveBeenAdded();

    }


}
