package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;

import javax.naming.SizeLimitExceededException;
import javax.persistence.Embeddable;

@Embeddable
public class Price implements ValueObject {


    /**
     * The price
     */
    private double price;

    /**
     * Create an instance of Price
     * @param price the price
     */
    public Price(double price) throws SizeLimitExceededException {
        checkPrice(price);
        this.price = price;
    }

    private void checkPrice(double price) throws SizeLimitExceededException {
        if(price<=0){
            throw new SizeLimitExceededException();
        }
    }

    /**
     * Create an instance of Price
     */
    protected Price() {

    }

    /**
     * Return the price
     * @return the price
     */
    public double price() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Double.compare(price1.price, price) == 0;
    }

}
