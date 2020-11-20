package TextAreaTool;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.Tool;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;

import java.awt.geom.Point2D;
import java.util.List;


public class WhenATextAreaHasBeenCreated extends Stage<WhenATextAreaHasBeenCreated> {

    @ExpectedScenarioState
    private DrawingEditor editor;
    @ExpectedScenarioState
    private String text;

    public WhenATextAreaHasBeenCreated aTextAreaIsWrittenTo(){
        Point2D.Double p = new Point2D.Double(5, 5);
        List<Figure> figures = editor.getActiveView().getDrawing().getChildren();
        for (Figure figure : figures) {
            SVGTextAreaFigure svg = (SVGTextAreaFigure) figure;
            svg.setText(text);
            figure.getToolTipText(figure.getStartPoint());
            Tool tool = editor.getActiveView().getDrawing().getTool(p);
        }
        return this;
    }

}
