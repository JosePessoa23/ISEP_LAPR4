package eapli.base.agv.application;

import eapli.base.agv.domain.*;
import eapli.base.agv.dto.AGVDTO;
import eapli.base.agv.persistence.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.order.domain.Product_Order;
import eapli.base.order.dto.Product_OrderDTOComplete;
import eapli.base.order.persistence.OrderRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.warehouse.domain.Warehouse;
import eapli.base.warehouse.persistence.WarehouseRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

public class AssignOrderController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    /**
     * The agv repository
     */
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();
    /**
     * The warehouse repository
     */
    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();
    /**
     * The order repository
     */
    private final OrderRepository orderRepository = PersistenceContext.repositories().order();


    public void AssignOrder(Product_OrderDTOComplete orderDTOComplete,AGVDTO agvdto) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE);
        Product_Order order = orderRepository.findOrderWithid(orderDTOComplete.id);
        AGV agv = agvRepository.findAGVWithid(agvdto.id);
        List<Warehouse> warehouseList = (List<Warehouse>) warehouseRepository.findWarehouse();
        Warehouse warehouse = warehouseList.get(0);
        warehouse.getOrders().remove(order);
        agv.occupyAGV();
        agvRepository.save(agv);
        order.beingPrepared();
        orderRepository.save(order);
        order.readyForPacking();
        orderRepository.save(order);
        agv.freeAGV();
        agvRepository.save(agv);
        warehouseRepository.save(warehouse);
    }


    /**
     * get All orders available to be prepared at the Warehouse
     * @return orders list
     */
    public  List<Product_OrderDTOComplete> getOrdersToBePrepared() {
        List<Warehouse> warehouseList = (List<Warehouse>) warehouseRepository.findWarehouse();
        Warehouse warehouse = warehouseList.get(0);
        return toDTOOrder(warehouse.getOrders());
    }

    private List<Product_OrderDTOComplete> toDTOOrder( List<Product_Order> list){
        List<Product_OrderDTOComplete> listDTO = new ArrayList<>();
        for (Product_Order order: list) {
            listDTO.add(order.toDTOComplete());
        }
        return listDTO;
    }

    public  List<AGVDTO> getAGVAvailable(Product_OrderDTOComplete orderDTOComplete) {
        List<AGV> list = (List<AGV>) agvRepository.findAbleAGVs(orderDTOComplete.totalweight,orderDTOComplete.totalvolume);
        return toDTOAGV(list);
    }

    private List<AGVDTO> toDTOAGV(List<AGV> list){
        List<AGVDTO> listDTO = new ArrayList<>();
        for (AGV agv: list) {
            listDTO.add(agv.toDTO());
        }
        return listDTO;
    }

}
