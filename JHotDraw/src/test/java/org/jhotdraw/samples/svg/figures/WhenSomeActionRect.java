package org.jhotdraw.samples.svg.figures;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.FigureEvent;
import org.mockito.Mockito;

/**
 *
 * @author Daniel
 */
public class WhenSomeActionRect extends Stage<WhenSomeActionRect> {

    @ExpectedScenarioState
    protected SVGRectFigure rect;

    private KeyEvent key;
    private MouseEvent mouse;
    private DrawingView view;
    private Point2D.Double point;

    @BeforeStage
    private void setup() {

        //Mocks
        point = new Point2D.Double(15, 15);

        //Mouse Setup
        mouse = Mockito.mock(MouseEvent.class);
        Mockito.when(mouse.getClickCount()).thenReturn(1);
        Mockito.when(mouse.getPoint()).thenReturn(new Point(15, 15));

        //Keyboard Setup
        key = Mockito.mock(KeyEvent.class);
        Mockito.when(key.getKeyCode()).thenReturn((Integer) 39);

        //View Setup
        view = Mockito.mock(DrawingView.class);


    }

    public WhenSomeActionRect selectRectangle() {

        
        
        return self();
    }

    
    
    public WhenSomeActionRect pressArrowKeys() {
      
        return self();
    }
}
