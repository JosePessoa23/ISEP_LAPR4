package eapli.base.projectmanagement.agv.domain;

import eapli.base.agv.domain.Autonomy;
import org.junit.Test;

import static org.junit.Assert.*;

public class AutonomyTest {

    @Test
    public void checkAutonomyDomainRulesSuccess(){
        Autonomy autonomy = new Autonomy(1);
        Autonomy autonomy1 = new Autonomy(20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkAutonomyDomainRulesFail(){
        Autonomy autonomy = new Autonomy(-1);
    }


}