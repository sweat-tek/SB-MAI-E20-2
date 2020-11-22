package JgivenTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenFigureIsRearanged extends Stage<ThenFigureIsRearanged> {


    @ExpectedScenarioState
    ArrayList<Figure> figures;
    @ExpectedScenarioState
    QuadTreeDrawing qtd;
    @ExpectedScenarioState
    HashMap<String,Figure>figureMap;

    @ExpectedScenarioState
    String figureName;

    Figure figure;

    public ThenFigureIsRearanged the_figure(String figureName){
        figure = figureMap.get(figureName);
        return self();
    }
    public ThenFigureIsRearanged is_sent_to_back(){
        Figure result = qtd.getChildren().get(0);
        assertThat(figure).isEqualTo(result);
        return self();
    }

    public ThenFigureIsRearanged is_brought_to_front(){
        Figure result = qtd.getChildren().get(qtd.getChildCount()-1);
        assertThat(figure).isEqualTo(result);
        return self();
    }

}