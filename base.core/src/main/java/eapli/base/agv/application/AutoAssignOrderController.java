package eapli.base.agv.application;

import eapli.base.agv.domain.AGV;
import eapli.base.agv.persistence.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.order.domain.Product_Order;
import eapli.base.order.dto.Product_OrderDTO;
import eapli.base.order.persistence.OrderRepository;
import eapli.base.warehouse.domain.Warehouse;
import eapli.base.warehouse.persistence.WarehouseRepository;

import java.util.List;


public class AutoAssignOrderController {

    /**
     * The order repository
     */
    private final OrderRepository orderRepository = PersistenceContext.repositories().order();
    /**
     * The agv repository
     */
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();
    /**
     * The warehouse repository
     */
    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();


    public Product_OrderDTO autoAssignOrder(){
        Warehouse warehouse=  warehouseRepository.findWarehouse();
        Product_Order order = warehouse.getNextOrder();
        if(order == null){
            throw new IndexOutOfBoundsException();
        }

        List<AGV> agvList = (List<AGV>) agvRepository.findAbleAGVs(order.weight(), order.volume());
        if(agvList.size()==0){
            throw new NullPointerException();
        }
        AGV agv = agvList.get(0);
        agv.occupyAGV();
        agvRepository.save(agv);
        order.beingPrepared();
        orderRepository.save(order);
        order.readyForPacking();
        orderRepository.save(order);
        agv.freeAGV();
        agvRepository.save(agv);
        warehouseRepository.save(warehouse);
        return toDTOOrder(order);
    }

    private Product_OrderDTO toDTOOrder(Product_Order order){
        return order.toDTO();
    }
}
