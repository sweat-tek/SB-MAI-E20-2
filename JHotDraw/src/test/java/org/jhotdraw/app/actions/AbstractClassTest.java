package org.jhotdraw.app.actions;

import org.jhotdraw.app.action.CopyAction;
import org.jhotdraw.util.ResourceBundleUtil;
import org.junit.*;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbstractClassTest {


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
     * Test of my Abstract class constructor.
     */
    @Test
    public void testAction() {
        CopyAction c = new CopyAction();
        String a = c.labels.getString("edit.copy.text");
        String b = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels").getString("edit.copy.text");

        assertEquals(a, b);
    }


}
