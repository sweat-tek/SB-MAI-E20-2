package org.jhotdraw.linkPaletteAcceptenceTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.Rectangle;
import org.jhotdraw.draw.BezierFigure;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.LINK;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.LINK_TARGET;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Aleksander G. Duszkiewicz
 * @version 1.0 2020-11-17 Created.
 */
class LinkAddedToFigure extends Stage<LinkAddedToFigure> {

    @ExpectedScenarioState
    String link = "www.google.com";
    @ExpectedScenarioState
    String target = "Google";
    @ExpectedScenarioState
    BezierFigure bezierFigure;

    public LinkAddedToFigure linkAddedToFigure() {
        BezierFigure result = bezierFigure;

        assertNotNull(result);

        // Assert figure size
        System.out.println("Assert figure");
        Rectangle figureExpected = new Rectangle(250, 150, 0, 0);
        Rectangle figureActual = result.getBezierPath().getBounds();

        System.out.println("figureExpected: " + figureExpected);
        System.out.println("figureActual: " + figureActual);
        
        assertEquals(figureExpected, figureActual);

        // Test size of the attributes, should be 6 where the 2 included are link and target, the 4 others are
        // the color stroke and figure color added when they are selected
        System.out.println("Assert attribute size");
        int attributeSizeExpected = 6;
        int attributeSizeActual = result.getAttributes().size();
        
        System.out.println("attributeSizeExpected: " + attributeSizeExpected);
        System.out.println("attributeSizeActual: " + attributeSizeActual);
        
        assertEquals(attributeSizeExpected, attributeSizeActual);

        // Test that link is added to the figure
        System.out.println("Assert link added to figure");
        assertEquals(link, result.getAttribute(LINK));
        System.out.println("linkExpected: " + link);
        System.out.println("linkActual: " + result.getAttribute(LINK));
        
        assertEquals(target, result.getAttribute(LINK_TARGET));
        System.out.println("targetExpected: " + target);
        System.out.println("targetActual: " + result.getAttribute(LINK_TARGET));
        
        return self();

    }
}
