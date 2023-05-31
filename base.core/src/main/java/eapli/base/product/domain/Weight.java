package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;


import javax.naming.SizeLimitExceededException;
import javax.persistence.Embeddable;


@Embeddable
public class Weight implements ValueObject {

    /**
     * The weight
     */
    private double weight;

    /**
     * Creates an instance of Weight
     * @param weight the weight
     */
    public Weight(double weight) throws SizeLimitExceededException {
        checkWeight(weight);
        this.weight = weight;
    }

    /**
     * Creates an instance of weight
     */
    protected Weight() {

    }

    /**
     * Check if weight is bigger than 0
     */
    private void checkWeight(double weight) throws SizeLimitExceededException {
        if(weight<=0){
            throw new SizeLimitExceededException();
        }
    }

    /**
     * Return the weight
     * @return the weight
     */
    public double weight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight1 = (Weight) o;
        return Double.compare(weight1.weight, weight) == 0;
    }

}
