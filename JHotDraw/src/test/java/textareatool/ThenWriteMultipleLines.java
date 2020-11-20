package textareatool;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenWriteMultipleLines extends Stage<ThenWriteMultipleLines> {
    @ExpectedScenarioState
    String text;
    @ExpectedScenarioState
    private DrawingEditor editor;

    public ThenWriteMultipleLines multipleLinesHaveBeenAdded(){
        for (Figure figure: editor.getActiveView().getDrawing().getChildren()) {
            assertThat(text.equals(((SVGTextAreaFigure) figure).getText()));
        }
        return this;
    }

}
