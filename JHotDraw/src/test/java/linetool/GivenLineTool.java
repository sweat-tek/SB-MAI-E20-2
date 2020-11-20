package linetool;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.geom.BezierPath;
import org.jhotdraw.geom.DoubleStroke;
import org.jhotdraw.samples.svg.figures.SVGBezierFigure;
import org.jhotdraw.samples.svg.figures.SVGPathFigure;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GivenLineTool extends Stage<GivenLineTool> {


    @ProvidedScenarioState
    SVGPathFigure svgPathFigure;

    @ProvidedScenarioState
    Color color;

    @ProvidedScenarioState
    Graphics2D graphics2D;

    @ProvidedScenarioState
    BufferedImage image;

    @ProvidedScenarioState
    BezierPath path;


    public GivenLineTool anImage(){
        image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        return self();
    }

    public GivenLineTool anImageManipulator(){
        graphics2D = image.createGraphics();
        return self();
    }

    public GivenLineTool aColor(){
        color = Color.CYAN;
        return self();
    }

    public GivenLineTool aPath(){
        path = new BezierPath();
        path.addPoint(2, 2);
        path.addPoint(10, 10);
        return self();
    }

    public GivenLineTool anSvgPathFigure(){
        svgPathFigure = new SVGPathFigure();
        return self();
    }

}
