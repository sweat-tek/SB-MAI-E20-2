package AcceptanceTestForEllipseTool;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Aleksander G. Duszkiewicz
 * @version 1.0 2020-11-17 Created.
 */
public class AcceptanceTestEllipseTool extends ScenarioTest<EllipseGiven, EllipseWhen, EllipseThen> {

    public AcceptanceTestEllipseTool() {
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

    @Test
    public void linkAddedToFigure() {
        given().;
        when().inputLinkAndTargetTextAdded();
        then().linkAddedToFigure();
    }
}