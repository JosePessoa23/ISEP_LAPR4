package eapli.base.agv.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class MaximumWeight implements ValueObject {
    /**
     * The AGV Maximum Weight
     */
    private double maximumWeight;

    /**
     * Creates an instance of the AGV Maximum Weight
     */
    protected MaximumWeight() {
    }

    /**
     * Creates an instance of the AGV Maximum Weight
     * @param maximumWeight the AGV Maximum Weight
     */
    public MaximumWeight(int maximumWeight) {
        checkMaximumWeight(maximumWeight);
        this.maximumWeight = maximumWeight;
    }

    /**
     * Checks AGV the Maximum Volume business rules
     * @param maximumWeight AGV Maximum Weight
     */
    public void checkMaximumWeight(int maximumWeight){
        if (maximumWeight <0){
            throw new IllegalArgumentException("The weight cannot be negative");
        }
    }

    /**
     * Gets the AGV Maximum Weight
     * @return the AGV Maximum Weight
     */
    public double maximumWeight() {
        return maximumWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaximumWeight that = (MaximumWeight) o;
        return maximumWeight == that.maximumWeight;
    }

}
