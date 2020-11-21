package org.jhotdraw.draw.textToolJGiven;

/**
 *
 * @author Rene_
 */
import com.tngtech.jgiven.Stage;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

public class GivenSomeState extends Stage<GivenSomeState> {
    private SVGTextFigure svgTxtFigure; 
    
    public GivenSomeState userWantToEditText(String text) {
        svgTxtFigure = new SVGTextFigure(text);
        return self();
    }
}