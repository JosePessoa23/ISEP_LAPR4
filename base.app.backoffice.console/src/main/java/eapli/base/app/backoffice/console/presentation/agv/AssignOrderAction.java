package eapli.base.app.backoffice.console.presentation.agv;

import eapli.framework.actions.Action;

public class AssignOrderAction implements Action {

    @Override
    public boolean execute() {
        return new AssignOrderUI().show();
    }
}
