package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.warehouse.application.AddJsonFileController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class AddJsonFileUI extends AbstractUI {

    private final AddJsonFileController theController = new AddJsonFileController();

    @Override
    protected boolean doShow() {
        final String file = Console.readLine("Name of the file:");
        try {
            theController.addJsonFile(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public String headline() {
        return "Add warehouse plant by uploading a JSON file";
    }
}
