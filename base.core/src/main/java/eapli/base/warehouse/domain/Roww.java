package eapli.base.warehouse.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Roww {
    /**
     * The row's id
     */
    @EmbeddedId
    private RowPK Id;
    /**
     * Where the row begins
     */
    int beginl;
    /**
     * Where the row begins
     */
    int beginw;
    /**
     * Where the row ends
     */
    int endl;
    /**
     * Where the row ends
     */
    int endw;
    /**
     * The number of shelves per row
     */
    @OneToMany(cascade = CascadeType.ALL)
    Set<Shelf> shelves =new HashSet<>();

    /**
     * Creates a Row instance
     */
    public Roww() {
    }

    /**
     * Creates a row instance
     * @param rowid row's id
     * @param warehouseid Warehouse id
     * @param aisleid Aisle id
     * @param beginl Where the row begins
     * @param beginw Where the row begins
     * @param endl Where the row ends
     * @param endw Where the row ends
     * @param shelves number of shelves per row
     */
    public Roww(Long rowid, String warehouseid, Long aisleid, int beginl, int beginw, int endl, int endw, Set<Shelf> shelves) {
        Id = new RowPK(aisleid,warehouseid,rowid);
        this.beginl = beginl;
        this.beginw = beginw;
        this.endl = endl;
        this.endw = endw;
        this.shelves = shelves;
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

    public RowPK id() {
        return Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roww roww = (Roww) o;
        return Objects.equals(Id, roww.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, beginl, beginw, endl, endw, shelves);
    }
}
