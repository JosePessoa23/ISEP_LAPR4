package eapli.base.surveymanagement.domain;

import org.junit.Test;

import javax.naming.SizeLimitExceededException;

import static org.junit.Assert.*;

public class CodeTest {

    @Test(expected = SizeLimitExceededException.class)
    public void codeOnlyLetters() throws SizeLimitExceededException {
        Code code = new Code("ergregerg");
    }

    @Test(expected = SizeLimitExceededException.class)
    public void codeOnlyNumbers() throws SizeLimitExceededException {
        Code code = new Code("32435323");
    }

    @Test(expected = SizeLimitExceededException.class)
    public void codeTooBig() throws SizeLimitExceededException {
        Code code = new Code("rger4234234234234234242342424342");
    }

    @Test
    public void codeOkay() throws SizeLimitExceededException {
        Code code = new Code("323regerg");
    }
}