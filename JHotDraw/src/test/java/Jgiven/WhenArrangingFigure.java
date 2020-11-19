package Jgiven;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.mockito.Mock;

import java.util.List;

public class WhenArrangingFigure extends Stage<WhenArrangingFigure> {

    @ExpectedScenarioState
    List<Figure> figures;

    @ExpectedScenarioState
    @Mock
    Figure triangle;

    @ExpectedScenarioState
    @Mock
    Figure circle;

    @ExpectedScenarioState
    @Mock
    Figure square;

    @ProvidedScenarioState
    QuadTreeDrawing qtd = new QuadTreeDrawing();

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