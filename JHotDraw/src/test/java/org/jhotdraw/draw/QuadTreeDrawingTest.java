package org.jhotdraw.draw;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class QuadTreeDrawingTest {

    @Mock
    private Figure figure1 = mock(Figure.class);
    private Figure figure2 = mock(Figure.class);
    private Figure figure3 = mock(Figure.class);

    private QuadTreeDrawing qtd = new QuadTreeDrawing();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ArrayList<Figure> children = new ArrayList<>();
        children.add(figure1);
        children.add(figure2);
        children.add(figure3);

        qtd.setChildren(children);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    // Best case test.
    // Tests if the selected figure is sent to the back.
    public void sendToBackTest() {
        qtd.sendToBack(figure3);
        Figure result = qtd.children.get(0);
        assertEquals(figure3, result);

    }

    @Test
    public void bringToFront() {
        qtd.bringToFront(figure1);
        Figure result = qtd.children.get(qtd.children.size()-1);
        assertEquals(figure1, result);
    }
}