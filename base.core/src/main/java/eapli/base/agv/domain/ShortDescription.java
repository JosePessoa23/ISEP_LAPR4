package eapli.base.agv.domain;

import eapli.framework.domain.model.ValueObject;

import javax.naming.SizeLimitExceededException;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ShortDescription implements ValueObject {

    /**
     * The AGV Short Description
     */
    private String shortDescription;

    /**
     * Creates an instance of Short Description
     */
    protected ShortDescription() {
    }

    /**
     * Creates an instance of Short Description
     * @param shortDescription The AGV Short Description
     */
    public ShortDescription(String shortDescription) throws SizeLimitExceededException {
        checkShortDescription(shortDescription);
        this.shortDescription = shortDescription;
    }

    /**
     * Checks the Short Description's business rules
     * @param shortDescription The AGV Short Description
     * @throws SizeLimitExceededException
     */
    private void checkShortDescription(String shortDescription) throws SizeLimitExceededException {
        if(shortDescription.length()>30){
            throw new SizeLimitExceededException();
        }
    }

    /**
     * Gets the AGV Short Description
     * @return the AGV Short Description
     */
    public String shortDescription() {
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
