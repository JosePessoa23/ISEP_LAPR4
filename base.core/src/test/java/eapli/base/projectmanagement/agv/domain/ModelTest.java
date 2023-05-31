package eapli.base.projectmanagement.agv.domain;

import eapli.base.agv.domain.Model;
import org.junit.Test;

import javax.naming.SizeLimitExceededException;

import static org.junit.Assert.*;

public class ModelTest {

    @Test
    public void checkModelDomainRulesSuccess() throws SizeLimitExceededException {
        Model model = new Model("BMW");
        Model model1 = new Model("KTM");
    }

    @Test(expected = SizeLimitExceededException.class)
    public void checkModelDomainRulesFail() throws SizeLimitExceededException {
        Model model = new Model("BMW_KTM_BNBMW_KTM_BNBMW_KTM_BNBMW_KTM_BNBMW_KTM_BN1");
    }

}