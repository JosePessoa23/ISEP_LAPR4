package eapli.base.agv.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class MaximumVolume implements ValueObject {
    /**
     * The AGV Maximum Volume
     */
    private double maximumVolume;

    /**
     * Creates an instance of the AGV Maximum Volume
     */
    protected MaximumVolume() {
    }

    /**
     * Creates an instance of the AGV Maximum Volume
     * @param maximumVolume AGV Maximum Volume
     */
    public MaximumVolume(int maximumVolume) {
        checkMaximumVolume(maximumVolume);
        this.maximumVolume = maximumVolume;
    }

    /**
     * Checks AGV the Maximum Volume business rules
     * @param maximumVolume AGV Maximum Volume
     */
    public void checkMaximumVolume(int maximumVolume){
        if (maximumVolume <0){
            throw new IllegalArgumentException("The volume cannot be negative");
        }
    }

    /**
     * Gets the AGV Maximum Volume
     * @return the AGV Maximum Volume
     */
    public double maximumVolume() {
        return maximumVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaximumVolume that = (MaximumVolume) o;
        return maximumVolume == that.maximumVolume;
    }

}
