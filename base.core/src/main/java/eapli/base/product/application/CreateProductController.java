package eapli.base.product.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.product.domain.Product;
import eapli.base.product.domain.ProductCategory;
import eapli.base.product.persistance.ProductCategoryRepository;
import eapli.base.product.persistance.ProductRepository;
import eapli.base.warehouse.domain.Shelf;
import eapli.base.warehouse.domain.ShelfPK;
import eapli.base.warehouse.persistence.WarehouseRepository;

import javax.naming.SizeLimitExceededException;
import java.util.List;

public class CreateProductController {

    /**
     * The product repository
     */
    private final ProductRepository productRepository = PersistenceContext.repositories().products();
    /**
     * The category repository
     */
    private final ProductCategoryRepository categoryRepository = PersistenceContext.repositories().productCategories();
    /**
     * The warehouse repository
     */
    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();

    /**
     * Creates a new product and saves it on repository
     * @param code the product's code
     * @param category the product's category
     * @param brand the product's brand
     * @param priceWithoutTaxes the product's price without taxes
     * @param priceWithTaxes the product's price with taxes
     * @param barcode the product's barcode
     * @param productionCode the product's production code
     * @param reference the product's reference
     * @param shorDescription the product's short description
     * @param extendedDescription the product's extended description
     * @param photo the product's photo path
     * @param warehouseID the warehouseID where product is stored
     * @param aisleID the aisleID where product is stored
     * @param rowID the rowID where product is stored
     * @param weight the product's weight
     * @param volume the product's volume
     * @return the new product
     * @throws SizeLimitExceededException if the business rules are broken
     */
    public Product createProduct(String code, ProductCategory category, String brand, double priceWithoutTaxes, double priceWithTaxes, String barcode, String productionCode, String reference, String shorDescription, String extendedDescription, String photo, String warehouseID, Long aisleID, Long rowID,Long shelfID, double weight, double volume) throws SizeLimitExceededException {
        Shelf shelf = getShelfByID(warehouseID, aisleID, rowID,shelfID);
        Product product = new Product(code, category, brand, priceWithoutTaxes, priceWithTaxes, barcode, productionCode, reference, shorDescription, extendedDescription, photo, shelf, true, weight, volume);
        return productRepository.save(product);
    }

    /**
     * Return all product's categories
     * @return all product's categories
     */
    public List<ProductCategory> getCategories(){
        List<ProductCategory> categories = (List<ProductCategory>) categoryRepository.findAllProductCategories();
        return categories;
    }

    /**
     * Return all products
     * @return all products
     */
    public List<Product> getProducts(){
        List<Product> products = (List<Product>) productRepository.findAllProducts();
        return products;
    }

    /**
     * Return available rows
     * @return available rows
     */
    public List<ShelfPK> getAvailableShelfs(){
        List<ShelfPK> shelfPK = (List< ShelfPK>) warehouseRepository.findAvailableShelfPK();
        return shelfPK;
    }

    /**
     * Return the row with the specified id
     * @param warehouseID the warehouseID
     * @param aisleID the aisleID
     * @param rowID the rowID
     * @return the row
     */
    public Shelf getShelfByID(String warehouseID, Long aisleID, Long rowID,Long shelfID){
        return warehouseRepository.getShelfByID(warehouseID,aisleID,rowID,shelfID);
    }

    /**
     * Set the technical description
     * @param p the product to update
     * @param desc the technical description
     */
    public void setTechnicalDescription(Product p, String desc){
        p.setTechnicalDescription(desc);
        productRepository.save(p);
    }

}
