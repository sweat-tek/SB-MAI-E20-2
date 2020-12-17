/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui;

import javax.swing.JComponent;
import org.jhotdraw.draw.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mathi
 */
public class FigureToolBarTest {

    public FigureToolBarTest() {
    }

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

    /**
     * Tests of createDisclosedComponent method, of class FigureToolBar. Tests
     * if the method creates the component as it should.
     */
    @Test
    public void testCreateDisclosedComponentState1() {
        //state 1 defines a opacity field
        int state = 1;
        FigureToolBar instance = new FigureToolBar();
        JComponent component = instance.createDisclosedComponent(state);
        assertNotNull(component);
    }

    @Test
    public void testCreateDisclosedComponentState2() {
        //state 2 defines a opacity field with a slider
        int state = 2;
        FigureToolBar instance = new FigureToolBar();
        JComponent component = instance.createDisclosedComponent(state);
        assertNotNull(component);
    }

    @Test
    public void testCreateDisclosedComponentBoundaries() {
        //Tests whether the component is created or not, given different states. Includes boundary cases.
        for (int i = -5; i < 6; i++) {
            if(i<1){
                int state = i;
                FigureToolBar instance = new FigureToolBar();
                JComponent component = instance.createDisclosedComponent(state);
                assertNull(component);
            }
            else if(i>2){
                int state = i;
                FigureToolBar instance = new FigureToolBar();
                JComponent component = instance.createDisclosedComponent(state);
                assertNull(component);
            }
            else{
                int state = i;
                FigureToolBar instance = new FigureToolBar();
                JComponent component = instance.createDisclosedComponent(state);
                assertNotNull(component);
            }
        }
        
    }

    //Components tests
    @Test
    public void testAmountOfComponentsCreatedAtState1() {
        //tests whether the correct amount of components are added to the panel.
        //1 component should be added at state 1, opacitySlider.
        int state = 1;
        int expectedResult = 1;
        FigureToolBar instance = new FigureToolBar();
        JComponent component = instance.createDisclosedComponent(state);
        assertEquals(expectedResult, component.getComponents().length);
    }

    @Test
    public void testAmountOfComponentsCreatedAtState2() {
        //tests whether the correct amount of components are added to the panel.
        //2 components should be added at state 2, opacityfield and opacitySlider.
        int state = 2;
        int expectedResult = 2;
        FigureToolBar instance = new FigureToolBar();
        JComponent component = instance.createDisclosedComponent(state);
        assertEquals(expectedResult, component.getComponents().length);
    }

    /**
     * Test of getID method, of class FigureToolBar.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        FigureToolBar instance = new FigureToolBar();
        String expResult = "figure";
        String result = instance.getID();
        assertEquals(expResult, result);

    }


}
