package eapli.base.order.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {


    @Test
    public void testToString() {
        String expected = "Customer address{address='Rua 10 n43 4567-789'}";
        Address result = new Address("Rua 10 n43 4567-789");
        Assert.assertEquals(expected, result.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddressVerificationEmpty() {
        Address result = new Address("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddressVerificationTooBig() {
        Address result = new Address("Rua 10 n43 4567-789bruyeruneriuvnuerihuirehuirehgiuerhgiuhriuguierhgiuerhgheriughuerghiuerhguiergmiruwnwbiurbiutinrwwnrwbiurbiunr");
    }

    @Test
    public void testEquals() {
        Address address = new Address("Rua 10 n43 4567-789");
        Payment_Confirmation payment_confirmation = new Payment_Confirmation("Rua 10 n43 4567-789");
        Assert.assertEquals(address.equals(payment_confirmation),false);
    }
}