package eapli.base.product.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.naming.SizeLimitExceededException;
import javax.persistence.*;

@Entity
public class ProductCategory implements AggregateRoot<Long> {


    /**
     * Category id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * The category's description
     */
    @Embedded
    @Column(name = "Description")
    private CategoryDescription categoryDescription;

    /**
     * The category's code
     */
    @Embedded
    @Column(name = "Code", unique = true)
    private CategoryCode CategoryCode;

    /**
     * Creates an instance of ProductCategory
     */
    protected ProductCategory(){}

    /**
     * Creates an instance of ProductCategory
     * @param categoryDescription the category's description
     * @param CategoryCode the category's code
     * @throws SizeLimitExceededException if the business rules are broken
     */
    public ProductCategory(String categoryDescription, String CategoryCode) throws SizeLimitExceededException {
        checkCode(CategoryCode);
        this.categoryDescription = new CategoryDescription(categoryDescription);
        this.CategoryCode = new CategoryCode(CategoryCode);
    }

    /**
     * Check the code rules
     * @param code the code
     * @throws SizeLimitExceededException if rules are broken
     */
    private void checkCode(String code) throws SizeLimitExceededException {
        if(code == null || code.length()>10){
            throw new SizeLimitExceededException();
        }
    }



    /**
     * Set the new code
     * @param code the new code
     * @throws SizeLimitExceededException if the rules are broken
     */
    public void setCategoryCode(String code) throws SizeLimitExceededException {
        this.CategoryCode = new CategoryCode(code);
    }

    /**
     * Return the description
     * @return the description
     */
    public CategoryDescription getCategoryDescription() {
        return categoryDescription;
    }

    /**
     * Return the code
     * @return the code
     */
    public CategoryCode getCategoryCode() {
        return CategoryCode;
    }

    /**
     * Return the textual information about the category
     * @return the textual information about the category
     */
    @Override
    public String toString() {
        return "ProductCategory{" +
                "description='" + categoryDescription.description() + '\'' +
                ", code='" + CategoryCode.code() + '\'' +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Product)) {
            return false;
        }

        final var that = (ProductCategory) other;
        if (this == that) {
            return true;
        }
        return (this.CategoryCode.equals(that.CategoryCode) && this.categoryDescription.equals(categoryDescription));
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }
}
