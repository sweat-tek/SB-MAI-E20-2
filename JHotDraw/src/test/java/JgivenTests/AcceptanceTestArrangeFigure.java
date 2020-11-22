package JgivenTests;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class AcceptanceTestArrangeFigure extends ScenarioTest<GivenSomeFigures,WhenArrangingFigure, ThenFigureIsRearanged> {


    @Test
    public void send_to_back_test() {


        given().the_figure("square")
                .and().the_figure("triangle")
                .and().the_figure("circle");


        when().selecting_figure("triangle").and().send_to_back();

        then().the_figure("triangle").is_sent_to_back();
    }

    @Test
    public void bring_to_front_test(){
        given().the_figure("square")
                .and().the_figure("triangle")
                .and().the_figure("circle");


        when().selecting_figure("square").and().bring_to_front();

        then().the_figure("square").is_brought_to_front();
    }

}
