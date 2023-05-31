package eapli.base.product.domain;


import org.junit.Test;

import javax.naming.SizeLimitExceededException;


public class ShortDescriptionTest {

    @Test(expected = SizeLimitExceededException.class)
    public void shortDescriptionRules() throws SizeLimitExceededException {
        ShortDescription sd = new ShortDescription("qwertfdsfrqwertfdsfrqwertfdsfrqwertfdsfr");
    }

}