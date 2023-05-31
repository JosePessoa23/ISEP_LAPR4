package eapli.base.app.backoffice.console.presentation.product;

import eapli.base.product.application.CreateProductController;
import eapli.base.product.domain.ProductCategory;
import eapli.base.warehouse.domain.RowPK;
import eapli.base.warehouse.domain.ShelfPK;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.apache.commons.io.FileUtils;


import javax.naming.SizeLimitExceededException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProductUI extends AbstractUI {

    private final CreateProductController productController = new CreateProductController();
    @Override
    protected boolean doShow() {
        final String code = Console.readLine("Code");
        System.out.println("\nCategories:\n");
        List<ProductCategory> categories = productController.getCategories();
        for(ProductCategory pc : productController.getCategories()){
            System.out.println(String.format("%d -> Code: %s  ||  Description -> %s\n", categories.indexOf(pc)+1, pc.getCategoryCode().code(), pc.getCategoryDescription().description()));
        }
        final int optn = Console.readInteger("Select one category:");
        ProductCategory cat = categories.get(optn-1);
        final String brand = Console.readLine("Brand:");
        final double priceWithoutTaxes = Console.readDouble("Price without taxes:");
        final double priceWithTaxes = Console.readDouble("Price with taxes:");
        final String barcode = Console.readLine("Barcode:");
        final String productionCode = Console.readLine("Production code:");
        final String reference = Console.readLine("Reference:");
        final String shortDescription = Console.readLine("Short Description:");
        final String extendedDescription = Console.readLine("Extended Description:");

        String photoPath;
        int photoOPTN;
        do {
            photoPath = Console.readLine("Photo path:");
            File f = new File(photoPath);
            while (!f.exists()) {
                photoPath = Console.readLine("Invalid path\nPlease insert a new one:");
                f = new File(photoPath);
            }
            try {
                Runtime rt = Runtime.getRuntime();
                rt.exec(String.format("open %s", photoPath));
            } catch (Exception e) {
                Runtime rt = Runtime.getRuntime();
                try {
                    rt.exec(String.format("explorer %s", photoPath));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
            photoOPTN = Console.readInteger("Confirm Image:\n1 -> Yes\n2 -> No\n");
        }while (photoOPTN !=1);

        String currentDir = System.getProperty("user.dir");
        File image = new File(photoPath);
        try {
            FileUtils.copyFile(new File(photoPath), new File(currentDir + "\\productImages\\Code_" + code + ".png"));
            photoPath = currentDir + "\\productImages\\Code_" + code + ".png";
        } catch (IOException e) {
            e.printStackTrace();
        }



        System.out.println("\nAvailable Locations:\n");
        List<ShelfPK> shelfs = productController.getAvailableShelfs();
        int i=1;
        for(ShelfPK rpk: shelfs){
            System.out.printf("\n%d:\n  WarehouseID -> %s\n  AisleID -> %d\n  RowID -> %d\n  ShelfID -> %d\n",i, rpk.warehouseid(), rpk.aisleid(), rpk.rowid(),rpk.shelfid());
            i++;
        }

        final String warehouseID = Console.readLine("WarehousID:");
        final Long aisleID = Console.readLong("AisleID:");
        final Long rowID = Console.readLong("RowID:");
        final Long shelfID = Console.readLong("ShelfID:");
        final double weight = Console.readDouble("Weight:");
        final double volume = Console.readDouble("Volume:");

        try {
            productController.createProduct(code, cat, brand, priceWithoutTaxes, priceWithTaxes, barcode, productionCode, reference, shortDescription, extendedDescription, photoPath, warehouseID, aisleID, rowID,shelfID, weight, volume);
        }catch (SizeLimitExceededException e){
            System.out.println("\nProducts Rules:\nShort description 30 chars max;\nExtended description min 20 and max 100 chars;\nBrand 50 chars max;\nReference 23 chars max;\nCodes 23 chars max, 2 letters followed by n chars.\n");
        }

        return false;
    }

    @Override
    public String headline() {
        return null;
    }
}
