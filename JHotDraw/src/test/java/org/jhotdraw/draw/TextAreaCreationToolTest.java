package org.jhotdraw.draw;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.undo.AbstractUndoableEdit;
import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

public class TextAreaCreationToolTest {
    @Mock
    private FloatingTextArea textArea;
    @Mock
    private TextHolderFigure typingTarget;
    @Mock
    private Figure pressedFigure;
    @Mock
    private DrawingView dv;
    @Mock
    private Point2D.Double p;
    @Mock
    private AbstractUndoableEdit abstractUndoableEdit;
    private TextAreaCreationTool textAreaCreationTool;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        textAreaCreationTool = new TextAreaCreationTool(typingTarget);

        //Assert that all mocks used are set up correctly
        Assert.assertNotNull(dv);
        Assert.assertNotNull(p);
        Assert.assertNotNull(typingTarget);
        Assert.assertNotNull(textArea);
        Assert.assertNotNull(textAreaCreationTool);
        Assert.assertNotNull(abstractUndoableEdit);
    }

    @After
    public void tearDown() throws Exception {
        textAreaCreationTool = null;
    }

    @Test
    public void getFigure(){
        textAreaCreationTool = new TextAreaCreationTool(typingTarget);

        Figure f = null;
        Set<Figure> figures = new HashSet<>();
        figures.add(pressedFigure);

        when(dv.getSelectedFigures()).thenReturn(figures);
        for (Figure figure: dv.getSelectedFigures()){
            f = figure;
            when(figure.contains(p)).thenReturn(true);
        }
        Assert.assertEquals(textAreaCreationTool.getFigure(dv, p), f);


    }

    @Test
    public void endTextAreaEdit() {


        when(typingTarget.getText()).thenReturn("TypingTargetText");
        when(textArea.getText()).thenReturn("TextAreaText");
        // TODO Solve how to check if the returned value is correct
        Assert.assertNotNull(textAreaCreationTool.textAreaEndEdit(textArea, typingTarget));
    }

}