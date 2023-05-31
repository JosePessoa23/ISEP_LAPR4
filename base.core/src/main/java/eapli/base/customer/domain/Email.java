package eapli.base.customer.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Email implements ValueObject {

    private String email;

    public Email(String email){
        checkEmail(email);
        this.email=email;
    }

    protected Email(){

    }

    public String email() {
        return this.email;
    }

    private void checkEmail(String email){
        if(email.isBlank())
            throw new IllegalArgumentException("Email can't be blank.");
    }
}
