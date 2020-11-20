package JgivenTests;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.Figure;

import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.mock;

public class GivenSomeFigures extends Stage<GivenSomeFigures> {

    @ProvidedScenarioState
    ArrayList<Figure> figures = new ArrayList<>();

    @ProvidedScenarioState
    HashMap<String,Figure> figureMap = new HashMap<>();




    public GivenSomeFigures the_figure(String figureName){
        Figure figure = mock(Figure.class);
        figures.add(figure);
        figureMap.put(figureName,figure);
        return self();
    }

}