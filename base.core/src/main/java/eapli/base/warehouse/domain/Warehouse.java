package eapli.base.warehouse.domain;

import eapli.base.agv.domain.AGV;
import eapli.base.order.domain.Product_Order;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Warehouse implements AggregateRoot<Long> {

    /**
     * The Warehouse id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The Warehouse Name
     */
    @Column(unique=true)
    String warehouse;
    /**
     * The Warehouse length
     */
    int length;
    /**
     * The Warehouse width
     */
    int width;
    /**
     * The Warehouse size in m2
     */
    int square;
    /**
     * The Warehouse unit
     */
    String unit;
    /**
     * The Warehouse aisles
     */
    @OneToMany(cascade = CascadeType.ALL)
    Set<Aisle> aisle= new HashSet<>();
    /**
     * The Warehouse agv docks
     */
    @OneToMany(cascade = CascadeType.ALL)
    List<AGVDocks> agvDocks= new ArrayList<>();

    /**
     * The orders to be prepared
     */
    @OneToMany
    private List<Product_Order> orders = new ArrayList<>();

    /**
     * Creates a instance of Warehouse
     */
    public Warehouse() {
    }

    /**
     * Creates a instance of Warehouse
     * @param warehouse Warehouse id
     * @param length Warehouse length
     * @param width Warehouse width
     * @param square Warehouse size in m2
     * @param unit Warehouse unit
     * @param aisle Warehouse aisles
     * @param agvDocks Warehouse AGVDocks
     */
    public Warehouse(String warehouse, int length, int width, int square, String unit, Set<Aisle> aisle, List<AGVDocks> agvDocks) {
        this.warehouse = warehouse;
        this.length = length;
        this.width = width;
        this.square = square;
        this.unit = unit;
        this.aisle = aisle;
        this.agvDocks = agvDocks;
    }

    /**
     * Substitutes one of the AGV docks
     * @param agvDock AGV dock
     */
    public void setaddAgvDocks(AGVDocks agvDock) {
        for (int i=0;i<agvDocks.size();i++){
            if (Objects.equals(agvDocks.get(i).getId(), agvDock.getId())){
                agvDocks.set(i,agvDock);
            }
        }
    }

    public List<Product_Order> getOrders() {
        return orders;
    }

    /**
     * Return the next order on the queue
     * @return the next order on the queue
     */
    public Product_Order getNextOrder(){
        if(orders.size()==0){
            return null;
        }
        Product_Order order = orders.get(0);
        orders.remove(order);
        return order;
    }

    public Product_Order getNextOrderWithoutRemove(){
        if(orders.size()==0){
            return null;
        }
        Product_Order order = orders.get(0);
        return order;
    }

    /**
     * Add a order ready to be prepared to the queue
     * @param order
     */
    public void addOrderToBePrepared(Product_Order order){
        orders.add(order);
    }

    /**
     * Return the textual information about the Warehouse
     * @return the textual information about the Warehouse
     */
    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouse='" + warehouse + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", square=" + square +
                ", unit='" + unit + '\'' +
                ", aisle=" + aisle +
                '}';
    }

    public int length() {
        return length;
    }

    public int width() {
        return width;
    }

    public int square() {
        return square;
    }

    public Set<Aisle> aisles() {
        return aisle;
    }

    public List<AGVDocks> agvDocks() {
        return agvDocks;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Warehouse)) {
            return false;
        }

        final var that = (Warehouse) other;
        if (this == that) {
            return true;
        }

        return (this.identity().equals(that.identity()) && this.aisle.equals(that.aisle) && this.agvDocks.equals(that.agvDocks));
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }
}
