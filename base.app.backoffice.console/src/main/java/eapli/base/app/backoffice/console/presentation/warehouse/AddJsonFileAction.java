package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.framework.actions.Action;

public class AddJsonFileAction implements Action {

    @Override
    public boolean execute() {
        return new AddJsonFileUI().show();
    }
}
