package eapli.base.product.domain;

import org.junit.Test;

import javax.naming.SizeLimitExceededException;


public class ExtendedDescriptionTest {

    @Test(expected = SizeLimitExceededException.class)
    public void extendedDescriptionRules() throws SizeLimitExceededException {
       ExtendedDescription ed = new ExtendedDescription("extended");
    }

    @Test(expected = SizeLimitExceededException.class)
    public void extendedDescriptionRules2() throws SizeLimitExceededException {
        ExtendedDescription ed = new ExtendedDescription("extended1extended1extended1extended1extended1extended1extended1extended1extended1extended1extended1extended1");
    }

}