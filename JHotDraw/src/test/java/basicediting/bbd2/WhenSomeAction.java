package basicediting.bbd2;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import java.util.Set;
import javax.swing.JTextField;
import org.jhotdraw.app.action.DeleteAction;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;

public class WhenSomeAction extends Stage<WhenSomeAction> {

    @ExpectedScenarioState
    @ProvidedScenarioState
    private DrawingEditor editor;
    
    private Figure selected;
    
//    private ActionEvent deleteEvent;
//    private DeleteAction deleteAction;

    
    @BeforeStage
    public void before() {    
        selected = editor.getActiveView().getSelectedFigures().iterator().next();
    }

    public WhenSomeAction pressing_the_delete_key()
    {
        selected.requestRemove();
        
//        deleteEvent = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "edit.delete");
//        deleteAction = new DeleteAction();
//        deleteAction.actionPerformed(deleteEvent);

        return this;
    }
}