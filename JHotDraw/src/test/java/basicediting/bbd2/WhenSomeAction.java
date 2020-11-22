package basicediting.bbd2;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.awt.Component;
import java.awt.event.ActionEvent;
import org.assertj.swing.core.Robot;

import static java.awt.event.KeyEvent.VK_DELETE;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JTextField;
import org.jhotdraw.app.action.CopyAction;
import org.jhotdraw.app.action.DeleteAction;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WhenSomeAction extends Stage<WhenSomeAction> {

    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;
    
    @ExpectedScenarioState
    @ProvidedScenarioState
    private JTextField component;
//    @ProvidedScenarioState
    private Set<Figure> selectedFigures;
    
//    @ProvidedScenarioState
    private Set<Figure> allFigures;
    
    private Figure selected;
    
    private DeleteAction deleteAction;
    
    @BeforeStage
    public void before() {
//        deleteAction = DeleteAction.create(editor, new BezierFigure());

//        selectedFigures = new HashSet<>(editor.getActiveView().getSelectedFigures());        
        selected = editor.getActiveView().getSelectedFigures().iterator().next();
        
               
//        System.out.println("test: " + editor.getActiveView().getDrawing());        
//        System.out.println("test: " + selectedFigures);
//        System.out.println("test: " + selected);

//        allFigures = new HashSet<>(editor.getActiveView().getDrawing().getChildren());

        
    }

    public WhenSomeAction pressing_the_delete_key()
    {
        selected.requestRemove();
        
//        ActionEvent deleteEvent = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "edit.delete");
//        DeleteAction deleteAction = new DeleteAction();
//        deleteAction.actionPerformed(deleteEvent);

        return this;
    }
}