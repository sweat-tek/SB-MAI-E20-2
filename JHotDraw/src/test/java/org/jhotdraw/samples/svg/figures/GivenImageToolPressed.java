package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.samples.svg.SVGCreateFromFileTool;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;


public class GivenImageToolPressed extends Stage<GivenImageToolPressed> {

    @ProvidedScenarioState
    SVGImageFigure svgImageFigure;
    @ProvidedScenarioState
    SVGCreateFromFileTool createFromFileTool;
    @ProvidedScenarioState
    File file = new File("src/test/java/org/jhotdraw/samples/svg/figures/test_image.jpg");
    @ProvidedScenarioState
    DrawingEditor editor;

    public void mockitoSetup() {
        System.out.println(file.getAbsolutePath());
        createFromFileTool = Mockito.mock(SVGCreateFromFileTool.class);
        editor = Mockito.mock(DefaultDrawingEditor.class);
        Mockito.doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                System.out.println("called with arguments: " + Arrays.toString(args));
                svgImageFigure = new SVGImageFigure();
                return null;
            }
        }).when(createFromFileTool).activate(editor);
    }

    public GivenImageToolPressed imageToolPressed() {
        mockitoSetup();

        assertNotNull(createFromFileTool);
        assertNotNull(editor);

        createFromFileTool.activate(editor);
        return this;
    }
}
