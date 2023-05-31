package eapli.base.app.backoffice.console.presentation.agv;

import eapli.base.agv.application.ConfigureAGVController;
import eapli.base.agv.domain.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouse.domain.AGVDocks;
import eapli.base.warehouse.persistence.WarehouseRepository;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import javax.naming.SizeLimitExceededException;

public class ConfigureAGVUI extends AbstractUI {

    private final ConfigureAGVController theController = new ConfigureAGVController();

    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();

    @Override
    protected boolean doShow() {
        Iterable<AGVDocks> agvDocks =  warehouseRepository.findAllAvgDocksnull();
        System.out.println("Choose from which AGV Dock you want to configure the AGV");
        int i=1;
        for (AGVDocks agvDock:agvDocks){
            System.out.println(i+"."+agvDock.getId());
            i++;
        }
        if (i==1){
            System.out.println("There are no AGVs available to configure");
            return true;
        }
        int number = Console.readInteger("Pick a number:");
        int x=1;
        AGVDocks agvDocks1 = null;
        for (AGVDocks agvDock:agvDocks){
            if (x==number) {
                agvDocks1=agvDock;
            }
            x++;
        }
        while(x<=number){
            agvDocks1=agvDocks.iterator().next();
            x++;
        }
        String id = Console.readLine("Id:");

        String description = Console.readLine("Short description:");
        String agvmodel = Console.readLine("AGV Model:");
        int weight = Console.readInteger("Maximum Weight:");
        int volume = Console.readInteger("Maximum Volume:");
        int agvSpeed = Console.readInteger("Agv Speed(squares/second:");
        Identification identification;
        try {
            identification = new Identification(id);
        } catch (SizeLimitExceededException e) {
            throw new RuntimeException(e);
        }
        ShortDescription shortDescription;
        try {
            shortDescription = new ShortDescription(description);
        } catch (SizeLimitExceededException e) {
            throw new RuntimeException(e);
        }
        Model model;
        try {
            model = new Model(agvmodel);
        } catch (SizeLimitExceededException e) {
            throw new RuntimeException(e);
        }
        MaximumWeight maximumWeight = new MaximumWeight(weight);
        MaximumVolume maximumVolume = new MaximumVolume(volume);
        String baseLocation = "AGV dock";
        Autonomy autonomy = new Autonomy(2);
        try {
            theController.configureAGV(agvDocks1,identification,shortDescription,model,maximumWeight,maximumVolume,baseLocation, autonomy, agvSpeed);
        } catch (SizeLimitExceededException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public String headline() {
        return "Configure the AGVs available on the warehouse";
    }
}
