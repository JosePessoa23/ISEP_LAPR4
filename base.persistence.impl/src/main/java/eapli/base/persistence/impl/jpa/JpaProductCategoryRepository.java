package eapli.base.persistence.impl.jpa;

import eapli.base.product.domain.ProductCategory;
import eapli.base.product.persistance.ProductCategoryRepository;

import javax.persistence.TypedQuery;

public class JpaProductCategoryRepository extends BasepaRepositoryBase<ProductCategory, Long, Long> implements ProductCategoryRepository{

    JpaProductCategoryRepository() {
        super("eapli.base");
    }

    @Override
    public Iterable<ProductCategory> findAllProductCategories(){
        final TypedQuery<ProductCategory> query = entityManager().createQuery("SELECT d FROM ProductCategory d", ProductCategory.class);
        return query.getResultList();
    }
}
