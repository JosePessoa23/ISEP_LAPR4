package eapli.base.app.backoffice.console.presentation.survey;

import eapli.base.app.backoffice.console.presentation.order.RegisterProduct_OrderUI;
import eapli.framework.actions.Action;

public class RegisterSurveyAction implements Action {

    @Override
    public boolean execute() {
        return new RegisterSurveyUI().doShow();
    }
}
