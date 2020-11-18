package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import static org.junit.Assert.assertNotNull;

public class ThenSVGImageFigureIsCreatedWithData extends Stage<ThenSVGImageFigureIsCreatedWithData> {

    @ExpectedScenarioState
    SVGImageFigure svgImageFigure;

    public ThenSVGImageFigureIsCreatedWithData figureIsCreatedWithData() {

        assertNotNull(svgImageFigure.getBufferedImage());
        assertNotNull(svgImageFigure.getImageData());

        return this;
    }

}
