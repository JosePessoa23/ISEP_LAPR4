package eapli.base.warehouse.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AislePK implements Serializable {
    /**
     * The Aisle id
     */
    private Long aisleid;
    /**
     * The warehouse id
     */
    private String warehouseid;

    /**
     * Creates an instance of AislePK
     */
    public AislePK() {

    }

    /**
     * Creates an instance of AislePK
     * @param aisleid Aisle id
     * @param warehouseid warehouse id
     */
    public AislePK(Long aisleid, String warehouseid) {
        this.aisleid = aisleid;
        this.warehouseid = warehouseid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AislePK aislePK = (AislePK) o;
        return Objects.equals(aisleid, aislePK.aisleid) && Objects.equals(warehouseid, aislePK.warehouseid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aisleid, warehouseid);
    }
}
