package eapli.base.customer.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Embeddable
public class BirthDate implements ValueObject {
    private String birthDate;

    public BirthDate(String birthDate){
        checkBirthDate(birthDate);
        this.birthDate=birthDate;
    }

    protected BirthDate(){
    }

    public String birthDate() {
        return this.birthDate;
    }

    private void checkBirthDate(String birthDate){
        if (!birthDate.isEmpty()){

            SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
            data.setLenient(false);

            try {
                Date javaDate = data.parse(birthDate);
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
                cal.setTime(javaDate);
                int year = cal.get(Calendar.YEAR);
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);

                if (year > currentYear || year <= (currentYear - 150))
                    throw new IllegalArgumentException("Birth date is incorrect.");

            } catch (ParseException e) {

                throw new IllegalArgumentException("Birth date is incorrect.");
            }
        }
    }
}
