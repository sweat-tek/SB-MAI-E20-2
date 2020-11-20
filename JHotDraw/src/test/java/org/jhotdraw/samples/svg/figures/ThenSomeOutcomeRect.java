package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.Color;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.CreationTool;
import org.jhotdraw.draw.Figure;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author Daniel
 */
public class ThenSomeOutcomeRect extends Stage<ThenSomeOutcomeRect> {

    @ExpectedScenarioState
    protected SVGRectFigure expected;
    private Color defaultColor;

    @ExpectedScenarioState
    protected CreationTool tool;

    @ExpectedScenarioState
    protected Figure provided;

    public ThenSomeOutcomeRect rectangleCreated() {
        assertThat(provided).isNotNull();
        assertThat(expected.getBounds()).isEqualTo(provided.getBounds());

        return self();
    }

    @BeforeStage
    private void setExpected() {
        expected = new SVGRectFigure(5, 5, 14, 19);
        expected.setAttribute(AttributeKeys.STROKE_COLOR, Color.BLACK);
        defaultColor = expected.getAttribute(AttributeKeys.STROKE_COLOR);
    }
}
