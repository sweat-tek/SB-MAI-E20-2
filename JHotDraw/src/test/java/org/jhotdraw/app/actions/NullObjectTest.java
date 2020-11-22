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
    public void testAction() {
        Action a = new CopyAction();
        Action b = a;

        assertEquals(a, b);
    }

    /**
     * Test of my getComponent method return a NullObject.
     */
    @Test
    public void testComponentANullObject() {
        
        try (MockedStatic mocked = mockStatic(KeyboardFocusManager.class)) {
            
            KeyboardFocusManager keyboardFocusManager = mock(KeyboardFocusManager.class);
            mocked.when(KeyboardFocusManager::getCurrentKeyboardFocusManager).thenReturn(keyboardFocusManager);
            when(keyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner()).thenReturn(defaultDrawingView);
            
//            dv.getDrawing().add(lf);
//            dv.getDrawing().add(bf);

            ActionEvent evt = new ActionEvent(defaultDrawingView, ActionEvent.ACTION_PERFORMED, "edit.selectAll");
            CopyAction copyAction = new CopyAction();
            copyAction.actionPerformed(evt);

//            System.out.println(dv.getSelectedFigures().size());
//            assert dv.getSelectedFigures().size() > 0;
//            assertEquals(2, dv.getSelectionCount());

            Component componentA = copyAction.getComponent();
            Component componentB = KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();

            assertSame(componentA, componentB);
        }   
        
        
//        CopyAction c = new CopyAction();
//        Component componentA = c.getComponent();
//        Component componentB = KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();
//
//        assertNotSame(componentA, componentB);
    }

    /**
     * Test of my getComponent method return a NullObject.
     */
    @Test
    public void testComponentBNormal() {
        
        try (MockedStatic mocked = mockStatic(KeyboardFocusManager.class)) {
            
            KeyboardFocusManager keyboardFocusManager = mock(KeyboardFocusManager.class);
            mocked.when(KeyboardFocusManager::getCurrentKeyboardFocusManager).thenReturn(keyboardFocusManager);
            when(keyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner()).thenReturn(defaultDrawingView);
            
//            dv.getDrawing().add(lf);
//            dv.getDrawing().add(bf);

            ActionEvent evt = new ActionEvent(defaultDrawingView, ActionEvent.ACTION_PERFORMED, "edit.selectAll");
            CopyAction copyAction = new CopyAction();
            copyAction.actionPerformed(evt);

//            System.out.println(dv.getSelectedFigures().size());
//            assert dv.getSelectedFigures().size() > 0;
//            assertEquals(2, dv.getSelectionCount());

            Component componentA = copyAction.getComponent();
            Component componentB = KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();

            assertNotNull(componentB);
        }   
    }

    /**
     * Test of my getComponent method returns a new NullObject.
     */
    @Test
    public void testComponentCNormal() {
        
        try (MockedStatic mocked = mockStatic(KeyboardFocusManager.class)) {
            
            KeyboardFocusManager keyboardFocusManager = mock(KeyboardFocusManager.class);
            mocked.when(KeyboardFocusManager::getCurrentKeyboardFocusManager).thenReturn(keyboardFocusManager);
            when(keyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner()).thenReturn(defaultDrawingView);
            
//            dv.getDrawing().add(lf);
//            dv.getDrawing().add(bf);

            ActionEvent evt = new ActionEvent(defaultDrawingView, ActionEvent.ACTION_PERFORMED, "edit.selectAll");
            CopyAction copyAction = new CopyAction();
            copyAction.actionPerformed(evt);

//            System.out.println(dv.getSelectedFigures().size());
//            assert dv.getSelectedFigures().size() > 0;
//            assertEquals(2, dv.getSelectionCount());

            Component componentA = copyAction.getComponent();
            Component componentB = copyAction.getComponent();

            assertSame(componentA, componentB);
        }   
    }
    
        /**
     * Test of my getComponent method returns a new NullObject.
     */
    @Test
    public void testComponentDNormal() {
        
        try (MockedStatic mocked = mockStatic(KeyboardFocusManager.class)) {
            
            KeyboardFocusManager keyboardFocusManager = mock(KeyboardFocusManager.class);
            mocked.when(KeyboardFocusManager::getCurrentKeyboardFocusManager).thenReturn(keyboardFocusManager);
            when(keyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner()).thenReturn(null);
            
//            dv.getDrawing().add(lf);
//            dv.getDrawing().add(bf);

            ActionEvent evt = new ActionEvent(defaultDrawingView, ActionEvent.ACTION_PERFORMED, "edit.selectAll");
            CopyAction copyAction = new CopyAction();
            copyAction.actionPerformed(evt);

//            System.out.println(dv.getSelectedFigures().size());
//            assert dv.getSelectedFigures().size() > 0;
//            assertEquals(2, dv.getSelectionCount());

            Component componentA = copyAction.getComponent();

            assertTrue(componentA instanceof NullComponent);
        }   
    }

    /**
     * Test of my getComponent method returns a new NullObject.
     */
    @Test
    public void testComponentEAbstractMethod() {
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
    public void testComponentFAbstractMethod() {
        CopyAction c = Mockito.mock(CopyAction.class);
        Mockito.when(c.getComponent()).thenReturn(new NullComponent());
        Component componentA = c.getComponent();

        assertTrue(componentA instanceof NullComponent);
    }
}
