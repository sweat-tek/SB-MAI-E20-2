package JgivenTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenFigureIsSentToBack extends Stage<ThenFigureIsSentToBack> {


    @ExpectedScenarioState
    ArrayList<Figure> figures;
    @ExpectedScenarioState
    QuadTreeDrawing qtd;
    @ExpectedScenarioState
    HashMap<String,Figure>figureMap;

    @ExpectedScenarioState
    String figureName;

    Figure figure;

    public ThenFigureIsSentToBack the_figure(String figureName){
        figure = figureMap.get(figureName);
        return self();
    }
    public ThenFigureIsSentToBack is_sent_to_back(){
        Figure result = qtd.getChildren().get(0);
        assertThat(figure).isEqualTo(result);
        return self();
    }

}