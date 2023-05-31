package eapli.base.product.domain;

import org.junit.Test;

import javax.naming.SizeLimitExceededException;


public class VolumeTest {

    @Test(expected = SizeLimitExceededException.class)
    public void VolumeRules() throws SizeLimitExceededException {
        Volume v = new Volume(-1);
    }

}