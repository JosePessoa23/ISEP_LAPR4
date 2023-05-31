package eapli.base.customer.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements ValueObject {
    private String address;

    public Address(String address){
        checkAddress(address);
        this.address=address;
    }

    protected Address(){

    }

    public String address(){
        return this.address;
    }

    @Override
    public String toString() {
        return "Customer address{" +
                "address='" + address + '\'' +
                '}';
    }

    private void checkAddress(String address){
        if(!address.isEmpty()){
            if(address.length()>100)
                throw new IllegalArgumentException("Address too big.");
        }
    }
}
