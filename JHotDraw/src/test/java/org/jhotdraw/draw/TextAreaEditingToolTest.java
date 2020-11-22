package org.jhotdraw.draw;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TextAreaEditingToolTest {
    @Mock
    FloatingTextArea textArea;
    @Mock
    TextHolderFigure typingTarget;
    @Mock
    TextHolderFigure textHolder;
    @Mock
    TextAreaEditingTool textAreaEditingTool;
    @Mock
    AbstractTool abstractTool;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        textAreaEditingTool = new TextAreaEditingTool(typingTarget);

        //Check if all mocks are correctly set up
        Assert.assertNotNull(textArea);
        Assert.assertNotNull(typingTarget);
    }

    @After
    public void tearDown() throws Exception {
        textAreaEditingTool = null;
    }


    @Test
    public void deactivate() {
    }

    @Test
    public void mousePressed() {
    }

    @Test
    public void draw() {
    }

    @Test
    public void beginEdit() {

    }


}