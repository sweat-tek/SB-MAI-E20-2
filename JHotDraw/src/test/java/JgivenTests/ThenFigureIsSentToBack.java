package JgivenTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenFigureIsSentToBack extends Stage<ThenFigureIsSentToBack> {

    @ExpectedScenarioState
    Figure triangle;
    @ExpectedScenarioState
    ArrayList<Figure> figures;
    @ExpectedScenarioState
    QuadTreeDrawing qtd;


    public ThenFigureIsSentToBack triangleIsSentToBack() {

        Figure result = qtd.getChildren().get(0);
        assertThat(triangle).isEqualTo(result);
        return self();
    }
}