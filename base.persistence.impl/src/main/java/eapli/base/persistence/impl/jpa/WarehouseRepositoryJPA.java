package eapli.base.persistence.impl.jpa;

import eapli.base.agv.domain.AGV;
import eapli.base.warehouse.domain.*;
import eapli.base.warehouse.persistence.WarehouseRepository;
import org.apache.commons.lang3.reflect.Typed;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class WarehouseRepositoryJPA extends BasepaRepositoryBase<Warehouse,Long,Long> implements WarehouseRepository {

    public WarehouseRepositoryJPA() {
        super("eapli.base");
    }

    @Override
    public Warehouse findWarehouse(){
        final TypedQuery<Warehouse> query = entityManager().createQuery("SELECT d FROM Warehouse d",Warehouse.class);
        return  query.getSingleResult();
    }

    @Override
    public Iterable<AGVDocks> findAllAvgDocksnull() {
        final TypedQuery<AGVDocks> query = entityManager().createQuery("SELECT d FROM AGVDocks d WHERE d.agv = null", AGVDocks.class);
        return query.getResultList();
    }

    @Override
    public AGVDocks findAvgDockById(String agvDockId) {
        final TypedQuery<AGVDocks> query = entityManager().createQuery("SELECT d FROM AGVDocks d WHERE d.id = ?1 and d.agv!=null ", AGVDocks.class);
        query.setParameter(1, agvDockId);
        return query.getSingleResult();
    }
    @Override
    public Iterable<ShelfPK> findAvailableShelfPK() {
        final TypedQuery<ShelfPK> query = entityManager().createQuery("SELECT d.Id FROM Shelf d WHERE (SELECT COUNT(p) FROM  Product p WHERE p.shelfID = d.Id)=0", ShelfPK.class);
        return query.getResultList();
    }

    @Override
    public Shelf getShelfByID(String warehouseID, Long aisleID, Long rowID, Long shelfID) {
        final TypedQuery<Shelf> query = entityManager().createQuery("SELECT d FROM Shelf d WHERE d.Id.warehouseid = ?1 AND d.Id.aisleid = ?2 AND d.Id.rowid = ?3 AND d.Id.shelfid = ?4", Shelf.class);
        query.setParameter(1, warehouseID);
        query.setParameter(2, aisleID);
        query.setParameter(3, rowID);
        query.setParameter(4, shelfID);
        return query.getSingleResult();
    }

    @Override
    public Roww getrowByID(String warehouseID, Long aisleID, Long rowID) {
        final TypedQuery<Roww> query = entityManager().createQuery("SELECT d FROM Roww d WHERE d.Id.warehouseid = ?1 AND d.Id.aisleid = ?2 AND d.Id.rowid = ?3 ", Roww.class);
        query.setParameter(1, warehouseID);
        query.setParameter(2, aisleID);
        query.setParameter(3, rowID);
        return query.getSingleResult();
    }

    @Override
    public Aisle getAisleByID(String warehouseID, Long aisleID) {
        final TypedQuery<Aisle> query = entityManager().createQuery("SELECT d FROM Aisle d WHERE d.id.warehouseid = ?1 AND d.id.aisleid = ?2 ", Aisle.class);
        query.setParameter(1, warehouseID);
        query.setParameter(2, aisleID);
        return query.getSingleResult();
    }


}
