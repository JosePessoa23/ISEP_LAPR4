package eapli.base.projectmanagement.agv.domain;

import eapli.base.agv.domain.ShortDescription;
import org.junit.Test;

import javax.naming.SizeLimitExceededException;

import static org.junit.Assert.*;

public class ShortDescriptionTest {

    @Test
    public void checkShortDescriptionDomainRulesSuccess() throws SizeLimitExceededException {
        ShortDescription shortDescription = new ShortDescription("short_escription");
    }

    @Test(expected = SizeLimitExceededException.class)
    public void checkShortDescriptionDomaiRulesFail() throws SizeLimitExceededException {
        ShortDescription shortDescription = new ShortDescription("short_descriptionshort_descriptionshort_description");
    }

}