package eapli.base.warehouse.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouse.domain.AGVDocks;
import eapli.base.warehouse.domain.Aisle;
import eapli.base.warehouse.domain.Warehouse;
import eapli.base.warehouse.persistence.WarehouseRepository;


public class BuildWarehouseController {

    /**
     * The warehouse repository
     */
    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();

    private final String square="🔲";
    private final String parede="🧱";
    private final String agvdocks="🅿️";

    public String[][] getWarehouseMatrix() {
        Warehouse warehouse = warehouseRepository.findWarehouse();
        int square=warehouse.square();
        int y = warehouse.length()/square;
        int x = warehouse.width()/square;
        String[][] matrix = new String[x][y];
        setMatrixToZero(matrix);
        setAisleInWarehouse(matrix,warehouse);
        setAgvDocksInWarehouse(matrix,warehouse);
        return matrix;

    }

    public void setMatrixToZero(String[][] matrix){

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j]=square;

    }
    public void setAisleInWarehouse(String[][] matrix,Warehouse warehouse){

        for (Aisle aisle: warehouse.aisles()) {
            int depthw=aisle.depthw();
            int endw=aisle.endw();
            if (depthw>endw){
                int z =depthw;
                depthw=endw;
                endw=z;
            }
            for (int i= depthw-1;i<= endw-1;i++){
                for (int x=aisle.beginl()-1;x<=aisle.endl()-1;x++){
                    matrix[i][x] = parede;
                }
            }
        }


    }

    public void setAgvDocksInWarehouse(String[][] matrix,Warehouse warehouse){

        for (AGVDocks agvDocks: warehouse.agvDocks()) {
            for (int i= agvDocks.beginw()-1;i<= agvDocks.endw()-1;i++){
                for (int x=agvDocks.beginl()-1;x<=agvDocks.endl()-1;x++){
                        matrix[i][x] = agvdocks;
                }
            }
        }


    }

}
