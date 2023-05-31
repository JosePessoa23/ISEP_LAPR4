package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class CategoryCode implements ValueObject {

    /**
     * The code
     */
    private String categoryCode;

    /**
     * Creates an instance of Code
     * @param categoryCode the code
     */
    public CategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * Creates an instance of Code
     */
    protected CategoryCode() {

    }

    /**
     * Return the category code
     * @return
     */
    public String code(){
        return categoryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryCode that = (CategoryCode) o;
        return Objects.equals(categoryCode, that.categoryCode);
    }

}
