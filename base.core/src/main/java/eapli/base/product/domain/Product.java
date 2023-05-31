package eapli.base.product.domain;

import eapli.base.warehouse.domain.Roww;
import eapli.base.warehouse.domain.Shelf;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.naming.SizeLimitExceededException;
import javax.persistence.*;

@Entity
public class Product implements AggregateRoot<Long> {


    /**
     * The Product's generated ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The product's code
     */
    @Embedded
    @AttributeOverride(name = "code", column = @Column(name = "Code"))
    @Column(unique = true)
    private Code code;

    /**
     * The product's brand
     */
    @Embedded
    private Brand brand;

    /**
     * The product's category
     */
    @ManyToOne()
    @JoinColumn(name = "Category_id")
    private ProductCategory category;

    /**
     * The product's price without taxes
     */
    @Embedded
    @AttributeOverride(name = "price", column = @Column(name = "PriceWithouTaxes"))
    private Price priceWithoutTaxes;

    /**
     * The product's price with taxes
     */
    @Embedded
    @AttributeOverride(name = "price", column = @Column(name = "PriceWithTaxes"))
    private Price priceWithTaxes;

    /**
     * The product's barcode
     */
    @Embedded
    private Barcode barcode;

    /**
     * The product's production code
     */
    @Embedded
    @AttributeOverride(name = "code", column = @Column(name = "ProductionCode"))
    private Code productionCode;

    /**
     * The product's reference
     */
    @Embedded
    private Reference reference;

    /**
     * The product's technical description
     */
    private String technicalDescription;

    /**
     * The product's extended description
     */
    @Embedded
    private ExtendedDescription extendedDescription;

    /**
     * The product's short description
     */
    @Embedded
    private ShortDescription shortDescription;

    /**
     * The path of the product's photo
     */
    private String photo;

    /**
     * The rowID
     */
    @ManyToOne
    private Shelf shelfID;

    /**
     * If the product is available to be ordered
     */
    private boolean availability;

    /**
     * The product's volume
     */
    @Embedded
    private Volume volume;

    /**
     * The product's weight
     */
    @Embedded
    private Weight weight;

    /**
     * Creates an instance of Product
     * @param code Product's code
     * @param category Product's category
     * @param brand Product's brand
     * @param priceWithoutTaxes Product's price without taxes
     * @param priceWithTaxes Product's price with taxes
     * @param barcode Product's barode
     * @param productionCode Product's production code
     * @param reference Product's reference
     * @param shortDescription Product's short description
     * @param extendedDescription Product's extended description
     * @param photo Product's photo path
     * @param shelf Product's location
     * @param availability Product's availability
     * @param weight Product's weight
     * @param volume Product's volume
     * @throws SizeLimitExceededException if any business rule is broken
     */
    public Product(String code, ProductCategory category, String brand, double priceWithoutTaxes, double priceWithTaxes, String barcode, String productionCode, String reference, String shortDescription,String extendedDescription, String photo, Shelf shelf, boolean availability, double weight, double volume) throws SizeLimitExceededException {
        this.code = new Code(code);
        this.category = category;
        this.brand = new Brand(brand);
        this.priceWithoutTaxes = new Price(priceWithoutTaxes);
        this.priceWithTaxes = new Price(priceWithTaxes);
        this.barcode = new Barcode(barcode);
        this.productionCode = new Code(productionCode);
        this.reference = new Reference(reference);
        this.shortDescription = new ShortDescription(shortDescription);
        this.extendedDescription = new ExtendedDescription(extendedDescription);
        this.photo = photo;
        this.shelfID = shelf;
        this.availability = availability;
        this.weight = new Weight(weight);
        this.volume = new Volume(volume);
    }



    /**
     * Creates a instance of Product
     */
    protected Product() {

    }

    /**
     * Return the price without taxes
     * @return the price without taxes
     */
    public Price getPriceWithoutTaxes() {
        return priceWithoutTaxes;
    }

    /**
     * Return the brand
     * @return the brand
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Return the product category
     * @return the product category
     */
    public ProductCategory getCategory() {
        return category;
    }


    /**
     * Return the price with taxes
     * @return the price with taxes
     */
    public Price getPriceWithTaxes() {
        return priceWithTaxes;
    }


    /**
     * Return the volume
     * @return the volume
     */
    public Volume getVolume() {
        return volume;
    }

    /**
     * Return the technical description
     * @return the technical description
     */
    public String getTechnicalDescription() {
        return technicalDescription;
    }

    /**
     * Return the weight
     * @return the weight
     */
    public Weight getWeight() {
        return weight;
    }


    /**
     * Return the code
     * @return the code
     */
    public Code getCode() {
        return code;
    }

    public Shelf shelfID() {
        return shelfID;
    }

    /**
     * Set a new code
     * @param code the new code
     * @throws SizeLimitExceededException if the new code doesn't follow the rules
     */
    public void setCode(String code) throws SizeLimitExceededException {
        this.code = new Code(code);
    }


    /**
     * Set a new technical description
     * @param technicalDescription the new technical description
     */
    public void setTechnicalDescription(String technicalDescription) {
        this.technicalDescription = technicalDescription;
    }

    /**
     * Return the short description
     * @return the short description
     */
    public ShortDescription getShortDescription() {
        return shortDescription;
    }


    /**
     * Return the textual information about the product
     * @return the textual information about the product
     */
    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", shortDescription=" + shortDescription.description() +
                '}';
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
    public boolean sameAs(Object other) {
        if (!(other instanceof Product)) {
            return false;
        }

        final var that = (Product) other;
        if (this == that) {
            return true;
        }

        return (this.identity().equals(that.identity()) && this.code.equals(that.code) && this.brand.equals(that.brand) && this.category.equals(that.category)
                && this.priceWithoutTaxes.equals(that.priceWithoutTaxes) && this.priceWithTaxes.equals(that.priceWithTaxes)
                && this.barcode.equals(that.barcode) && this.productionCode.equals(that.productionCode) && this.reference.equals(that.reference)
                && this.shortDescription.equals(that.shortDescription) && this.extendedDescription.equals(that.extendedDescription)
                && this.photo.equals(that.photo) && this.shelfID.equals(that.shelfID) && this.availability == that.availability
                && this.volume.equals(that.volume) && this.weight.equals(that.weight));
    }

    @Override
    public Long identity() {
        return id;
    }
}
