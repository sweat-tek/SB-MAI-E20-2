package org.jhotdraw.linkPaletteAcceptenceTest;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.BezierTool;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.LINK;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.LINK_TARGET;

/**
 * @author Aleksander G. Duszkiewicz
 * @version 1.0 2020-11-17 Created.
 */
class InputLinkAndTargetText extends Stage<InputLinkAndTargetText> {

    @ProvidedScenarioState
    String link = "www.google.com";
    @ProvidedScenarioState
    String target = "Google";
    @ProvidedScenarioState
    BezierFigure bezierFigure;

    @ExpectedScenarioState
    BezierTool bezierTool;
    @ExpectedScenarioState
    DefaultDrawingEditor defaultDrawingEditor;
    @ExpectedScenarioState
    DefaultDrawingView defaultDrawingView;

    public InputLinkAndTargetText inputLinkAndTargetTextAdded() {
        PressedAndSelectedFigure p = new PressedAndSelectedFigure();

        p.figureSelected();
        addLinkToFigure();

        return self();
    }

    public void addLinkToFigure() {
        bezierFigure = (BezierFigure) bezierTool.getCreatedFigure();
        bezierFigure.setAttribute(LINK, link);
        bezierFigure.setAttribute(LINK_TARGET, target);
    }
}
