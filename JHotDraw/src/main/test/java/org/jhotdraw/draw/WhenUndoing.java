package org.jhotdraw.draw;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.DefaultApplicationModel;
import org.jhotdraw.app.DefaultSDIApplication;
import org.jhotdraw.app.action.AbstractViewAction;
import org.jhotdraw.app.action.UndoAction;
import org.jhotdraw.samples.svg.SVGApplicationModel;

import static org.junit.Assert.assertNotNull;

public class WhenUndoing extends Stage<WhenUndoing> {

    @ExpectedScenarioState
    @ProvidedScenarioState
    private Application application;
    private AbstractViewAction undoAction;
    private DefaultApplicationModel model;

    @BeforeStage
    public void before() {
        System.out.println("Setting up when state");
        application = new DefaultSDIApplication();
        undoAction = new UndoAction(application);
        model = new SVGApplicationModel();
        application.setModel(model);
        application.createView().activate();
        assertNotNull(application.getActiveView());
    }

    public WhenUndoing undoingFigure() {
        undoAction.actionPerformed(null);
        return this;
    }
}
