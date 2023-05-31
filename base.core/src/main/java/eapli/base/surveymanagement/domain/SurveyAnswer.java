package eapli.base.surveymanagement.domain;

import eapli.base.customer.domain.Customer;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Map;

@Entity
public class SurveyAnswer implements AggregateRoot<Long> {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Survey survey;

    @ElementCollection
    private Map<Question, String> answers;

    public SurveyAnswer(Customer customer, Survey survey, Map<Question, String> answers){
        this.customer = customer;
        this.survey = survey;
        this.answers = answers;
    }

    protected SurveyAnswer(){

    }

    public Map<Question, String> answers() {
        return answers;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }
}
