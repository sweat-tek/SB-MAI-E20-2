package JgivenTests;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.mockito.Mock;

import java.util.ArrayList;

public class WhenArrangingFigure extends Stage<WhenArrangingFigure> {

    @ProvidedScenarioState
    QuadTreeDrawing qtd;

    @ExpectedScenarioState
    ArrayList<Figure> figures;

    @ExpectedScenarioState
    @Mock
    Figure triangle;

    @ExpectedScenarioState
    @Mock
    Figure circle;

    @ExpectedScenarioState
    @Mock
    Figure square;

    @BeforeStage
    public void before() {
         qtd = new QuadTreeDrawing();
         qtd.setChildren(figures);
    }


    public WhenArrangingFigure selecting_triangle_and_sending_to_back() {
        qtd.sendToBack(triangle);
        return this;
    }
    public WhenArrangingFigure selecting_square_and_sending_to_back() {
        qtd.sendToBack(square);
        return this;
    }
    public WhenArrangingFigure selecting_circle_and_sending_to_back() {
        qtd.sendToBack(circle);
        return this;
    }
}