package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;

import javax.naming.SizeLimitExceededException;
import java.util.Objects;

public class ExtendedDescription implements ValueObject {

    private String extendedDescription;

    public ExtendedDescription(String extendedDescription) throws SizeLimitExceededException {
        checkExtendedDescription(extendedDescription);
        this.extendedDescription = extendedDescription;
    }

    protected ExtendedDescription(){

    }

    /**
     * Check the extended description business rules
     * @param extendedDiscription Product's extended description
     * @throws SizeLimitExceededException if rules are broken
     */
    private void checkExtendedDescription(String extendedDiscription) throws SizeLimitExceededException {
        if(extendedDiscription.length()>100 || extendedDiscription.length()<20){
            throw new SizeLimitExceededException();
        }
    }

    public String description(){
        return extendedDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtendedDescription that = (ExtendedDescription) o;
        return Objects.equals(extendedDescription, that.extendedDescription);
    }

}
