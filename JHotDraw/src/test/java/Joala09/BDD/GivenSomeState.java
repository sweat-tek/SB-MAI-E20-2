package Joala09.BDD;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeScenario;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.assertj.swing.fixture.JToggleButtonFixture;
import org.jhotdraw.samples.svg.Main;
import org.jhotdraw.samples.svg.SVGDrawingPanel;

import javax.swing.*;

import static org.assertj.swing.finder.WindowFinder.findFrame;
import static org.assertj.swing.launcher.ApplicationLauncher.application;
import static org.junit.Assert.assertFalse;

public class GivenSomeState extends Stage<GivenSomeState> {

    @ProvidedScenarioState
    FrameFixture frame;

    @ProvidedScenarioState
    JPanelFixture panel;

    @ProvidedScenarioState
    Robot robot;

    @BeforeScenario
    public void startUp() {
        robot = BasicRobot.robotWithNewAwtHierarchy();

        application(Main.class).start();
    }

    public GivenSomeState a_figure_exists() {

        GenericTypeMatcher<JFrame> matcher = new GenericTypeMatcher<JFrame>(JFrame.class) {
            protected boolean isMatching(JFrame frame) {
                return frame.getTitle() != null && frame.getTitle().contains("JHotDraw SVG") && frame.isShowing();
            }
        };
        frame = findFrame(matcher).using(robot);

        JToggleButtonFixture button = frame.toggleButton(new GenericTypeMatcher<JToggleButton>(JToggleButton.class) {
            @Override
            protected boolean isMatching(JToggleButton button) {
                return "Rectangle".equals(button.getToolTipText());
            }
        });
        button.target().doClick();

        panel = frame.panel(new GenericTypeMatcher<SVGDrawingPanel>(SVGDrawingPanel.class) {
            @Override
            protected boolean isMatching(SVGDrawingPanel button) {
                return button instanceof SVGDrawingPanel;
            }
        });

        panel.focus();
        robot.moveMouse(panel.target());
        robot.click(panel.target());

        SVGDrawingPanel drawingPanel = (SVGDrawingPanel) panel.target();
        assertFalse(drawingPanel.getView().getDrawing().getChildren().isEmpty());

        return self();
    }

}
