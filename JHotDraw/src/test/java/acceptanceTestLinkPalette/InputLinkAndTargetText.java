package acceptanceTestLinkPalette;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.BezierTool;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.geom.Bezier;
import org.jhotdraw.gui.FigureAttributeEditorHandler;
import org.jhotdraw.gui.JAttributeTextArea;
import org.jhotdraw.gui.JAttributeTextField;
import org.jhotdraw.samples.svg.SVGAttributeKeys;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.LINK_TARGET;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 *
 * @author alek
 */
class InputLinkAndTargetText extends Stage<InputLinkAndTargetText> {

    @ProvidedScenarioState
    String link = "www.google.com";
    @ProvidedScenarioState
    String target = "Google";
    @ProvidedScenarioState
    Figure bezierFigure;
    
    AttributeKey<String> key;
    FigureAttributeEditorHandler<String> figureAttributeEditorHandlerLink;
    FigureAttributeEditorHandler<String> figureAttributeEditorHandlerTarget;
    JAttributeTextField<String> jattrTextField;
    JAttributeTextArea<String> jattrTextArea;
    boolean updateDrawingEditorDefaults;
    

    @ExpectedScenarioState
    BezierTool bezierTool;
    @ExpectedScenarioState
    DefaultDrawingEditor defaultDrawingEditor;
    

    public InputLinkAndTargetText hasInputLinkAndTargetText() {
        PressedAndSelectedFigure p = new PressedAndSelectedFigure();
        
        Figure bezierFigure = bezierTool.getCreatedFigure();
        SVGAttributeKeys key = new SVGAttributeKeys();
        
        
        return this;
    }
    
    public void setUpMock() {
        figureAttributeEditorHandlerLink = Mockito.mock(FigureAttributeEditorHandler.class);
        figureAttributeEditorHandlerTarget = Mockito.mock(FigureAttributeEditorHandler.class);
        jattrTextField = Mockito.mock(JAttributeTextField.class);
        jattrTextArea = new JAttributeTextArea<>();
        jattrTextField = new JAttributeTextField<>();
        FigureAttributeEditorHandler<String> figureAttributeEditorHandler = new FigureAttributeEditorHandler<>(LINK_TARGET, jattrTextField, defaultDrawingEditor, updateDrawingEditorDefaults);
        
      
        
    }

}
