package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.naming.SizeLimitExceededException;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Code implements ValueObject {

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
        boolean flag = true;
        for (int i=0;i< code.length();i++){
            if( Character.isAlphabetic(code.charAt(i))){
                for (i=0;i<code.length();i++){
                    if(checkNumeric(String.valueOf(code.charAt(i)))){
                        flag = false;
                    }
                }
            }
        }

        if(code.length() >15){
            flag =true;
        }

        if(flag){
            throw new SizeLimitExceededException();
        }
    }

    private boolean checkNumeric(String la){
        try {
            Integer.parseInt(la);
            return true;
        }catch (Exception e){
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
