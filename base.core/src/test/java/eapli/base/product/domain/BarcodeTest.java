package eapli.base.product.domain;

import org.junit.Test;

import javax.naming.SizeLimitExceededException;


public class BarcodeTest {

    @Test(expected = SizeLimitExceededException.class)
    public void barcodeRules() throws SizeLimitExceededException {
        Barcode b = new Barcode("1111111111111");
    }

    @Test(expected = SizeLimitExceededException.class)
    public void barcodeRulesLessThanExpected() throws SizeLimitExceededException {
        Barcode b = new Barcode("132123");
    }

}