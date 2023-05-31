package eapli.base.agv.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Autonomy implements ValueObject {
    /**
     * The AGV Autonomy
     */
    private int autonomy;

    /**
     * Creates an instance of Autonomy
     */
    protected Autonomy() {
    }

    /**
     * Creates an instance of Autonomy
     * @param autonomy The AGV Autonomy
     */
    public Autonomy(int autonomy) {
        checkAutonomy(autonomy);
        this.autonomy = autonomy;
    }

    /**
     * Checks AGV Autonomy business rules
     * @param autonomy AGV Autonomy
     */
    public void checkAutonomy(int autonomy){
        if (autonomy <0){
            throw new IllegalArgumentException("The autonomy cannot be negative");
        }
    }

    /**
     * Gets the AGV Autonomy
     * @return the AGV Autonomy
     */
    public int autonomy() {
        return autonomy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autonomy autonomy1 = (Autonomy) o;
        return autonomy == autonomy1.autonomy;
    }

}
