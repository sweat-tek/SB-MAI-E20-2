package JgivenTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;

public class WhenArrangingFigure extends Stage<WhenArrangingFigure> {

    @ProvidedScenarioState
    QuadTreeDrawing qtd;

    @ExpectedScenarioState
    ArrayList<Figure> figures;

    @ExpectedScenarioState
    HashMap<String, Figure> figureMap;

    @ProvidedScenarioState
    String figureName;

    Figure figure;


    @BeforeStage
    public void before() {
        qtd = new QuadTreeDrawing();
        qtd.setChildren(figures);
    }


    public WhenArrangingFigure selecting_figure(String figureName) {
        assertThat(figureMap).isNotEmpty();
        this.figureName = figureName;
        figure = figureMap.get(figureName);
        return self();
    }

    public WhenArrangingFigure send_to_back() {
        assertThat(qtd).isNotNull();
        qtd.sendToBack(figure);
        return self();
    }

    public WhenArrangingFigure bring_to_front(){
        qtd.bringToFront(figure);
        return self();
    }
}