package eapli.base.order.domain;

import eapli.base.product.domain.Brand;
import org.junit.Assert;
import org.junit.Test;

import javax.naming.SizeLimitExceededException;

import static org.junit.Assert.*;

public class Shipment_method_costTest {

    @Test
    public void checkCalculateCost() {
        double result = 2.0;
        Shipment_method_cost la = new Shipment_method_cost("Paypal",10,5);
        Assert.assertEquals(la.cost(),result,0);
    }

}