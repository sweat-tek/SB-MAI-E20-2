package imagetool;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGImageFigure;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNull;

public class WhenImageAdded extends Stage<WhenImageAdded> {
    @ExpectedScenarioState
    SVGImageFigure svgImageFigure;
    @ExpectedScenarioState
    File file;

    public WhenImageAdded ImageAdded() {
        assertNull(svgImageFigure.getImageData());
        assertNull(svgImageFigure.getBufferedImage());
        try {
            svgImageFigure.loadImage(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return self();
    }
}
