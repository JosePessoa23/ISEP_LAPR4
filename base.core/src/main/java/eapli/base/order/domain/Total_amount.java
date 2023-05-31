package eapli.base.order.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Total_amount implements ValueObject {

    private double totalAmountWithTaxes;
    private double totalAmountWithoutTaxes;

    public Total_amount(double totalAmountWithTaxes, double totalAmountWithoutTaxes) {
        total_amountVerification(totalAmountWithTaxes,totalAmountWithoutTaxes);
        this.totalAmountWithTaxes = totalAmountWithTaxes;
        this.totalAmountWithoutTaxes = totalAmountWithoutTaxes;
    }

    protected Total_amount() {

    }

    private void total_amountVerification(double totalAmountWithTaxes, double totalAmountWithoutTaxes){
        if (totalAmountWithoutTaxes <0 || totalAmountWithTaxes <0){
            throw new IllegalArgumentException("The price cannot be negative");
        }
    }

    public double totalAmountWithTaxes() {
        return totalAmountWithTaxes;
    }

    public double amountWithTaxes() {
        return totalAmountWithTaxes;
    }

    public double amountWithoutTaxes() {
        return totalAmountWithoutTaxes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Total_amount that = (Total_amount) o;
        return Double.compare(that.totalAmountWithTaxes, totalAmountWithTaxes) == 0 && Double.compare(that.totalAmountWithoutTaxes, totalAmountWithoutTaxes) == 0;
    }

}
