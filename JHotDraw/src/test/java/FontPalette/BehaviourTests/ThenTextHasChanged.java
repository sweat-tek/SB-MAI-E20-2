package FontPalette.BehaviourTests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.Font;
import static org.jhotdraw.draw.AttributeKeys.FONT_FACE;
import static org.jhotdraw.draw.AttributeKeys.FONT_ITALIC;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Sander
 */
public class ThenTextHasChanged extends Stage<ThenTextHasChanged> {
    
    @ExpectedScenarioState
    private SVGTextFigure textFigure;
    
    ThenTextHasChanged theFontSizeHasChanged() {
        assertEquals(86, textFigure.getFontSize(), 0);
        return this;
    }
    
    ThenTextHasChanged theFontFamilyHasChanged() {
        Font font = textFigure.getAttribute(FONT_FACE);
        assertEquals(font.getFamily(), "Verdana");
        assertEquals(font.getStyle(), Font.PLAIN);
        assertEquals(font.getSize(), 24);
        return this;
    }
    
    ThenTextHasChanged theTextIsItalic() {
        boolean isItalic = textFigure.getAttribute(FONT_ITALIC);
        assertEquals(isItalic, true);
        return this;
    }
}
