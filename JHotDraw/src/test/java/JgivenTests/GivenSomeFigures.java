package JgivenTests;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.Figure;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class GivenSomeFigures extends Stage<GivenSomeFigures> {

    @ProvidedScenarioState
    ArrayList<Figure> figures = new ArrayList<>();

    @ProvidedScenarioState
    Figure triangle;
    // brug hashmap?
    @ProvidedScenarioState
    Figure square;

    @ProvidedScenarioState
    Figure circle;

    public GivenSomeFigures a_triangle() {
        triangle = mock(Figure.class);
        figures.add(triangle);
        triangle.
        return self();
    }

    public GivenSomeFigures a_square() {
        square = mock(Figure.class);
        figures.add(square);
        return self();
    }

    public GivenSomeFigures a_circle() {
        circle = mock(Figure.class);
        figures.add(circle);
        return self();
    }
}