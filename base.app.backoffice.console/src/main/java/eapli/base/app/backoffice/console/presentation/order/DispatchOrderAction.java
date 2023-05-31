package eapli.base.app.backoffice.console.presentation.order;

import eapli.framework.actions.Action;

public class DispatchOrderAction implements Action {

    @Override
    public boolean execute() {
        return new DispatchOrderUI().show();
    }
}
