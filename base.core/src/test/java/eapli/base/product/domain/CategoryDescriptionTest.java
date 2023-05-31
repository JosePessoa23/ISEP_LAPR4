package eapli.base.product.domain;

import org.junit.Test;

import javax.naming.SizeLimitExceededException;


public class CategoryDescriptionTest {

    @Test(expected = SizeLimitExceededException.class)
    public void descriptionRuleTest() throws SizeLimitExceededException {
        CategoryDescription cd = new CategoryDescription("asasd");
    }
    @Test(expected = SizeLimitExceededException.class)
    public void descriptionRuleTest2() throws SizeLimitExceededException {
        CategoryDescription cd = new CategoryDescription("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
    @Test(expected = SizeLimitExceededException.class)
    public void descriptionRuleTestNull() throws SizeLimitExceededException {
        CategoryDescription cd = new CategoryDescription(null);
    }

}