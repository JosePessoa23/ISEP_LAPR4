package eapli.base.agv.domain;

import eapli.framework.domain.model.ValueObject;

import javax.naming.SizeLimitExceededException;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Identification implements ValueObject {
    /**
     * The AGV id
     */
    private String identification;

    /**
     * Creates an instance of the AGV Maximum Volume
     */
    protected Identification() {
    }

    /**
     * Creates an instance of the AGV id
     * @param identification AGV id
     */
    public Identification(String identification) throws SizeLimitExceededException {
        checkid(identification);
        this.identification = identification;
    }

    /**
     * Checks the id's business rules
     * @param id The AGV ID
     * @throws SizeLimitExceededException
     */
    private void checkid(String id) throws SizeLimitExceededException {
        if(id.length()>8){
            throw new SizeLimitExceededException();
        }
    }

    /**
     * Gets the AGV id
     * @return the AGV id
     */
    public String id() {
        return identification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identification that = (Identification) o;
        return Objects.equals(identification, that.identification);
    }

}
