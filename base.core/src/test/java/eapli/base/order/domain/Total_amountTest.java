package eapli.base.order.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class Total_amountTest {

    @Test(expected = IllegalArgumentException.class)
    public void total_amountVerificationWhithTaxesNegative() {
        Total_amount la = new Total_amount(-2.0,2.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void total_amountVerificationWithoutTaxesNegative() {
        Total_amount la = new Total_amount(2.0,-2.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void total_amountVerificationBothNegative() {
        Total_amount la = new Total_amount(-2.0,-2.0);
    }

    @Test
    public void total_amountVerification() {
        Total_amount la = new Total_amount(2.0,2.0);
    }
}