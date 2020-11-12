package org.jhotdraw.app.action;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.*;

public class UndoActionTest {

    private UndoAction undoAction;

    @Before
    public void setUp() throws Exception {
        undoAction = new UndoAction(undoAction.getApplication());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void updateView() {
    }

    @Test
    public void actionPerformed() {
    }
}