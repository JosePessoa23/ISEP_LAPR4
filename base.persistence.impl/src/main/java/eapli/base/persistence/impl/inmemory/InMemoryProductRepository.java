package eapli.base.persistence.impl.inmemory;

import eapli.base.product.domain.Product;
import eapli.base.product.persistance.ProductRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryProductRepository extends InMemoryDomainRepository<Product, Long> implements ProductRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Product> findAllProducts() {
        return null;
    }

    @Override
    public Iterable<Product> findAllProductsAvailable() {
        return null;
    }

    @Override
    public Product findProductByID(String str) {
        return null;
    }

    @Override
    public Iterable<Product> getCatalogNoFilter(String order) {
        return null;
    }
}
