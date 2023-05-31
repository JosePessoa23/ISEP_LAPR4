package eapli.base.product.domain;


import eapli.framework.domain.model.ValueObject;

import javax.naming.SizeLimitExceededException;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Barcode implements ValueObject {

    /**
     * The product's barcode
     */
    private String barcode;

    /**
     * Creates an instance of Barcode
     * @param barcode the barcode
     */
    public Barcode(String barcode) throws SizeLimitExceededException {
        checkBarcode(barcode);
        this.barcode = barcode;
    }

    /**
     * Creates an instance of Barcode
     */
    protected Barcode() {

    }

    /**
     * Check the barcode business rules
     * @param barcode Product's barcode
     * @throws SizeLimitExceededException if rules are broken
     */
    private void checkBarcode(String barcode) throws SizeLimitExceededException {
        if(barcode.length() != 12){
            throw new SizeLimitExceededException();
        }
    }

    /**
     * Return the barcode
     * @return the barcode
     */
    public String barcode() {
        return barcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Barcode barcode1 = (Barcode) o;
        return Objects.equals(barcode, barcode1.barcode);
    }

}
