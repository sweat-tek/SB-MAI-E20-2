package JgivenTests;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class AcceptanceTestSendToBack extends ScenarioTest<GivenSomeFigures,WhenArrangingFigure, ThenFigureIsSentToBack> {


    @Test
    public void something_should_happen() {


        given().a_circle()
                .and().a_square()
                .and().a_triangle();


        when().selecting_triangle_and_sending_to_back();

        then().triangleIsSentToBack();
    }

}
