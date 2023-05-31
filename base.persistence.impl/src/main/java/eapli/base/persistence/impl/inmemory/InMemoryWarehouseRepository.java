package eapli.base.persistence.impl.inmemory;

import eapli.base.agv.domain.AGV;
import eapli.base.warehouse.domain.*;
import eapli.base.warehouse.persistence.WarehouseRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryWarehouseRepository extends InMemoryDomainRepository<Warehouse,Long> implements WarehouseRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Warehouse findWarehouse() {
        return null;
    }

    @Override

    public Iterable<AGVDocks> findAllAvgDocksnull() {
        return null;
    }

    @Override
    public AGVDocks findAvgDockById(String agvDockId) {
        return null;
    }

    public Iterable<ShelfPK> findAvailableShelfPK() {
        return null;
    }

    @Override
    public Shelf getShelfByID(String warehouseID, Long aisleID, Long rowID, Long shelfID) {
        return null;
    }

    @Override
    public Roww getrowByID(String warehouseID, Long aisleID, Long rowID) {
        return null;
    }

    @Override
    public Aisle getAisleByID(String warehouseID, Long aisleID) {
        return null;
    }

}
