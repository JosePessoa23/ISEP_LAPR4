package eapli.base.surveymanagement.domain;

import eapli.base.order.domain.Total_amount;
import org.junit.Test;

import javax.naming.SizeLimitExceededException;

import static org.junit.Assert.*;

public class DescriptionTest {

    @Test(expected = SizeLimitExceededException.class)
    public void descriptionEmpty() throws SizeLimitExceededException {
        Description description = new Description("");
    }

    @Test(expected = SizeLimitExceededException.class)
    public void descriptionTooBig() throws SizeLimitExceededException {
        Description description = new Description("gjueguiergreuigjergiuergiuheruighuerigierhgiuerhuigerhgiuerhguierhiowniomeiomiocmiomeiomiomiomooimio");
    }

    @Test
    public void descriptionOkay() throws SizeLimitExceededException {
        Description description = new Description("uhuhuhuef");
    }

}