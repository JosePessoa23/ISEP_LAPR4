package eapli.base.app.backoffice.console.presentation.product;

import eapli.base.product.application.CreateProductCategoryController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import javax.naming.SizeLimitExceededException;

public class PoductCategoryUI extends AbstractUI {

    private final CreateProductCategoryController controller = new CreateProductCategoryController();

    @Override
    protected boolean doShow() {

        final String description = Console.readLine("Description");
        final String code = Console.readLine("Code");

        try {
            controller.createCategory(description, code);
            return true;
        }catch (SizeLimitExceededException e){
            System.out.println("\nInvalid input. The rules are:\nCode 10 char max;\nDescription between 20 and 50 chars.\n");
            return false;
        }

    }

    @Override
    public String headline() {
        return "Specify a new Product Category";
    }
}
