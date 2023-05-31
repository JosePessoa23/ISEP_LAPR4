package eapli.base.warehouse.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouse.domain.*;
import eapli.base.warehouse.persistence.WarehouseRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

import eapli.base.warehouse.domain.AGVDocks;
import eapli.base.warehouse.domain.Aisle;
import eapli.base.warehouse.domain.Roww;
import eapli.base.warehouse.domain.Warehouse;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AddJsonFileController {

    /**
     * The warehouse repository
     */
    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();

    /**
     * Creates a warehouse and saves it in the repository
     * @param file json file
     * @throws IOException
     * @throws ParseException
     */
    public void addJsonFile(String file) throws IOException, ParseException {
        try{
        Warehouse warehouse = WarehousefromJsonFile(file);
        warehouseRepository.save(warehouse);
        }catch (FileNotFoundException e){
        System.out.println("The file was not found");
        }
    }

    /**
     * Reads a json file and returns the warehouse in it
     * @param file json file
     * @return Warehouse
     * @throws IOException
     * @throws ParseException
     */
    private Warehouse WarehousefromJsonFile(String file) throws IOException, ParseException {
        //JSON parser object to parse read file
            Object ob = new JSONParser().parse(new FileReader(file));

        // typecasting ob to JSONObject
        JSONObject js = (JSONObject) ob;

        String name = (String) js.get("Warehouse");

        JSONArray arr = (JSONArray) js.get("Aisles");

        Set<Aisle> aisles = new HashSet<>();


        for (int i = 0; i < arr.size(); i++) {
            String post_id = arr.get(i).toString();
            post_id=post_id.replace("\"","");
            post_id=post_id.replace("{","");
            post_id=post_id.replace("}","");
            post_id=post_id.replace(","," ");
            post_id=post_id.replace(":"," ");
            post_id=post_id.replace("lsquare","\n");
            post_id=post_id.replace("wsquare","\n");
            post_id=post_id.replace(" ","\n");
            post_id=post_id.replace("]","\n]");
            post_id = post_id.replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            List<String> lines = IOUtils.readLines(new StringReader(post_id));
            int x=12;
            Set<Roww> rowws = new HashSet<>();
            long s;
            while(!Objects.equals(lines.get(x-1), "]")){
                Set<Shelf> shelves = new HashSet<>();
                for(int m=1;m<=Integer.parseInt(lines.get(x+8));m++){
                    s=m;
                    Shelf shelf = new Shelf(Long.parseLong(lines.get(x+3)),name,Long.parseLong(lines.get(9)),s);
                    shelves.add(shelf);
                };
                Roww roww = new Roww(Long.parseLong(lines.get(x+3)),name,Long.parseLong(lines.get(9)),Integer.parseInt(lines.get(x+5)),Integer.parseInt(lines.get(x+6)),Integer.parseInt(lines.get(x)),Integer.parseInt(lines.get(x+1)),shelves);
                rowws.add(roww);
                x=x+10;
            }
            Aisle aisle = new Aisle(name,Long.parseLong(lines.get(9)),Integer.parseInt(lines.get(x+1)),Integer.parseInt(lines.get(x+2)),Integer.parseInt(lines.get(6)),Integer.parseInt(lines.get(7)),Integer.parseInt(lines.get(1)),Integer.parseInt(lines.get(2)),lines.get(4), rowws);

            aisles.add(aisle);


        }

        JSONArray dock = (JSONArray) js.get("AGVDocks");

        List<AGVDocks> agvDocksarr = new ArrayList<>();

        for (int i=0; i<dock.size();i++){
            String post_id = dock.get(i).toString();
            post_id=post_id.replace("\"","");
            post_id=post_id.replace("{","");
            post_id=post_id.replace("}","");
            post_id=post_id.replace(","," ");
            post_id=post_id.replace(":"," ");
            post_id=post_id.replace("lsquare","\n");
            post_id=post_id.replace("wsquare","\n");
            post_id=post_id.replace(" ","\n");
            post_id = post_id.replaceAll("(?m)^\\s*$[\n\r]{1,}", "");
            List<String> lines = IOUtils.readLines(new StringReader(post_id));
            AGVDocks agvDocks  = new AGVDocks(lines.get(9),Integer.parseInt(lines.get(11)),Integer.parseInt(lines.get(12)),Integer.parseInt(lines.get(6)),Integer.parseInt(lines.get(7)),Integer.parseInt(lines.get(1)),Integer.parseInt(lines.get(2)),lines.get(4));

            agvDocksarr.add(agvDocks);
        }


        Long length = (Long) js.get("Length");
        Long width = (Long) js.get("Width");
        Long square = (Long) js.get("Square");
        String unit = (String) js.get("Unit");

        Warehouse warehouse = new Warehouse(name,length.intValue(),width.intValue(),square.intValue(),unit,aisles,agvDocksarr);

        return warehouse;

    }

}
