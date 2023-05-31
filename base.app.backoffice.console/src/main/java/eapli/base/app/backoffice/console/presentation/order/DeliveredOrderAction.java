package eapli.base.app.backoffice.console.presentation.order;

import eapli.framework.actions.Action;

public class DeliveredOrderAction implements Action {

    @Override
    public boolean execute() {
        return new DeliveredOrderUI().show();
    }
}
