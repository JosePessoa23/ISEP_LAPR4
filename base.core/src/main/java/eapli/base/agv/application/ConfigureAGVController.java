package eapli.base.agv.application;

import eapli.base.agv.domain.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.agv.persistence.AGVRepository;
import eapli.base.warehouse.domain.AGVDocks;
import eapli.base.warehouse.domain.Warehouse;
import eapli.base.warehouse.persistence.WarehouseRepository;

import javax.naming.SizeLimitExceededException;

public class ConfigureAGVController {

    /**
     * The warehouse repository
     */
    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();
    /**
     * The agv repository
     */
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();

    /**
     * Creates an agv and saves it on repository
     * @param agvDocks the agv docks
     * @param id the agv's id
     * @param shortDescription the agv's Short descrption
     * @param model the agv's Model
     * @param maximumWeight the agv's Maximum Weight
     * @param maximumVolume the agv's Maximum Volume
     * @param baseLocation  the agv's Base Location
     * @param autonomy the agv's Status
     * @throws SizeLimitExceededException
     */
    public void configureAGV(AGVDocks agvDocks, Identification id, ShortDescription shortDescription, Model model, MaximumWeight maximumWeight, MaximumVolume maximumVolume,String baseLocation, Autonomy autonomy, int agvSpeed) throws SizeLimitExceededException {
        AGV agv = new AGV(id,shortDescription,model,maximumWeight,maximumVolume,baseLocation, autonomy, agvSpeed);
        agvRepository.save(agv);
        agvDocks.setAgv(agvRepository.findAGVWithid(id.id()));
        Warehouse warehouse = warehouseRepository.findWarehouse();
        warehouse.setaddAgvDocks(agvDocks);
        warehouseRepository.save(warehouse);
    }

}
