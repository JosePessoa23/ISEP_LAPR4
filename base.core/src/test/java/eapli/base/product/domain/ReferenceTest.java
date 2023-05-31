package eapli.base.product.domain;

import org.junit.Test;

import javax.naming.SizeLimitExceededException;



public class ReferenceTest {


    @Test(expected = SizeLimitExceededException.class)
    public void referenceRules() throws SizeLimitExceededException {
        Reference r = new Reference("123456789012345678901234567890123456789012345678901234567890");
    }

    @Test(expected = SizeLimitExceededException.class)
    public void referenceRulesBlank() throws SizeLimitExceededException {
        Reference r = new Reference(" ");
    }

    @Test(expected = SizeLimitExceededException.class)
    public void referenceRulesEmpty() throws SizeLimitExceededException {
        Reference r = new Reference("");
    }

}