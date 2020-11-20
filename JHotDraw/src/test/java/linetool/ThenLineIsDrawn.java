package linetool;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.geom.BezierPath;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ThenLineIsDrawn extends Stage<ThenLineIsDrawn> {
    @ExpectedScenarioState
    BufferedImage image;

    @ExpectedScenarioState
    BezierPath path;

    @ExpectedScenarioState
    Color color;

    public ThenLineIsDrawn lineIsDrawnAtCorrectLocation(){
        double pointOnLineX = path.get(1).x[0];
        double pointOnLineY = path.get(1).y[0];
        int pointNotOnLineX = 50;
        int pointNotOnLineY = 50;
        assertEquals(image.getRGB((int)pointOnLineX, (int) pointOnLineY), color.getRGB());
        assertNotEquals(image.getRGB(pointNotOnLineX, pointNotOnLineY), color.getRGB());
        return self();
    }

    public ThenLineIsDrawn lineIsDrawnWithCorrectColor(){
        double pointOnLineX = path.get(1).x[0];
        double pointOnLineY = path.get(1).y[0];
        assertEquals(image.getRGB((int)pointOnLineX, (int) pointOnLineY), color.getRGB());
        return self();
    }
}
