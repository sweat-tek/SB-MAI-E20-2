package textareatool;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.figures.SVGTextAreaFigure;


public class GivenTextAreaFiguresAreMade extends Stage<GivenTextAreaFiguresAreMade> {
    TextHolderFigure textHolderFigure;
    TextAreaCreationTool textAreaCreationTool;
    @ProvidedScenarioState
    DrawingView view;

    @ProvidedScenarioState
    protected DrawingEditor editor;
    @ProvidedScenarioState
    private String text = "Setting first line of text in a TextArea \n Setting second line of text in a TextArea \n Setting third line of text in a TextArea";

    @BeforeStage
    private void before(){
        editor = new DefaultDrawingEditor();
        view = new DefaultDrawingView();
        view.setDrawing(new DefaultDrawing());
        editor.setActiveView(view);
    }

    public GivenTextAreaFiguresAreMade textAreaFiguresMade(){
        SVGTextAreaFigure figure1 = new SVGTextAreaFigure();
        SVGTextAreaFigure figure2 = new SVGTextAreaFigure();
        SVGTextAreaFigure figure3 = new SVGTextAreaFigure();

        editor.getActiveView().getDrawing().add(figure1);
        editor.getActiveView().getDrawing().add(figure2);
        editor.getActiveView().getDrawing().add(figure3);

        textAreaCreationTool = new TextAreaCreationTool(textHolderFigure);

        return this;
    }
}





