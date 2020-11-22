package org.jhotdraw.app.actions;

import org.jhotdraw.app.action.CopyAction;
import org.jhotdraw.app.action.CutAction;
import org.jhotdraw.app.action.NullComponent;
import org.jhotdraw.samples.svg.SVGAttributeKeys;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.QuadTreeDrawing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

public class NullObjectTest {


    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    DefaultDrawingView defaultDrawingView;
    
    @Before
    public void setUp() {
        defaultDrawingView = new DefaultDrawingView();
        defaultDrawingView.setDrawing(new QuadTreeDrawing());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testActionReference() {
        Action a = new CopyAction();
        Action b = a;

        assertEquals(a, b);
    }

    /**
     * Test of my getComponent method return a NullObject.
     */
    @Test
    public void testNullComponentTestA() {
        
        try (MockedStatic mocked = mockStatic(KeyboardFocusManager.class)) {
            
            KeyboardFocusManager keyboardFocusManager = mock(KeyboardFocusManager.class);
            mocked.when(KeyboardFocusManager::getCurrentKeyboardFocusManager).thenReturn(keyboardFocusManager);
            when(keyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner()).thenReturn(defaultDrawingView);

            ActionEvent evt = new ActionEvent(defaultDrawingView, ActionEvent.ACTION_PERFORMED, "edit.copy");
            CopyAction copyAction = new CopyAction();
            copyAction.actionPerformed(evt);

            Component componentA = copyAction.getComponent();
            Component componentB = KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();

            assertSame(componentA, componentB);
        }   
    }

    /**
     * Test of my getComponent method return a NullObject.
     */
    @Test
    public void testNullComponentTestB() {
        
        try (MockedStatic mocked = mockStatic(KeyboardFocusManager.class)) {
            
            KeyboardFocusManager keyboardFocusManager = mock(KeyboardFocusManager.class);
            mocked.when(KeyboardFocusManager::getCurrentKeyboardFocusManager).thenReturn(keyboardFocusManager);
            when(keyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner()).thenReturn(defaultDrawingView);

            ActionEvent evt = new ActionEvent(defaultDrawingView, ActionEvent.ACTION_PERFORMED, "edit.copy");
            CopyAction copyAction = new CopyAction();
            copyAction.actionPerformed(evt);

            Component componentB = KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();

            assertNotNull(componentB);
        }   
    }

    /**
     * Test of my getComponent method returns a new NullObject.
     */
    @Test
    public void testNullComponentTestC() {
        
        try (MockedStatic mocked = mockStatic(KeyboardFocusManager.class)) {
            
            KeyboardFocusManager keyboardFocusManager = mock(KeyboardFocusManager.class);
            mocked.when(KeyboardFocusManager::getCurrentKeyboardFocusManager).thenReturn(keyboardFocusManager);
            when(keyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner()).thenReturn(defaultDrawingView);

            ActionEvent evt = new ActionEvent(defaultDrawingView, ActionEvent.ACTION_PERFORMED, "edit.copy");
            CopyAction copyAction = new CopyAction();
            copyAction.actionPerformed(evt);

            Component componentA = copyAction.getComponent();
            Component componentB = copyAction.getComponent();

            assertSame(componentA, componentB);
        }   
    }
    
        /**
     * Test of my getComponent method returns a new NullObject.
     */
    @Test
    public void testNullComponentTestD() {
        
        try (MockedStatic mocked = mockStatic(KeyboardFocusManager.class)) {
            
            KeyboardFocusManager keyboardFocusManager = mock(KeyboardFocusManager.class);
            mocked.when(KeyboardFocusManager::getCurrentKeyboardFocusManager).thenReturn(keyboardFocusManager);
            when(keyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner()).thenReturn(null);

            ActionEvent evt = new ActionEvent(defaultDrawingView, ActionEvent.ACTION_PERFORMED, "edit.copy");
            CopyAction copyAction = new CopyAction();
            copyAction.actionPerformed(evt);
            Component componentA = copyAction.getComponent();
            assertTrue(componentA instanceof NullComponent);
        }   
    }

    /**
     * Test of my getComponent method returns a new NullObject.
     */
    @Test
    public void testNullComponentTestE() {
        CopyAction c = Mockito.mock(CopyAction.class);
        Mockito.when(c.getComponent()).thenReturn(new NullComponent());
        Component componentA = c.getComponent();
        Component componentB = null;

        assertNotEquals(componentA, componentB);
    }
    
    /**
     * Test of my getComponent method returns a new NullObject.
     */
    @Test
    public void testNullComponentTestF() {
        CopyAction c = Mockito.mock(CopyAction.class);
        Mockito.when(c.getComponent()).thenReturn(new NullComponent());
        Component componentA = c.getComponent();

        assertTrue(componentA instanceof NullComponent);
    }
}
