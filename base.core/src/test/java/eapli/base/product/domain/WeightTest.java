package eapli.base.product.domain;

import org.junit.Test;

import javax.naming.SizeLimitExceededException;


public class WeightTest {

    @Test(expected = SizeLimitExceededException.class)
    public void WeightRules() throws SizeLimitExceededException {
        Weight p = new Weight(-1);
    }

}