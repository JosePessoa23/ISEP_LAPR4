package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;

import javax.naming.SizeLimitExceededException;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Reference implements ValueObject {

    /**
     * The reference
     */
    private String reference;

    /**
     * Creates an instance of Reference
     * @param reference the reference
     */
    public Reference(String reference) throws SizeLimitExceededException {
        checkReference(reference);
        this.reference = reference;
    }


    /**
     * Check the reference business rules
     * @param reference Product's reference
     * @throws SizeLimitExceededException if rules are broken
     */
    private void checkReference(String reference) throws SizeLimitExceededException {
        if(reference.length()>50 || reference.isBlank() || reference.isEmpty()){
            throw new SizeLimitExceededException();
        }
    }

    /**
     * Creates an instance of Reference
     */
    protected Reference() {

    }

    /**
     * Return the reference
     * @return the reference
     */
    public String reference() {
        return reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reference reference1 = (Reference) o;
        return Objects.equals(reference, reference1.reference);
    }

}
