package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.samples.svg.SVGCreateFromFileTool;

import static org.junit.Assert.assertNull;

public class WhenImageAdded extends Stage<WhenImageAdded> {

    @ExpectedScenarioState
    SVGCreateFromFileTool createFromFileTool;
    @ExpectedScenarioState
    DrawingEditor editor;

    public WhenImageAdded ImageAdded() {

        // Check that there is no image data
        assertNull(((SVGImageFigure) createFromFileTool.getPrototype()).getImageData());

        createFromFileTool.activate(editor);

        return self();
    }
}
