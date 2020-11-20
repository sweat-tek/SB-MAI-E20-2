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

        // Assert not null
        assertNotNull(result);

        // Assert figure size
        System.out.println("Assert figure");
        Rectangle figureExpected = new Rectangle(250, 150, 0, 0);
        Rectangle figureActual = result.getBezierPath().getBounds();

        assertEquals(figureExpected, figureActual);

        // Test size of the attributes, should be 6 where the 2 included are link and target, the 4 others are
        // the color stroke and figure color added when it is selected
        System.out.println("Assert attribute size");
        int attributeSizeExpected = 6;
        int attributeSizeActual = result.getAttributes().size();

        assertEquals(attributeSizeExpected, attributeSizeActual);

        // Test that link is added to the figure
        System.out.println("Assert link added to figure");
        assertEquals(link, result.getAttribute(LINK));

        assertEquals(target, result.getAttribute(LINK_TARGET));

        return self();

    }
}
