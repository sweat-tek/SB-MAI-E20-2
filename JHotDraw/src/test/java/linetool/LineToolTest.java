package linetool;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class LineToolTest extends ScenarioTest<GivenLineTool, WhenCreatingAndDrawingLine, ThenLineIsDrawn> {
    @Test
    public void TestLineToolLineDrawn(){
        given().anImage()
                .and().anImageManipulator()
                .and().aColor()
                .and().aPath()
                .and().anSvgPathFigure();
        when().settingThePath()
                .and().settingTheColor()
                .and().drawingTheLine();
        then().lineIsDrawnAtCorrectLocation().and().lineIsDrawnWithCorrectColor();
    }
}
