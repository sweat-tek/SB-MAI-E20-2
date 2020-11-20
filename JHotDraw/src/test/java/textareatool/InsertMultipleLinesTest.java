package textareatool;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class InsertMultipleLinesTest extends ScenarioTest<GivenTextAreaFiguresAreMade, WhenATextAreaHasBeenCreated, ThenWriteMultipleLines> {
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
