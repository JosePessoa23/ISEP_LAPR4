package eapli.base.agv.dto;


import eapli.base.agv.domain.Identification;
import eapli.base.agv.domain.Model;
import eapli.base.agv.domain.ShortDescription;

public class AGVDTO {

    public String id;
    public String shortDescription;
    public String model;

    public AGVDTO(String id, String shortDescription, String model) {
        this.id = id;
        this.shortDescription = shortDescription;
        this.model = model;
    }

    @Override
    public String toString() {
        return "AGVDTO{" +
                "id='" + id + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
