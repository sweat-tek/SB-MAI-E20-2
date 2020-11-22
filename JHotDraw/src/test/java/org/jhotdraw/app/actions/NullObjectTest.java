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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class NullObjectTest {


    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
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
        CopyAction c = new CopyAction();
        Component componentA = c.getComponent();
        Component componentB = KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();

        assertNotSame(componentA, componentB);
    }

    /**
     * Test of my getComponent method return a NullObject.
     */
    @Test
    public void testComponentBNormal() {
        CopyAction c = new CopyAction();
        Component componentB = KeyboardFocusManager.getCurrentKeyboardFocusManager().getPermanentFocusOwner();

        assertNull(componentB);
    }

    /**
     * Test of my getComponent method returns a new NullObject.
     */
    @Test
    public void testComponentCNormal() {
        CopyAction c = new CopyAction();
        Component componentA = c.getComponent();
        Component componentB = c.getComponent();

        assertNotSame(componentA, componentB);
    }

    /**
     * Test of my getComponent method returns a new NullObject.
     */
    @Test
    public void testComponentDAbstractMethod() {
        CopyAction c = Mockito.mock(CopyAction.class);
        Mockito.when(c.getComponent()).thenReturn(new NullComponent());
        Component componentA = c.getComponent();
        Component componentB = null;

        assertNotEquals(componentA, componentB);
    }
}
