//package eapli.base.customer.domain;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CustomerTest {
//
//
//    @Test
//    public void testGetBillingAddress() {
//        List<String> billingAddress=new ArrayList<>();
//        billingAddress.add("Rua 1 n4 4567-789");
//        List<String> deliveringAddress=new ArrayList<>();
//        deliveringAddress.add("Rua 3 n78 4523-439");
//        Customer customer = new Customer("Joana", "PT123456789","joana@email.com","+351916245321","female","24/09/2000",billingAddress,deliveringAddress);
//        List<Address> expected = new ArrayList<>();
//        expected.add(new Address("Rua 1 n4 4567-789"));
//        List<Address> result = customer.getBillingAddress();
//        Assert.assertEquals(expected.get(0).toString(),result.get(0).toString());
//    }
//
//    @Test
//    public void testGetDeliveringAddress() {
//        List<String> billingAddress=new ArrayList<>();
//        billingAddress.add("Rua 1 n4 4567-789");
//        List<String> deliveringAddress=new ArrayList<>();
//        deliveringAddress.add("Rua 3 n78 4523-439");
//        Customer customer = new Customer("Joana", "PT123456789","joana@email.com","+351916245321","female","24/09/2000",billingAddress,deliveringAddress);
//        List<Address> expected = new ArrayList<>();
//        expected.add(new Address("Rua 3 n78 4523-439"));
//        List<Address> result = customer.getDeliveringAddress();
//        Assert.assertEquals(expected.get(0).toString(),result.get(0).toString());
//    }
//}
