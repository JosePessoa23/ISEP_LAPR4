package eapli.base.product.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.product.domain.ProductCategory;
import eapli.base.product.persistance.ProductCategoryRepository;

import javax.naming.SizeLimitExceededException;

public class CreateProductCategoryController {

    /**
     * The category repository
     */
    private final ProductCategoryRepository categoryRepository = PersistenceContext.repositories().productCategories();

    /**
     * Creates a new Category and save it on repository
     * @param description the category's description
     * @param code the category's code
     * @return the product category
     * @throws SizeLimitExceededException if the business rules are broken
     */
    public ProductCategory createCategory(String description, String code) throws SizeLimitExceededException {
        ProductCategory prodCat = new ProductCategory(description, code);
        return categoryRepository.save(prodCat);
    }

}
