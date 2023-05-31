package eapli.base.warehouse.domain;

import org.springframework.scripting.bsh.BshScriptEvaluator;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ShelfPK implements Serializable {
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
     * The Shelf's id
     */
    private Long shelfid;

    /**
     * Creates an instance of RowPK
     */
    protected ShelfPK() {

    }

    /**
     * Creates an instance of RowPK
     * @param aisleid Aisle id
     * @param warehouseid warehouse id
     * @param rowid Row's id
     */
    public ShelfPK(Long aisleid, String warehouseid, Long rowid,Long shelfid) {
        this.aisleid = aisleid;
        this.warehouseid = warehouseid;
        this.rowid = rowid;
        this.shelfid= shelfid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShelfPK shelfPK = (ShelfPK) o;
        return Objects.equals(aisleid, shelfPK.aisleid) && Objects.equals(warehouseid, shelfPK.warehouseid) && Objects.equals(rowid, shelfPK.rowid) && Objects.equals(shelfid, shelfPK.shelfid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aisleid, warehouseid, rowid, shelfid);
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
    /**
     * Gets The Row's id
     * @return Row's id
     */
    public Long shelfid() {
        return shelfid;
    }
}
