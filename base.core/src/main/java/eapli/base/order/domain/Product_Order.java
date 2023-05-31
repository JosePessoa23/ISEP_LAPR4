package eapli.base.order.domain;

import eapli.base.customer.domain.Customer;
import eapli.base.order.dto.Product_OrderDTO;
import eapli.base.order.dto.Product_OrderDTOComplete;
import eapli.base.product.domain.Product;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Product_Order implements AggregateRoot<Integer> {

    /**
     * The order's generated ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The order's registration time
     */
    @Temporal(TemporalType.TIME)
    private Date registration_time;

    /**
     * The order's shipment method cost
     */
    @Embedded
    private Shipment_method_cost shipment_method_cost;

    /**
     * The order's product list
     */
    @ManyToMany()
    @JoinColumn(name = "ProductID")
    private List<Product> productList = new ArrayList<>();

    /**
     * The order's quantity list
     */
    @ElementCollection
    private List<Integer> quantitylist = new ArrayList<>();

    /**
     * The order's customer
     */
    @ManyToOne()
    @JoinColumn(name = "CustomertID")
    private Customer customer;

    /**
     * The order's total amount
     */
    @Embedded
    private Total_amount totalAmount;

    /**
     * The order's payment confirmation
     */
    @Embedded
    private Payment_Confirmation payment_confirmation;

    /**
     * The order's payment method
     */
    private String payment_method;

    /**
     * The order's delivering address
     */
    @Embedded
    @AttributeOverride(name = "address", column = @Column(name = "Delivering_Address"))
    private Address deliveringAddress;

    /**
     * The order's billing address
     */
    @Embedded
    @AttributeOverride(name = "address", column = @Column(name = "Billing_Address"))
    private Address billingAddress;

    /**
     * The order's state
     */
    @Enumerated(EnumType.STRING)
    private State state;

    /**
     * The order's code
     */
    private String salesClerkID;

    /**
     * The order's source of information
     */
    private String sourceOfInformation;


    /**
     * Creates an instance of Product_Order.
     * @param registration_time
     * @param shipment_method
     * @param payment
     * @param order_productList
     * @param quantitylist
     * @param bilingaddress
     * @param deliveringaddress
     * @param customer
     * @param sourceofInformation
     * @param salesClerkID
     */
    public Product_Order(Date registration_time, String shipment_method, String payment, List<Product> order_productList, List<Integer> quantitylist, String bilingaddress, String deliveringaddress, Customer customer, String sourceofInformation, String salesClerkID) {
        this.registration_time = registration_time;
        this.productList=order_productList;
        this.quantitylist = quantitylist;
        this.shipment_method_cost = calculateTotalweightAndTotalVolume(shipment_method);
        this.customer = customer;
        this.totalAmount = calculateTotalAmount();
        this.payment_confirmation = new Payment_Confirmation();
        this.payment_method = payment;
        this.billingAddress = new Address(bilingaddress);
        this.deliveringAddress = new Address(deliveringaddress);
        this.salesClerkID = salesClerkID;
        this.sourceOfInformation = sourceofInformation;
        this.state = State.Payment_pending;
    }

    public Product_OrderDTO toDTO(){
        return new Product_OrderDTO(this.id,this.registration_time);
    }

    public Product_OrderDTOComplete toDTOComplete(){
        return new Product_OrderDTOComplete(this.id,this.registration_time,this.customer.getName().name(),this.totalAmount.totalAmountWithTaxes(),this.shipment_method_cost.weight(),this.shipment_method_cost.volume());
    }

    /**
     * Calculates the order's total amount
     * @return
     */
    private Total_amount calculateTotalAmount(){
        int quantity;
        double sumWithTaxes=0;
        double sumWithoutTaxes =0;
        for (int i =0; i<productList.size();i++){
            quantity = quantitylist.get(i);
            sumWithTaxes += productList.get(i).getPriceWithTaxes().price() * quantity;
            sumWithoutTaxes += productList.get(i).getPriceWithoutTaxes().price() * quantity;
        }
        return new Total_amount(sumWithTaxes,sumWithoutTaxes);
    }

    /**
     * Calculates the order's total weight and total volume
     * @param shipment_method
     * @return
     */
    private Shipment_method_cost calculateTotalweightAndTotalVolume(String shipment_method){
        int quantity;
        double totalweight=0;
        double totalvolume =0;
        for (int i =0; i<productList.size();i++){
            quantity = quantitylist.get(i);
            totalvolume += productList.get(i).getVolume().volume() * quantity;
            totalweight += productList.get(i).getWeight().weight() * quantity;
        }
        return new Shipment_method_cost(shipment_method,totalweight,totalvolume);

    }

    private void setState(State state) {
        this.state = state;
    }

    public void paid() {
        this.payment_confirmation = new Payment_Confirmation("Pago");
        setState(State.To_be_prepared);
    }

    /**
     * Set the state to Being_prepared_on_the_warehouse
     */
    public void beingPrepared(){
        setState(State.Being_prepared_on_the_warehouse);
    }

    /**
     * Set the state to Ready_for_packaging
     */
    public void readyForPacking(){
        setState(State.Ready_for_packaging);
    }

    /**
     * Set the state to Dispatched
     */
    public void dispatched(){
        setState(State.Dispatched);
    }

    /**
     * Set the state to Dispatched
     */
    public void delivered(){
        setState(State.Delivered_by_carrier);
    }

    /**
     * Return the order´s volume
     * @return the order´s volume
     */
    public double volume(){
        return shipment_method_cost.volume();
    }

    /**
     * Return the order´s weight
     * @return the order´s weight
     */
    public double weight(){
        return shipment_method_cost.weight();
    }

    public List<Product> productList() {
        return productList;
    }

    /**
     * Creates an instance of Product_Order.
     */
    protected Product_Order() {
    }


    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }


    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Product_Order)) {
            return false;
        }

        final var order = (Product_Order) other;
        if (this == order) {
            return true;
        }

        return id == order.id && registration_time.equals( order.registration_time)
                && shipment_method_cost.equals( order.shipment_method_cost)
                && customer.equals( order.customer)
                && totalAmount.equals( order.totalAmount)
                && Objects.equals(deliveringAddress, order.deliveringAddress)
                && Objects.equals(billingAddress, order.billingAddress)  && Objects.equals(salesClerkID, order.salesClerkID)
                && Objects.equals(sourceOfInformation, order.sourceOfInformation);
    }

    @Override
    public Integer identity() {return id;}
}
