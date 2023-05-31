package eapli.base.product.domain;

import org.junit.Test;

import javax.naming.SizeLimitExceededException;


public class CodeTest {

    @Test(expected = SizeLimitExceededException.class)
    public void codeRulesSize() throws SizeLimitExceededException {
        Code c = new Code("as12345123123123123123131");
    }

    @Test(expected = SizeLimitExceededException.class)
    public void codeRulesRegularExppression() throws SizeLimitExceededException {
        Code c = new Code("12dasd121");
    }

}