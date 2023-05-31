package eapli.base.projectmanagement.agv.domain;

import eapli.base.agv.domain.Identification;
import org.junit.Test;

import javax.naming.SizeLimitExceededException;

import static org.junit.Assert.*;

public class IdentificationTest {

    @Test
    public void checkIdentificationDomainRulesSuccess() throws SizeLimitExceededException {
        Identification id = new Identification("identify");
    }

    @Test(expected = SizeLimitExceededException.class)
    public void checkIdentificationDomainRulesFail() throws SizeLimitExceededException {
        Identification id = new Identification("identific");
    }

}