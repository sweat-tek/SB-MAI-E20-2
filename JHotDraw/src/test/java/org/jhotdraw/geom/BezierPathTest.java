/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.geom;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
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
public class BezierPathTest {
    
    @Test
    public void BezierPathCreationTest(){
        BezierPath bzPath = new BezierPath();
        int originalLength = bzPath.size();
        bzPath.addPoint(1.0f, 1.0f);
        int newLength = bzPath.size();
        System.out.println(originalLength +", "+ newLength);
        assertNotEquals(originalLength, newLength);
    }
    
}
