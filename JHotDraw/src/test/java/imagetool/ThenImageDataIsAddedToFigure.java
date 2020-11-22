package imagetool;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGImageFigure;

import static org.junit.Assert.assertNotNull;

public class ThenImageDataIsAddedToFigure extends Stage<ThenImageDataIsAddedToFigure> {

    @ExpectedScenarioState
    SVGImageFigure svgImageFigure;

    public ThenImageDataIsAddedToFigure imageDataIsAddedToFigure() {
        assertNotNull(svgImageFigure.getBufferedImage());
        assertNotNull(svgImageFigure.getImageData());
        return self();
    }
}
