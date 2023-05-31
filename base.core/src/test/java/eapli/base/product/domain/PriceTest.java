package eapli.base.product.domain;

import org.junit.Test;

import javax.naming.SizeLimitExceededException;


public class PriceTest {

    @Test(expected = SizeLimitExceededException.class)
    public void PriceRules() throws SizeLimitExceededException {
        Price p = new Price(-1);
    }
}