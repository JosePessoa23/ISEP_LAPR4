package eapli.base.transition;

import eapli.base.agv.domain.AGV;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.order.domain.Product_Order;
import eapli.base.order.persistence.OrderRepository;
import eapli.base.product.domain.Product;
import eapli.base.product.persistance.ProductRepository;
import eapli.base.warehouse.domain.AGVDocks;
import eapli.base.warehouse.domain.Aisle;
import eapli.base.warehouse.domain.Roww;
import eapli.base.warehouse.domain.Warehouse;
import eapli.base.warehouse.persistence.WarehouseRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetProductLocationController {

    /**
     * The warehouse repository
     */
    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();
    private final OrderRepository orderRepository = PersistenceContext.repositories().order();

    public HashMap<Product_Order, List<Roww>> getProductLocation(){
        HashMap returnValue = new HashMap<>();
        Warehouse warehouse=  warehouseRepository.findWarehouse();
        Product_Order order = warehouse.getNextOrder();
        if(order == null){
            throw new IndexOutOfBoundsException();
        }
        order.beingPrepared();
        List<Product> products =order.productList();
        List<Roww> rows = new ArrayList<>();
        for (Product p : products){
            Roww row = warehouseRepository.getrowByID(p.shelfID().id().warehouseid(),p.shelfID().id().aisleid(),p.shelfID().id().rowid());
            rows.add(row);
        }
        returnValue.put(order, rows);
        warehouseRepository.save(warehouse);
        return returnValue;

    }

    public AGVDocks getAgvLocation(String id){
        AGVDocks agvDocks = warehouseRepository.findAvgDockById(id);
        occupyAGV(agvDocks.agv());
        return agvDocks;
    }

    public String getAccessibility(Roww roww){
        Aisle aisle = warehouseRepository.getAisleByID(roww.id().warehouseid(), roww.id().aisleid());
        return aisle.accessibility();
    }

    public void setOrderReady(Product_Order order){
        order.readyForPacking();
        orderRepository.save(order);
    }

    private void occupyAGV(AGV agv){
        agv.occupyAGV();
    }

    public void freeAGV(String id){
        Warehouse warehouse=  warehouseRepository.findWarehouse();
        AGVDocks agvDocks = warehouseRepository.findAvgDockById(id);
        agvDocks.agv().freeAGV();
        warehouseRepository.save(warehouse);
    }

}
