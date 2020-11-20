/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.geom;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author morte
 */
public class Bounds2DCalculatorTest {
    @Test
    public void checkvalues() {
        Bounds2DCalculator b2dcalc = new Bounds2DCalculator();
        b2dcalc.setValues(1.0f, 1.0f, 1.0f, 1.0f);
        assertEquals(1.0f, b2dcalc.getX1(), 0.0001f);
    }
    
    @Test
    public void checkComparison(){
        double x = 5.0f;
        double y = 5.0f;
        Bounds2DCalculator b2dcalc = new Bounds2DCalculator();
        b2dcalc.setValues(1.0f, 1.0f, 1.0f, 1.0f);
        b2dcalc.compareNode(x, y);
        assertNotEquals(1.0f, b2dcalc.getX2(), 0.0001f);
    }
    
}
