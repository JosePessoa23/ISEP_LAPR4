package eapli.base.product.persistance;

import eapli.base.product.domain.ProductCategory;
import eapli.framework.domain.repositories.DomainRepository;

public interface ProductCategoryRepository extends DomainRepository<Long, ProductCategory> {
    /**
     * Return all product's categories
     * @return all product's categories
     */
    Iterable<ProductCategory> findAllProductCategories();
}
