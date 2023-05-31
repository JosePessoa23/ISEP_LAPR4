package eapli.base.warehouse.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Aisle {
    /**
     * The Aisle's id
     */
    @EmbeddedId
    private AislePK id;
    /**
     * Where the Aisle begins
     */
    int beginl;
    /**
     * Where the Aisle begins
     */
    int beginw;
    /**
     * Where the Aisle ends
     */
    int endl;
    /**
     * Where the Aisle ends
     */
    int endw;
    /**
     * The Aisle's depth
     */
    int depthl;
    /**
     * The Aisle's depth
     */
    int depthw;
    /**
     * The Aisle's accessibility
     */
    String accessibility;
    /**
     * The Aisle's rows
     */
    @OneToMany(cascade = CascadeType.ALL)
    Set<Roww> roww =new HashSet<>();

    /**
     * Creates an instance of Aisle
     */
    public Aisle() {
    }

    /**
     * Creates an instance of Aisle
     * @param warehouseid Warehouse id
     * @param aisleid Aisle id
     * @param beginl Where the Aisle begins
     * @param beginw Where the Aisle begins
     * @param endl Where the Aisle ends
     * @param endw Where the Aisle ends
     * @param depthl Aisle depth
     * @param depthw Aisle depth
     * @param accessibility Aisle accessibility
     * @param roww Aisle rows
     */
    public Aisle(String warehouseid,Long aisleid, int beginl, int beginw, int endl, int endw, int depthl, int depthw, String accessibility, Set<Roww> roww) {
        this.id = new AislePK(aisleid,warehouseid);
        this.beginl = beginl;
        this.beginw = beginw;
        this.endl = endl;
        this.endw = endw;
        this.depthl = depthl;
        this.depthw = depthw;
        this.accessibility = accessibility;
        this.roww = roww;
    }

    public int beginl() {
        return beginl;
    }

    public int beginw() {
        return beginw;
    }

    public int endl() {
        return endl;
    }

    public int endw() {
        return endw;
    }

    public int depthw() {
        return depthw;
    }

    public String accessibility() {
        return accessibility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aisle aisle = (Aisle) o;
        return Objects.equals(id, aisle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, beginl, beginw, endl, endw, depthl, depthw, accessibility, roww);
    }
}
