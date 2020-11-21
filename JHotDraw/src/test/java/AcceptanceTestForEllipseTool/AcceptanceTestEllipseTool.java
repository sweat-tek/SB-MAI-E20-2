package AcceptanceTestForEllipseTool;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


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
    public void drawAEllipseWithDimensions() {
        given().userSpecifiedDimensions();
        when().userDrawsEllipseWithGivenDimensions();
        then().figureHasBeenCreated();
    }
}