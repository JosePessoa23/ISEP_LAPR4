package eapli.base.product.domain;

import org.junit.Test;

import javax.naming.SizeLimitExceededException;


public class BrandTest {

    @Test(expected = SizeLimitExceededException.class)
    public void brandRules() throws SizeLimitExceededException {
        Brand b = new Brand("brandbrandbrandbrandbrandbrandbrandbrandbrandbrandbrandbrand");
    }

    @Test(expected = SizeLimitExceededException.class)
    public void brandRulesNull() throws SizeLimitExceededException {
        Brand b = new Brand(null);
    }

}