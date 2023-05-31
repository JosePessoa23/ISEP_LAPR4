package eapli.base.customer.domain;

import org.junit.Assert;
import org.junit.Test;


public class AddressTest {

    @Test
    public void testToString() {
        String expected = "Customer address{address='Rua 10 n43 4567-789'}";
        Address result = new Address("Rua 10 n43 4567-789");
        Assert.assertEquals(expected, result.toString());
    }

    @Test
    public void getAddress() {
        Address expected = new Address("Rua 10 n43 4567-789");
        Address result = new Address(expected.address());
        Assert.assertEquals(expected.toString(),result.toString());
    }
}