package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;

import javax.naming.SizeLimitExceededException;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Brand implements ValueObject {

    /**
     * The product's brand
     */
    private String brand;

    /**
     * Creates an instance of Brand
     * @param brand
     */
    public Brand(String brand) throws SizeLimitExceededException {
        checkBrand(brand);
        this.brand = brand;
    }

    /**
     * Check the brand business rules
     * @param brand Product's brand
     * @throws SizeLimitExceededException if rules are broken
     */
    private void checkBrand(String brand) throws SizeLimitExceededException {
        if(brand == null || brand.length()>50){
            throw new SizeLimitExceededException();
        }
    }

    /**
     * Crate an instance of Brand
     */
    protected Brand() {

    }

    /**
     * Return the brand
     * @return the brand
     */
    public String brand() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand1 = (Brand) o;
        return Objects.equals(brand, brand1.brand);
    }

}
