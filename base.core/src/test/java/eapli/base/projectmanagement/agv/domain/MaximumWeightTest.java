package eapli.base.projectmanagement.agv.domain;

import eapli.base.agv.domain.MaximumWeight;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumWeightTest {

    @Test
    public void checkMaximumWeightDomainRulesSuccess(){
        MaximumWeight weight = new MaximumWeight(1);
        MaximumWeight weight1 = new MaximumWeight(123);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMaximumWeightDomainRulesFail(){
        MaximumWeight weight = new MaximumWeight(-1);
    }

}