package eapli.base.app.backoffice.console.presentation.product;

import eapli.base.product.application.ProductCatalogController;
import eapli.base.product.domain.Product;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ViewCatalogUI extends AbstractUI {

    private final ProductCatalogController controller = new ProductCatalogController();
    @Override
    protected boolean doShow() {
        String[] filters = {null, null, null};
        boolean filterFlag = false;
        System.out.println("\nOrdering methods:\n1 -> Code\n2 -> Price\n3 -> Brand\n4 -> Category\n");
        int optn = Console.readInteger("Select one option");
        int filterOptn;
        do{
            System.out.println("\nFilters:\n1 -> Category\n2 -> Description\n3 -> Brand\n0 -> None");
            filterOptn = Console.readInteger("Select one option");
            if(filterOptn == 1){
                filters[0] = Console.readLine("Category filter:");
                filterFlag = true;
            }else if(filterOptn == 2){
                filters[1] = Console.readLine("Description filter:");
                filterFlag = true;
            }else if(filterOptn == 3){
                filters[2] = Console.readLine("Brand filter:");
                filterFlag = true;
            }
        }while(filterOptn != 0);

        List<Product> catalog;

        if(filterFlag){
            catalog = controller.getCatalogFilter(filters, optn);
        }else {
            catalog = controller.getCatalogNoFilter(optn);
        }
        for(Product p : catalog){
            System.out.printf("\nProduct Code -> %s\n  Short description -> %s\n  Brand -> %s\n  Category Code -> %s\n  Price -> %.2f", p.getCode().code(), p.getShortDescription().description(), p.getBrand().brand(), p.getCategory().getCategoryCode().code(), p.getPriceWithTaxes().price());
        }
        return false;
    }

    @Override
    public String headline() {
        return null;
    }
}
