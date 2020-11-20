package JgivenTests;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class AcceptanceTestSendToBack extends ScenarioTest<GivenSomeFigures,WhenArrangingFigure, ThenFigureIsSentToBack> {


    @Test
    public void something_should_happen() {


        given().the_figure("square")
                .and().the_figure("triangle")
                .and().the_figure("circle");


        when().selecting_figure("triangle").and().send_to_back();

        then().the_figure("triangle").is_sent_to_back();
    }

}
