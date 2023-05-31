package eapli.base.persistence.impl.inmemory;

import eapli.base.product.domain.ProductCategory;
import eapli.base.product.persistance.ProductCategoryRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCategoryRepository extends InMemoryDomainRepository<ProductCategory, Long> implements ProductCategoryRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<ProductCategory> findAllProductCategories() {
        return null;
    }
}
