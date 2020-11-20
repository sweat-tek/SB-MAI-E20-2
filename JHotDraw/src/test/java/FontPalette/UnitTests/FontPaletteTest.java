package FontPalette.UnitTests;

import java.awt.Font;
import static org.jhotdraw.draw.AttributeKeys.FONT_BOLD;
import static org.jhotdraw.draw.AttributeKeys.FONT_FACE;
import static org.jhotdraw.draw.AttributeKeys.FONT_ITALIC;
import static org.jhotdraw.draw.AttributeKeys.FONT_UNDERLINE;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Sander
 */
public class FontPaletteTest {
    private SVGTextFigure textFigure;
    
    @Before
    public void initialize() {
        textFigure = new SVGTextFigure();
    }
    
    @Test
    public void testFontSizeSelection() {
        textFigure.setFontSize(817);
        assertEquals("failed to set font size", 817, textFigure.getFontSize(), 0);
    }
    
    @Test
    public void testFontStyles() {
        textFigure.setAttribute(FONT_BOLD, true);
        textFigure.setAttribute(FONT_ITALIC, false);
        textFigure.setAttribute(FONT_UNDERLINE, true);
        assertEquals("failed to set font weight", true, textFigure.getAttribute(FONT_BOLD));
        assertEquals("failed to set font italic", false, textFigure.getAttribute(FONT_ITALIC));
        assertEquals("failed to set font underline", true, textFigure.getAttribute(FONT_UNDERLINE));
    }
    
    @Test
    public void testFontFamily() {
        textFigure.setAttribute(FONT_FACE, new Font("Arial", Font.BOLD, 28));
        Font font = textFigure.getAttribute(FONT_FACE);
        assertEquals("failed to set font family", font.getFamily(), "Arial");
        assertEquals("failed to set font style", font.getStyle(), Font.BOLD);
        assertEquals("failed to set font size", font.getSize(), 28);
    }
}
