package eapli.base.app.backoffice.console.presentation.order;

import eapli.framework.actions.Action;

public class RegisterProduct_OrderAction implements Action {

    @Override
    public boolean execute() {
        return new RegisterProduct_OrderUI().show();
    }
}
