package eapli.base.product.domain;


import eapli.framework.domain.model.ValueObject;

import javax.naming.SizeLimitExceededException;
import javax.persistence.Embeddable;

@Embeddable
public class Volume implements ValueObject {

    /**
     * The volume
     */
    private double volume;

    /**
     * Creates an instance of Volume
     * @param volume the volume
     */
    public Volume(double volume) throws SizeLimitExceededException {
        checkVolume(volume);
        this.volume = volume;
    }

    /**
     * Creates an instance of Volume
     */
    protected Volume() {

    }

    /**
     * Check if volume is bigger than 0
     */
    private void checkVolume(double volume) throws SizeLimitExceededException {
        if(volume <=0){
            throw new SizeLimitExceededException();
        }
    }

    /**
     * Return the volume
     * @return the volume
     */
    public double volume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volume volume1 = (Volume) o;
        return Double.compare(volume1.volume, volume) == 0;
    }

}
