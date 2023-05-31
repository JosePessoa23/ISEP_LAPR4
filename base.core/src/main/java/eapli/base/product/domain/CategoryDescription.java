package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;

import javax.naming.SizeLimitExceededException;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class CategoryDescription implements ValueObject {

    /**
     * The category description
     */
    private String categoryDescription;

    /**
     * Creates an instance of Description
     * @param categoryDescription the description
     */
    public CategoryDescription(String categoryDescription) throws SizeLimitExceededException {
        checkDescription(categoryDescription);
        this.categoryDescription = categoryDescription;
    }

    /**
     * Check the description rules
     * @param description the description
     * @throws SizeLimitExceededException if rules are broken
     */
    private void checkDescription(String description) throws SizeLimitExceededException {
        if(description == null || description.length()<20  || description.length()>50){
            throw new SizeLimitExceededException();
        }
    }

    /**
     * Creates an instance of Description
     */
    protected CategoryDescription() {

    }

    /**
     * Return the category description
     * @return the category description
     */
    public String description(){
        return categoryDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDescription that = (CategoryDescription) o;
        return Objects.equals(categoryDescription, that.categoryDescription);
    }

}
