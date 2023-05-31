package eapli.base.warehouse.domain;

import eapli.base.agv.domain.AGV;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AGVDocks {

    /**
     * The AGV Docks id
     */
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    /**
     * Where the AGV Docks begin
     */
    int beginl;
    /**
     * Where the AGV Docks begin
     */
    int beginw;
    /**
     * Where the AGV Docks end
     */
    int endl;
    /**
     * Where the AGV Docks end
     */
    int endw;
    /**
     * The AGV Docks depth
     */
    int depthl;
    /**
     * The AGV Docks depth
     */
    int depthw;
    /**
     * The AGV Docks accessibility
     */
    String accessibility;
    /**
     * The AGV Docks AGV
     */
    @OneToOne
    AGV agv;

    /**
     * Creates an instance of AGV Docks
     */
    public AGVDocks() {
    }

    /**
     * Creates an instance of AGV Docks
     * @param id AGV Docks id
     * @param beginl Where AGV Docks begin
     * @param beginw Where AGV Docks begin
     * @param endl Where AGV Docks end
     * @param endw Where AGV Docks end
     * @param depthl AGV Docks depth
     * @param depthw AGV Docks depth
     * @param accessibility AGV Docks accessibility
     */
    public AGVDocks(String id, int beginl, int beginw, int endl, int endw, int depthl, int depthw, String accessibility) {
        this.id = id;
        this.beginl = beginl;
        this.beginw = beginw;
        this.endl = endl;
        this.endw = endw;
        this.depthl = depthl;
        this.depthw = depthw;
        this.accessibility = accessibility;
    }

    public int endw() {
        return endw;
    }

    public int endl() {
        return endl;
    }

    public int beginw() {
        return beginw;
    }

    public int beginl() {
        return beginl;
    }

    public String accessibility() {
        return accessibility;
    }



    /**
     * Gets the AGV Docks id
     * @return AGV Docks id
     */
    public String getId() {
        return id;
    }

    public AGV agv(){
        return agv;
    }

    /**
     * Sets the AGV Docks AGV
     * @param agv AGV Docks AGV
     */
    public void setAgv(AGV agv) {
        this.agv = agv;
    }
}
