package eapli.base.app.backoffice.console.presentation.survey;

import eapli.framework.actions.Action;

public class ShowReportAction implements Action {

    @Override
    public boolean execute() {
        return new ShowReportUI().doShow();
    }
}
