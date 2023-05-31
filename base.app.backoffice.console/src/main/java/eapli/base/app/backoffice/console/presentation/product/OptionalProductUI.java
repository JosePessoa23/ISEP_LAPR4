package eapli.base.app.backoffice.console.presentation.product;

import eapli.base.product.application.CreateProductController;
import eapli.base.product.domain.Product;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class OptionalProductUI extends AbstractUI {

    private final CreateProductController controller = new CreateProductController();
    @Override
    protected boolean doShow() {
        System.out.println("\nProducts:\n");
        List<Product> products = controller.getProducts();
        for(Product p : products){
            System.out.printf("%d -> Code-> %s  |  Short description -> %s\n",products.indexOf(p)+1, p.getCode().code(), p.getShortDescription().description());
        }
        final int optn = Console.readInteger("\nSelect a product");

        int optn1;

        do{
            optn1 = Console.readInteger("\nSelect an option:\n1 -> Insert a technical description\n0 -> Exit\n");
            switch (optn1){
                case(1):
                    final String extendDescription = Console.readLine("Technical Description:");
                    controller.setTechnicalDescription(products.get(optn-1), extendDescription);
                    break;
                case(0):
                    break;
                default:
                    System.out.println("\nInvalid option\n");
            }
        }while(optn1 != 0);
        return false;
    }

    @Override
    public String headline() {
        return null;
    }
}
