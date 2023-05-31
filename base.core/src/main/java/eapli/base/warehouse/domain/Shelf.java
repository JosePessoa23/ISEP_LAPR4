package eapli.base.warehouse.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Shelf {
    /**
     * The Shelf's id
     */
    @EmbeddedId
    private ShelfPK Id;


    /**
     * Creates a Shelf instance
     */
    protected Shelf() {
    }

    /**
     * Creates a row instance
     * @param rowid row's id
     * @param warehouseid Warehouse id
     * @param aisleid Aisle id
     * @param shelfid Shelf id
     */
    public Shelf(Long rowid, String warehouseid, Long aisleid,Long shelfid) {
        Id = new ShelfPK(aisleid,warehouseid,rowid,shelfid);
    }

    public ShelfPK id() {
        return Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shelf shelf = (Shelf) o;
        return Objects.equals(Id, shelf.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
