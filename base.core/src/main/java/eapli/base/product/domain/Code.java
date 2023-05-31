package eapli.base.product.domain;

import eapli.framework.domain.model.ValueObject;

import javax.naming.SizeLimitExceededException;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Code implements ValueObject {


    /**
     * The code
     */
    private String code;

    /**
     * Creates an instance of Code
     * @param code the code
     */
    public Code(String code) throws SizeLimitExceededException {
        checkCode(code);
        this.code = code;
    }

    /**
     * Creates an instance of Code
     */
    protected Code() {

    }

    /**
     * Return the code
     * @return the code
     */
    public String code() {
        return code;
    }


    /**
     * Check the code business rules
     * @param code Product's barcode
     * @throws SizeLimitExceededException if rules are broken
     */
    private void checkCode(String code) throws SizeLimitExceededException {
        if(code.length()>23|| !checkRegularExpression(code)){
            throw new SizeLimitExceededException();
        }
    }

    /**
     * Check if the code follow the regular expression
     * @param code Product's barcode
     * @throws SizeLimitExceededException if rules are broken
     */
    private boolean checkRegularExpression(String code){ //Regular expression: 2 letters followed by n chars
        if(Character.isAlphabetic(code.charAt(0)) && Character.isAlphabetic(code.charAt(1))){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Code code1 = (Code) o;
        return Objects.equals(code, code1.code);
    }

}
