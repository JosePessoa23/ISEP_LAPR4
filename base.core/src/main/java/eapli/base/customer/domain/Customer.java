package eapli.base.customer.domain;

import com.sun.istack.NotNull;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer implements AggregateRoot<Integer> {

    /**
     * The customer's generated ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The customer's name
     */
    @Embedded
    @NotNull
    private Name name;

    /**
     * The customer's gender
     */
    @Embedded
    private Gender gender;

    /**
     * The customer's email
     */
    @Embedded
    @NotNull
    private Email email;

    /**
     * The customer's phone number
     */
    @Embedded
    @NotNull
    private PhoneNumber phoneNumber;

    /**
     * The customer's birthdate
     */
    @Embedded
    private BirthDate birthDate;

    /**
     * The customer's billing addresses
     */
    @ElementCollection
    private List<Address> billingAddress;

    /**
     * The customer's delivering addresses
     */
    @ElementCollection
    private List<Address> deliveringAddress;

    /**
     * The customer's vat ID
     */
    @Embedded
    @NotNull
    private VatID vatID;

    /**
     * Creates an instance of Customer.
     * @param name
     * @param vatID
     * @param email
     * @param phoneNumber
     * @param gender
     * @param birthDate
     * @param billingAddress
     * @param deliveringAddress
     */
    public Customer (String name, String vatID, String email, String phoneNumber, String gender, String birthDate, List<String> billingAddress, List<String> deliveringAddress){
        Name name1 = new Name(name);
        VatID vatID1 = new VatID(vatID);
        Email email1 = new Email(email);
        PhoneNumber phoneNumber1 = new PhoneNumber(phoneNumber);
        Gender gender1 = new Gender(gender);
        BirthDate birthDate1 = new BirthDate(birthDate);
        List<Address> billingAddress1 = new ArrayList<>();
        for(String bill: billingAddress){
            Address address=new Address(bill);
            billingAddress1.add(address);
        }
        List<Address> deliveringAddress1 = new ArrayList<>();
        for(String delive: deliveringAddress){
            Address address=new Address(delive);
            deliveringAddress1.add(address);
        }
        this.name=name1;
        this.vatID=vatID1;
        this.email=email1;
        this.phoneNumber=phoneNumber1;
        this.gender=gender1;
        this.birthDate=birthDate1;
        this.billingAddress=billingAddress1;
        this.deliveringAddress=deliveringAddress1;
    }

    /**
     * Creates an instance of Customer
     */
    protected Customer(){

    }

    /**
     * Gets the customer's billing addresses.
     * @return customer's billing addresses
     */
    public List<Address> getBillingAddress() {
        return billingAddress;
    }

    /**
     * Gets the customer's delivering addresses.
     * @return customer's delivering addresses
     */
    public List<Address> getDeliveringAddress() {
        return deliveringAddress;
    }

    public Name getName() {
        return name;
    }

    public BirthDate birthDate() {
        return birthDate;
    }

    public Gender gender() {
        return gender;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return id;
    }

}
