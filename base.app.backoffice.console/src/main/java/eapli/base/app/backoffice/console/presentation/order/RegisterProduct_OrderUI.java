package eapli.base.app.backoffice.console.presentation.order;

import eapli.base.order.application.RegisterProduct_OrderController;
import eapli.base.customer.domain.Address;
import eapli.base.customer.domain.Customer;
import eapli.base.app.backoffice.console.presentation.customer.RegisterCustomerAction;
import eapli.base.product.domain.Product;
import eapli.base.app.backoffice.console.presentation.product.ViewCatalogAction;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RegisterProduct_OrderUI extends AbstractUI {

    private final RegisterProduct_OrderController controller = new RegisterProduct_OrderController();
    private final List<String> payment_methods = List.of(new String[]{"MBWAY", "Paypal", "Cartao de credito/debito", "Multibanco"});
    private final List<String> shipment_methods = List.of(new String[]{"Standand", "Blue", "Green"});


    @Override
    protected boolean doShow() {
        List<Integer> quantitylist = new ArrayList<>();
        int quantidade;
        List<Product> productList = controller.findAllProducts();
        List<Product> order_productList = new ArrayList<>();
        Product product;


        do {

            String str;
            if (confirms("Do you want to type the product id?")) {
                do {
                    if(confirms("Do you want to see the catalog first?")){
                        new ViewCatalogAction().execute();
                    }
                    str = Console.readLine("Type the product's ID");
                    try {
                        product = controller.findProductByID(str);
                        order_productList.add(product);
                        quantidade = Console.readInteger("Put the quantity you want");
                        quantitylist.add(quantidade);
                    }catch (Exception e){
                        System.out.println("You inserted a ID that doesn't match any product\n");
                    }

                } while (confirms("Do you want to continue typing ids?"));
            }


            if (confirms("Do you want to select products?")) {

                boolean confirmation = true;

                do {

                    product = (Product) showAndSelectOne(productList, "Choose a product");

                    if (product != null) {
                        quantidade = Console.readInteger("Put the quantity you want");
                        order_productList.add(product);
                        quantitylist.add(quantidade);
                        confirmation = confirms("Do you want to keep selecting products?\n Answer:S/N");
                    } else {
                        confirmation = false;
                    }
                } while (product != null && confirmation);

            }
        }while (confirms("Do you want to add more products?"));

        String str;
        boolean flag=false;
        Customer customer = null;
        do {
            try{
                str = Console.readLine("Type the client's ID");
                customer = controller.findCustomerByID(str);
                flag=false;
            }catch (Exception e){
                flag=true;
                System.out.println("You inserted a ID that doesn't match any client");
                if (confirms("DO you want to create a new client?")){
                    new RegisterCustomerAction().execute();
                }
            }
        }while (flag);

        Address address;
        flag =false;
        do {
            address = (Address) showAndSelectOne(customer.getBillingAddress(),"Choose the wanted billing address");
            if (address == null){
                flag=true;
                System.out.println("Please choose an address\n");
            }
        }while (flag);


        String bilingaddress = address.address();
        flag =false;
        do {
            address = (Address) showAndSelectOne(customer.getDeliveringAddress(),"Choose the wanted delivering address");
            if (address == null){
                flag=true;
                System.out.println("Please choose an address\n");
            }
        }while (flag);
        String deliveringaddress = address.address();



        String shipment_method = (String) showAndSelectOne(shipment_methods,"Choose the shipment method");
        String payment = (String) showAndSelectOne(payment_methods,"Choose a method of payment");
        String sourceofInformation = Console.readLine("What was the way of comunication with the client?");
        Date registration_time = Calendar.getInstance().getTime();
        try{
            controller.addOrder(registration_time,shipment_method,payment,order_productList,quantitylist,bilingaddress,deliveringaddress,customer,sourceofInformation);
            System.out.println("Order created with success\n");
        }catch (Exception e){
            System.out.println("It occurred an error creation your order");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Create a new Product_Order";
    }

    private Object showAndSelectOne(List list, String header)
    {
        showList(list,header);
        return selectsObject(list);
    }

    private boolean confirms(String message){
        String str;
        do {
            str = Console.readLine("\n" + message + "\n");
        } while (!str.equalsIgnoreCase("s") && !str.equalsIgnoreCase("n"));

        return str.equalsIgnoreCase("s");
    }


    private Object selectsObject(List list)
    {
        String input;
        Integer value;
        do
        {
            input = Console.readLine("Type your option: ");
            value =  Integer.valueOf(input);
        } while (value < 0 || value > list.size());

        if (value == 0)
        {
            return null;
        } else
        {
            return list.get(value - 1);
        }
    }

    private int selectsIndex(List list)
    {
        String input;
        Integer value;
        do
        {
            input = Console.readLine("Type your option: ");
            value =  Integer.valueOf(input);
        } while (value < 0 || value > list.size());

        return value - 1;
    }

    private void showList(List list, String header)
    {
        System.out.println(header);

        int index = 0;
        for (Object o : list)
        {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println("");
        System.out.println("0 - Cancel");
    }
}
