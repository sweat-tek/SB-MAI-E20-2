package textareatool;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;

import java.awt.geom.Point2D;
import java.util.List;


public class WhenTextHasBeenAdded extends Stage<WhenTextHasBeenAdded> {

    @ExpectedScenarioState
    private DrawingEditor editor;
    @ExpectedScenarioState
    private String text;

    public WhenTextHasBeenAdded aTextAreaIsWrittenTo(){
        List<Figure> figures = editor.getActiveView().getDrawing().getChildren();
        for (Figure figure : figures) {
            SVGTextAreaFigure svg = (SVGTextAreaFigure) figure;
            svg.setText(text);
        }
        return this;
    }

}
