package eapli.base.app.backoffice.console.presentation.customer;

import eapli.base.customer.application.RegisterCustomerController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class RegisterCustomerUI extends AbstractUI {

    private final RegisterCustomerController rcc = new RegisterCustomerController();


    @Override
    protected boolean doShow() {
        System.out.println("1 - Register with first and last name");
        System.out.println("2 - Register with full name");
        int option = Console.readInteger("Option: ");
        String name = "";
        switch (option){
            case 1: final String firstName = Console.readLine("First Name");
                    final String lastName = Console.readLine("Last Name");
                    name = String.format(firstName+" "+lastName);
                    break;
            case 2: name = Console.readLine("Full Name");
                    break;
        }
        final String vatID = Console.readLine("VAT ID");
        final String email = Console.readLine("Email");
        final String phoneNumber = Console.readLine("Phone Number");
        final String gender = Console.readLine("Gender");
        final String birthDate = Console.readLine("Birth Date (yyyy-MM-dd)");
        final List<String> billingAddresses = new ArrayList<>();
        do{
            final String billingAddress = Console.readLine("Billing Address");
            billingAddresses.add(billingAddress);
            System.out.println("0 - Next");
            System.out.println("1 - Insert more billing addresses");
            option = Console.readInteger("Option: ");
        } while(option!=0);
        final List<String> deliveringAddresses = new ArrayList<>();
        do{
            final String deliveringAddress = Console.readLine("Delivering Address");
            deliveringAddresses.add(deliveringAddress);
            System.out.println("0 - Next");
            System.out.println("1 - Insert more delivering addresses");
            option = Console.readInteger("Option: ");
        } while(option!=0);
        try{
            rcc.registerCustomer(name,vatID,email,phoneNumber,gender,birthDate,billingAddresses,deliveringAddresses);
        }catch (Exception e){
            System.out.println(e);
            System.out.println("There was a mistake while registering a new customer.");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Register a new customer";
    }
}
