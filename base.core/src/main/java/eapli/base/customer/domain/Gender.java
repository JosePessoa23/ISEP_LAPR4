package eapli.base.customer.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Gender implements ValueObject {
    private String gender;

    public Gender(String gender) {
        if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female") && !gender.equalsIgnoreCase("other") && !gender.isEmpty())
            throw new IllegalArgumentException("Gender must be male, female or other");
        else
            this.gender=gender;
    }

    public Gender(){}

    public String gender() {
        return gender;
    }
}
