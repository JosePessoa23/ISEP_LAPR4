package eapli.base.warehouse.persistence;

import eapli.base.warehouse.domain.*;
import eapli.framework.domain.repositories.DomainRepository;

public interface WarehouseRepository  extends DomainRepository<Long, Warehouse> {
    /**
     * Return all the warehouses
     * @return all the warehouses
     */
    Warehouse findWarehouse();

    /**
     * Return all the agvdocks with a null AGV
     * @return AGV Docks
     */
    Iterable<AGVDocks> findAllAvgDocksnull();

    /**
     * Return a agvdock by id
     * @return AGV Docks
     */
    AGVDocks findAvgDockById(String agvDockId);

    /**
     * Return all the available ROWPK
     * @return ROWPK
     */
    Iterable<ShelfPK> findAvailableShelfPK();

    /**
     * Gets a row by its id
     * @param warehouseID Warehouse id
     * @param aisleID Aisle id
     * @param rowID Row id
     * @return a Row
     */
    Shelf getShelfByID(String warehouseID, Long aisleID, Long rowID, Long shelfID);

    /**
     * Gets a row by its id
     * @param warehouseID Warehouse id
     * @param aisleID Aisle id
     * @param rowID Row id
     * @return a Row
     */
    Roww getrowByID(String warehouseID, Long aisleID, Long rowID);

    /**
     * Gets a aisle by its id
     * @param warehouseID Warehouse id
     * @param aisleID Aisle id
     * @return a Row
     */
    Aisle getAisleByID(String warehouseID, Long aisleID);

}
