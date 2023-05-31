package eapli.base.warehouse.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RowPK implements Serializable {
    /**
     * The Aisle id
     */
    private Long aisleid;
    /**
     * The Warehouse id
     */
    private String warehouseid;
    /**
     * The Row's id
     */
    private Long rowid;

    /**
     * Creates an instance of RowPK
     */
    public RowPK() {

    }

    /**
     * Creates an instance of RowPK
     * @param aisleid Aisle id
     * @param warehouseid warehouse id
     * @param rowid Row's id
     */
    public RowPK(Long aisleid, String warehouseid, Long rowid) {
        this.aisleid = aisleid;
        this.warehouseid = warehouseid;
        this.rowid = rowid;
    }


    /**
     * Gets The Aisle id
     * @return Aisle id
     */
    public Long aisleid() {
        return aisleid;
    }
    /**
     * Gets The Warehouse id
     * @return Warehouse id
     */
    public String warehouseid() {
        return warehouseid;
    }

    /**
     * Gets The Row's id
     * @return Row's id
     */
    public Long rowid() {
        return rowid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RowPK rowPK = (RowPK) o;
        return Objects.equals(aisleid, rowPK.aisleid) && Objects.equals(warehouseid, rowPK.warehouseid) && Objects.equals(rowid, rowPK.rowid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aisleid, warehouseid, rowid);
    }
}
