package eapli.base.order.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Payment_Confirmation implements ValueObject {

    private String confirmation;

    public Payment_Confirmation(String confirmation) {
        payment_Confirmation(confirmation);
        this.confirmation = confirmation;
    }

    protected Payment_Confirmation() {

    }

    public void payment_Confirmation (String confirmation){
            if(confirmation.length()>500) {
                throw new IllegalArgumentException("Payment confirmation too big.");
            }
    }

    public String payment_confirmation() {
        return confirmation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment_Confirmation that = (Payment_Confirmation) o;
        return (confirmation.equals( that.confirmation));
    }

}
