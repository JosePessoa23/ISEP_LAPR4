package eapli.base.product.persistance;

import eapli.base.product.domain.Product;
import eapli.framework.domain.repositories.DomainRepository;

public interface ProductRepository extends DomainRepository<Long, Product> {
    /**
     * Return all products
     * @return all products
     */
    Iterable<Product> findAllProducts();

    /**
     * Return all products available
     * @return all products available
     */
    Iterable<Product> findAllProductsAvailable();

    /**
     * Return the product with the specified id
     * @param str the product's id
     * @return the product
     */
    Product findProductByID(String str);

    /**
     * Return the catalog
     * @param order the catalog options
     * @return the catalog
     */
    Iterable<Product> getCatalogNoFilter(String order);
}
