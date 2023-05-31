package eapli.base.customer.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Name implements ValueObject {
    private String name;

    public Name(String name){
        checkName(name);
        this.name=name;
    }

    protected Name(){
    }

    public String name() {
        return this.name;
    }

    private void checkName(String name){
        if(name.isBlank())
            throw new IllegalArgumentException("Name cannot be blank.");
        else if(name.length()<=150) {
            for (int i = 0; i<name.length(); i++){
                char y = name.charAt(i);
                if (y == 48 || y == 49 || y == 50 || y == 51 || y == 52 || y == 53 || y == 54 || y == 55 || y == 56 || y == 57 ){
                    throw new IllegalArgumentException("Name must be only letters.");
                }
            }
        }
        else
            throw new IllegalArgumentException("Name too big");
    }
}
