package eapli.base.agv.domain;

import eapli.framework.domain.model.ValueObject;

import javax.naming.SizeLimitExceededException;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Model implements ValueObject {
    /**
     * The AGV Model
     */
    private String model;

    /**
     * Creates an instance of the AGV Model
     */
    protected Model() {
    }

    /**
     * Creates an instance of the AGV Model
     * @param model the AGV Model
     */
    public Model(String model) throws SizeLimitExceededException {
        checkmodel(model);
        this.model = model;
    }

    /**
     * Checks the model's business rules
     * @param model The AGV Model
     * @throws SizeLimitExceededException
     */
    private void checkmodel(String model) throws SizeLimitExceededException {
        if(model.length()>50){
            throw new SizeLimitExceededException();
        }
    }

    /**
     * Gets the AGV Model
     * @return the AGV Model
     */
    public String model() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model1 = (Model) o;
        return Objects.equals(model, model1.model);
    }


}
