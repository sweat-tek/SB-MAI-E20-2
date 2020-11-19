package Jgiven;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.Figure;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class GivenSomeFigures extends Stage<GivenSomeFigures> {

    @ProvidedScenarioState
    List<Figure> figures = new ArrayList<>();

    @ProvidedScenarioState
    @Mock
    Figure triangle;

    @ProvidedScenarioState
    @Mock
    Figure square;

    @ProvidedScenarioState
    @Mock
    Figure circle;

    public GivenSomeFigures a_triangle() {
        triangle = mock(Figure.class);
        figures.add(triangle);
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