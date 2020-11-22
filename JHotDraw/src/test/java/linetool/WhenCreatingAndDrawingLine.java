package linetool;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.geom.BezierPath;
import org.jhotdraw.samples.svg.figures.SVGBezierFigure;
import org.jhotdraw.samples.svg.figures.SVGPathFigure;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WhenCreatingAndDrawingLine extends Stage<WhenCreatingAndDrawingLine> {
    @ExpectedScenarioState
    SVGPathFigure svgPathFigure;

    @ExpectedScenarioState
    Color color;

    @ExpectedScenarioState
    Graphics2D graphics2D;

    @ExpectedScenarioState
    BezierPath path;

    public WhenCreatingAndDrawingLine settingThePath(){
        SVGBezierFigure figure = new SVGBezierFigure();
        figure.setBezierPath(path);
        svgPathFigure.add(0, figure);
        return self();
    }

    public WhenCreatingAndDrawingLine settingTheColor(){
        svgPathFigure.setAttribute(AttributeKeys.STROKE_COLOR, color);
        return self();
    }

    public WhenCreatingAndDrawingLine drawingTheLine(){
        svgPathFigure.draw(graphics2D);
        return self();
    }
}
