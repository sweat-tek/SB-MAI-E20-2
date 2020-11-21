package org.jhotdraw.draw;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.event.MouseEvent;

import static org.mockito.Mockito.*;

public class AbstractToolTest {
    @Mock
    TextHolderFigure textHolderFigure;
    @Mock
    FloatingTextArea floatingTextArea;
    @Mock
    TextHolderFigure typingTarget;
    @Mock
    AbstractTool abstractTool;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        abstractTool = new AbstractTool() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("Instantiated");
            }
        };

        //Check if all mocks are correctly set up
        Assert.assertNotNull(floatingTextArea);
        Assert.assertNotNull(typingTarget);
        Assert.assertNotNull(abstractTool);

    }

    @Test
    public void beginEdit() {

    }

    @After
    public void tearDown() throws Exception {
        abstractTool = null;
    }

    @Test
    public void endEdit() {
        when(typingTarget.getText()).thenReturn("TypingTargetText");
        when(floatingTextArea.getText()).thenReturn("FloatingTextAreaText");

        Assert.assertNotNull(abstractTool.textAreaEndEdit(floatingTextArea, typingTarget));
        verify(typingTarget, times(1)).getText();
        verify(floatingTextArea, times(1)).getText();


        Assert.assertNotNull(abstractTool.textAreaEndEdit(floatingTextArea, typingTarget));

    }
}