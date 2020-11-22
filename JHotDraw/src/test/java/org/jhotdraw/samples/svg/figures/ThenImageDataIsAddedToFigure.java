package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.SVGCreateFromFileTool;

import static org.junit.Assert.assertNotNull;

public class ThenImageDataIsAddedToFigure extends Stage<ThenImageDataIsAddedToFigure> {

    @ExpectedScenarioState
    SVGCreateFromFileTool createFromFileTool;

    public ThenImageDataIsAddedToFigure imageDataIsAddedToFigure() {

        // Check that there is now image data on the SVGImageFigure
        assertNotNull(((SVGImageFigure) createFromFileTool.getPrototype()).getImageData());

        return self();
    }

}
