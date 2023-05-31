package eapli.base.order.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address implements ValueObject {
    private String address;

    public Address(String address){
        addressVerification(address);
        this.address=address;
    }

    protected Address(){

    }

    public void addressVerification(String address){
        if(!address.isEmpty()){
            if(address.length()>100) {
                throw new IllegalArgumentException("Address too big.");
            }
        }else {
            throw new IllegalArgumentException("Address cannot be blank.");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return address.equals(address1.address);
    }

}
