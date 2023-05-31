package eapli.base.customer.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable

public class VatID implements ValueObject {
    @Column(unique = true)
    private String vatID;

    public VatID(String vatID){
        checkVatID(vatID);
        this.vatID=vatID;
    }

     protected VatID(){

    }

    public String vatID(){
        return this.vatID;
    }

    @Override
    public String toString() {
        return "Customer VAT ID{" +
                "VAT ID='" + vatID + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VatID vatID1 = (VatID) o;
        return this.vatID.equalsIgnoreCase(vatID1.vatID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(vatID);
    }

    private void checkVatID(String vatID){
        boolean result=true;
        if(vatID.isBlank())
            throw new IllegalArgumentException("VAT ID can't be blank.");
        String x = vatID.substring(0,2);
        if(x.equalsIgnoreCase("PT")|| x.equalsIgnoreCase("DE")){
            if(vatID.length()==11){
                for(int i=2; i<vatID.length();i++){
                    char y = vatID.charAt(i);
                    if (y != 48 && y != 49 && y != 50 && y != 51 && y != 52 && y != 53 && y != 54 && y != 55 && y != 56 && y != 57 ){
                        throw new IllegalArgumentException("Invalid VAT ID.");
                    }
                }
            } else
                result=false;
            if(!result){
                throw new IllegalArgumentException("Invalid VAT ID.");
            }
        } else if(x.equalsIgnoreCase("ES")){
            if(vatID.length()==11){
                for(int i=3; i<vatID.length()-1;i++){
                    char y = vatID.charAt(i);
                    if (y != 48 || y != 49 || y != 50 || y != 51 || y != 52 || y != 53 || y != 54 || y != 55 || y != 56 || y != 57 ){
                        throw new IllegalArgumentException("Invalid VAT ID.");
                    }
                }
            } else
                result=false;
            if(!result){
                throw new IllegalArgumentException("Invalid VAT ID.");
            }

        } else if(x.equalsIgnoreCase("FR")){
            if(vatID.length()==13){
                for(int i=4; i<vatID.length();i++){
                    char y = vatID.charAt(i);
                    if (y != 48 || y != 49 || y != 50 || y != 51 || y != 52 || y != 53 || y != 54 || y != 55 || y != 56 || y != 57 ){
                        throw new IllegalArgumentException("Invalid VAT ID.");
                    }
                }
            } else
                result=false;
            if(!result){
                throw new IllegalArgumentException("Invalid VAT ID.");
            }

        } else if(x.equalsIgnoreCase("NL")){
            if(!(vatID.length()==14))
                result=false;
            if(!result){
                throw new IllegalArgumentException("Invalid VAT ID.");
            }

        } else if(x.equalsIgnoreCase("IT")){
            if(vatID.length()==13){
                for(int i=2; i<vatID.length();i++){
                    char y = vatID.charAt(i);
                    if (y != 48 || y != 49 || y != 50 || y != 51 || y != 52 || y != 53 || y != 54 || y != 55 || y != 56 || y != 57 ){
                        throw new IllegalArgumentException("Invalid VAT ID.");
                    }
                }
            } else
                result=false;
            if(!result){
                throw new IllegalArgumentException("Invalid VAT ID.");
            }
        } else
            throw new IllegalArgumentException("Invalid VAT ID.");
    }
}
