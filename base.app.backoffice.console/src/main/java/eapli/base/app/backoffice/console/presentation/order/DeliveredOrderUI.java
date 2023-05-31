package eapli.base.app.backoffice.console.presentation.order;

import eapli.base.order.application.DeliveredOrderController;
import eapli.base.order.dto.Product_OrderDTOComplete;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class DeliveredOrderUI extends AbstractUI {

    private final DeliveredOrderController theController = new DeliveredOrderController();

    @Override
    protected boolean doShow() {
        Product_OrderDTOComplete product_orderDTOComplete = (Product_OrderDTOComplete) showAndSelectOne(theController.getOrdersToBeDelivered(),"Choose the Order you want to change the state on");
        if (product_orderDTOComplete!=null) {
            theController.changeStatus(product_orderDTOComplete);
        }
        return true;
    }

    @Override
    public String headline() {
        return "Change the Order State to Delivered by carrier";
    }

    private Object showAndSelectOne(List list, String header)
    {
        showList(list,header);
        return selectsObject(list);
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
