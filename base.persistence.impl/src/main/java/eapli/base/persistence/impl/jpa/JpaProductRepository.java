package eapli.base.persistence.impl.jpa;

import eapli.base.product.domain.Product;
import eapli.base.product.persistance.ProductRepository;

import javax.persistence.TypedQuery;

public class JpaProductRepository extends BasepaRepositoryBase<Product, Long, Long> implements ProductRepository {
    public JpaProductRepository() {
        super("eapli.base");
    }

    @Override
    public Iterable<Product> findAllProducts() {
        final TypedQuery<Product> query = entityManager().createQuery("SELECT d FROM Product d", Product.class);
        return query.getResultList();
    }

    @Override
    public Iterable<Product> findAllProductsAvailable() {
        final TypedQuery<Product> query = entityManager().createQuery("SELECT d FROM Product d WHERE d.availability = true", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findProductByID(String str) {
        final TypedQuery<Product> query = entityManager().createQuery("SELECT d FROM Product d WHERE d.code.code = :str ", Product.class);
        query.setParameter("str",str);
        return query.getSingleResult();
    }

    @Override
    public Iterable<Product> getCatalogNoFilter(String order) {
        final TypedQuery<Product> query = entityManager().createQuery(order, Product.class);
        return query.getResultList();
    }


}
