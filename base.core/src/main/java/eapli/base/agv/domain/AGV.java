package eapli.base.agv.domain;

import eapli.base.agv.dto.AGVDTO;
import eapli.base.product.domain.Product;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class AGV implements AggregateRoot<Long> {

    /**
     * The AGV Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The AGV Identification
     */
    @Embedded
    @Column(unique=true)
    private Identification identification;
    /**
     * The AGV Short Description
     */
    @Embedded
    private ShortDescription shortDescription;
    /**
     * The AGV Model
     */
    @Embedded
    private Model model;
    /**
     * The AGV Maximum Weight
     */
    @Embedded
    private MaximumWeight maximumWeight;
    /**
     * The AGV Maximum Volume
     */
    @Embedded
    private MaximumVolume maximumVolume;
    /**
     * The AGV Base Location
     */
    private String baseLocation;
    /**
     * The AGV Status
     */
    @Embedded
    private Autonomy autonomy;
    /**
     * The AGV Current Task
     */
    @Enumerated(EnumType.STRING)
    private CurrentTask currentTask;
    /**
     * The AGV speed in squares/seconds
     */
    private int agvSpeed;

    /**
     * Creates an instance of AGV
     */
    protected AGV() {

    }

    /**
     * Creates an instance of AGV
     * @param identification The AGV ID
     * @param shortDescription The AGV Short Description
     * @param model The AGV Model
     * @param maximumWeight The AGV Maximum Weight
     * @param maximumVolume The AGV Maximum Volume
     * @param baseLocation The AGV Base Location
     * @param autonomy The AGV Status
     */
    public AGV(Identification identification, ShortDescription shortDescription, Model model, MaximumWeight maximumWeight, MaximumVolume maximumVolume, String baseLocation, Autonomy autonomy, int agvSpeed){
        this.identification = identification;
        this.shortDescription = shortDescription;
        this.model = model;
        this.maximumWeight = maximumWeight;
        this.maximumVolume = maximumVolume;
        this.baseLocation = baseLocation;
        this.autonomy = autonomy;
        this.currentTask = CurrentTask.FREE;
        this.agvSpeed = agvSpeed;
    }

    public AGVDTO toDTO(){
        return new AGVDTO(this.identification.id(),this.shortDescription.shortDescription(),this.model.model());
    }

    public Identification identification(){
        return identification;
    }


    /**
     * Change the current task of the agv to OCCUPIED_SERVING
     */
    public void occupyAGV(){
        this.currentTask = CurrentTask.OCCUPIED_SERVING;
    }

    /**
     * Change the current task of the agv to FREE
     */
    public void freeAGV(){
        this.currentTask = CurrentTask.FREE;
    }


    /**
     * Return the textual information about the AGV
     * @return the textual information about the AGV
     */
    @Override
    public String toString() {
        return "AGV{" +
                "id=" + identification +
                ", shortDescription=" + shortDescription +
                ", model=" + model +
                ", maximumWeight=" + maximumWeight +
                ", maximumVolume=" + maximumVolume +
                ", baseLocation=" + baseLocation +
                ", status=" + autonomy +
                ", currentTask=" + currentTask +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof AGV)) {
            return false;
        }

        final var that = (AGV) other;
        if (this == that) {
            return true;
        }

        return (this.identity().equals(that.identity()) && this.currentTask.equals(that.currentTask) && this.autonomy.equals(that.autonomy) && this.model.equals(that.model)
                && this.identification.equals(that.identification) && this.maximumVolume.equals(that.maximumVolume)
                && this.maximumWeight.equals(that.maximumWeight) && this.shortDescription.equals(that.shortDescription));
    }

    public String currentTask(){
        return currentTask.toString();
    }

    public int agvSpeed(){
        return agvSpeed;
    }

    @Override
    public boolean equals(Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public Long identity() {
        return id;
    }
}
