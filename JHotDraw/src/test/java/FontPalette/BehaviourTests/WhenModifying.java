package FontPalette.BehaviourTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.Font;
import static org.jhotdraw.draw.AttributeKeys.FONT_FACE;
import static org.jhotdraw.draw.AttributeKeys.FONT_ITALIC;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

/**
 *
 * @author Sander
 */
public class WhenModifying extends Stage<WhenModifying> {
    
    @ExpectedScenarioState
    private SVGTextFigure textFigure;
    
    WhenModifying modifyingFontSize() {
        textFigure.setFontSize(86);
        return this;
    }
    
    WhenModifying modifyingFontFamily() {
        Font font = new Font("Verdana", Font.PLAIN, 24);
        textFigure.setAttribute(FONT_FACE, font);
        return this;
    }
    
    WhenModifying setFontToItalic() {
        textFigure.setAttribute(FONT_ITALIC, true);
        return this;
    }
}
