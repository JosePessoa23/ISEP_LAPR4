package eapli.base.surveymanagement.domain;

import eapli.base.surveymanagement.dto.SurveyDTO;
import eapli.framework.domain.model.AggregateRoot;

import javax.naming.SizeLimitExceededException;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Survey implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Column(unique = true)
    private Code code;

    @Temporal(TemporalType.TIME)
    private Date finalDate;

    private String title;
    private String welcomeMessage;
    private String survey_condition;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Section> sectionsList;

    public Survey(String code, Date finalDate, String title, String welcomeMessage,String survey_condition, List<Section> sectionsList) throws SizeLimitExceededException {
        this.code = new Code(code);
        this.finalDate = finalDate;
        this.title = title;
        this.welcomeMessage = welcomeMessage;
        this.survey_condition = survey_condition;
        this.sectionsList = sectionsList;
    }

    protected Survey() {
    }

    public Code code() {
        return code;
    }

    public Date finalDate() {
        return finalDate;
    }

    public String title() {
        return title;
    }

    public String welcomeMessage() {
        return welcomeMessage;
    }

    public String survey_condition() {
        return survey_condition;
    }

    public List<Section> sectionsList() {
        return sectionsList;
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Survey survey = (Survey) other;
        return Objects.equals(id, survey.id) && Objects.equals(finalDate, survey.finalDate)
                && Objects.equals(title, survey.title) && Objects.equals(welcomeMessage, survey.welcomeMessage)
                && Objects.equals(survey_condition, survey.survey_condition) ;
    }

    public SurveyDTO toDTO(){
        return new SurveyDTO(id,code.code(),title,welcomeMessage,survey_condition);
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public String toString() {
        return "Survey:" +
                " code=" + code +
                " title=" + title ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Survey survey = (Survey) o;
        return Objects.equals(id, survey.id) && Objects.equals(code, survey.code);
    }

}
