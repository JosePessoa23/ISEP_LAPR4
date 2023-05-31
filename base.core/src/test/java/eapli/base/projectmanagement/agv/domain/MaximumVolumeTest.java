package eapli.base.projectmanagement.agv.domain;

import eapli.base.agv.domain.MaximumVolume;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumVolumeTest {

    @Test
    public void checkMaximumVolumeDomainRulesSuccess(){
        MaximumVolume volume = new MaximumVolume(1);
        MaximumVolume volume1 = new MaximumVolume(50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMaximumVolumeDomainRulesFail(){
        MaximumVolume volume = new MaximumVolume(-1);
    }

}