package eapli.base.customer.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class PhoneNumber implements ValueObject {

    private String phoneNumber;

    public PhoneNumber(String phoneNumber){
        checkPhoneNumber(phoneNumber);
        this.phoneNumber=phoneNumber;
    }

    protected PhoneNumber(){

    }

    public String phoneNumber() {
        return this.phoneNumber;
    }

    private void checkPhoneNumber(String phoneNumber){
        if (phoneNumber.isBlank())
            throw new IllegalArgumentException("Phone number cannot be blank.");
        if ( phoneNumber.length() != 13 ){
            throw new IllegalArgumentException("Phone number must have 13 chars.");
        }
        for (int i = 0; i<phoneNumber.length(); i++){
            char y = phoneNumber.charAt(i);
            if (i==0 && y!='+')
                throw new IllegalArgumentException("Phone number incorrect.");
            else if(i!=0 && y != 48 && y != 49 && y != 50 && y != 51 && y != 52 && y != 53 && y != 54 && y != 55 && y != 56 && y != 57 ){
                throw new IllegalArgumentException("Phone number must be only numbers.");
            }
        }
    }
}
