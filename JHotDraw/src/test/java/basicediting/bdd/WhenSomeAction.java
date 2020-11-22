package basicediting.bdd;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.assertj.swing.core.Robot;

import static java.awt.event.KeyEvent.VK_DELETE;

public class WhenSomeAction extends Stage<WhenSomeAction> {

    @ProvidedScenarioState
    Robot robot;

    public WhenSomeAction pressing_the_delete_key()
    {
        robot.pressAndReleaseKey(VK_DELETE);

        return self();
    }
}