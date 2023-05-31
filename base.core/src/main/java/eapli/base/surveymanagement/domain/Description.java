package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.naming.SizeLimitExceededException;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Objects;

@Embeddable
public class Description implements ValueObject {

    private String description;

    public Description(String description) throws SizeLimitExceededException {
        checkDescription(description);
        this.description = description;
    }

    protected Description() {
    }


    public String description() {
        return description;
    }

    /**
     * Check the description business rules
     * @param description Survey's barcode
     * @throws SizeLimitExceededException if rules are broken
     */
    private void checkDescription(String description) throws SizeLimitExceededException {
        if (description.isEmpty() || description.length() > 40){
            throw new SizeLimitExceededException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(description, that.description);
    }
}
