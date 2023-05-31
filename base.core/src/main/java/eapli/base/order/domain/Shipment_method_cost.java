package eapli.base.order.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Shipment_method_cost implements ValueObject {

    private String shipment_method;
    private double weight;
    private double volume;
    private double cost;

    public Shipment_method_cost(String shipment_method, double weight, double volume) {
        this.shipment_method = shipment_method;
        this.weight = weight;
        this.volume = volume;
        this.cost = calculateCost();
    }

    private double calculateCost() {
        double taxapeso = 0.10;
        double taxavolume = 0.20;
        return weight*taxapeso + volume * taxavolume;
    }

    protected Shipment_method_cost() {
    }

    public String shipment_method() {
        return shipment_method;
    }

    public double weight() {
        return weight;
    }

    public double volume() {
        return volume;
    }

    public double cost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment_method_cost that = (Shipment_method_cost) o;
        return Double.compare(that.weight, weight) == 0 && Double.compare(that.volume, volume) == 0
                && Double.compare(that.cost, cost) == 0 && shipment_method.equals( that.shipment_method);
    }

}
