package eapli.base.app.backoffice.console.presentation.agv;

import eapli.base.agv.application.AssignOrderController;
import eapli.base.agv.dto.AGVDTO;
import eapli.base.order.dto.Product_OrderDTOComplete;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class AssignOrderUI extends AbstractUI {

    private final AssignOrderController theController = new AssignOrderController();

    @Override
    protected boolean doShow() {
        List<Product_OrderDTOComplete> orderDTOList = theController.getOrdersToBePrepared();
        if (orderDTOList.size() ==0){
            System.out.println("There are no orders to be prepared at the Warehouse");
            return true;
        }

        Product_OrderDTOComplete orderDTO = (Product_OrderDTOComplete) showAndSelectOne(orderDTOList,"Choose an order to be prepared");

        List<AGVDTO> agvDTOList = theController.getAGVAvailable(orderDTO);
        if (agvDTOList.size() ==0){
            System.out.println("There are no AGV available and able to prepare that order");
            return true;
        }

        AGVDTO agvdto = (AGVDTO) showAndSelectOne(agvDTOList,"Choose an agv to prepare an order");

        try{
            theController.AssignOrder(orderDTO,agvdto);
        }catch (Exception e){
            System.out.println("There was an error changing the status of the order or of the AGV");
        }

        return true;
    }

    @Override
    public String headline() {
        return "Assign an order";
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
