package org.jhotdraw.samples.svg.gui;

import org.jhotdraw.util.ResourceBundleUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Aleksander G. Duszkiewicz
 * @version 1.0 2020-11-17 Created.
 */

public class LinkToolBarTest {

    LinkToolBar ltb;
    ResourceBundleUtil rbu;

    public LinkToolBarTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ltb = new LinkToolBar();
        rbu = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getLabel method, of class LinkToolBar.
     */
    @Test
    public void testGetLabel() {
        System.out.println("testGetLabel()");
        // ResourceBundle.getBundle("org/jhotdraw/samples/svg/Labels").getString("link.toolbar")
        String expected = rbu.getString("link.toolbar");
        String actual = ltb.getLabel("org.jhotdraw.samples.svg.Labels").getString("link.toolbar");
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(expected, actual);

    }
}