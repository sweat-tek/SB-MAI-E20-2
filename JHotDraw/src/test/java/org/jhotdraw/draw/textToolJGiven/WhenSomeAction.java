package org.jhotdraw.draw.textToolJGiven;

/**
 *
 * @author Rene_
 */
import com.tngtech.jgiven.Stage;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

public class WhenSomeAction extends Stage<WhenSomeAction> {
    private SVGTextFigure svgTxtFigure; 
    
    public WhenSomeAction userAddsNewLineOfText(String text) {
        svgTxtFigure = new SVGTextFigure();
        svgTxtFigure.setText(text);
        return self();
    }
}