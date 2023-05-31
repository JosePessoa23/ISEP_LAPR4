package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;

import javax.naming.SizeLimitExceededException;
import java.util.Objects;

public class ShortDescription implements ValueObject {

    private String shortDescription;

    public ShortDescription(String shortDescription) throws SizeLimitExceededException {
        checkShortDescription(shortDescription);
        this.shortDescription = shortDescription;
    }

    protected ShortDescription(){

    }

    /**
     * Check the short description rules
     * @param shortDescription the short description
     * @throws SizeLimitExceededException if the rules are broken
     */
    private void checkShortDescription(String shortDescription) throws SizeLimitExceededException {
        if(shortDescription.length()>30){
            throw new SizeLimitExceededException();
        }
    }

    public String description(){
        return shortDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortDescription that = (ShortDescription) o;
        return Objects.equals(shortDescription, that.shortDescription);
    }

}
