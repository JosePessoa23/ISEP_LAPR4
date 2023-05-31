package eapli.base.app.backoffice.console.presentation.agv;

import eapli.base.agv.application.AutoAssignOrderController;
import eapli.base.order.dto.Product_OrderDTO;
import eapli.framework.presentation.console.AbstractUI;

public class AutoAssignOrderUI extends AbstractUI {

    private final AutoAssignOrderController controller = new AutoAssignOrderController();

    @Override
    protected boolean doShow() {
        try {
            Product_OrderDTO orderDTO = controller.autoAssignOrder();
            System.out.printf("\nThe order assign to the AGV was:\n  ID -> %s\n  Date -> %s\n", orderDTO.id, orderDTO.registration_time);
            return true;
        }catch (NullPointerException e){
            System.out.println("\nThere are no AGV available and able to prepare that order.");
            return true;
        }catch (IndexOutOfBoundsException e){
            System.out.println("\nThere are no orders to be prepared at the Warehouse.");
            return true;
        }
    }

    @Override
    public String headline() {
        return "Assign the next order on the list to an AGV";
    }
}
