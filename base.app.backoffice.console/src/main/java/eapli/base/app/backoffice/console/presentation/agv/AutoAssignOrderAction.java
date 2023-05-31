package eapli.base.app.backoffice.console.presentation.agv;

import eapli.framework.actions.Action;

public class AutoAssignOrderAction implements Action {
    @Override
    public boolean execute() {
        return new AutoAssignOrderUI().show();
    }
}
