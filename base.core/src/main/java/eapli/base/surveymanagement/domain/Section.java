package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.util.List;

@Entity
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long section_id;

    private int section_identification;

    private String section_title;

    private String section_description;

    private String obligatoriness;

    private String condition;

    @ElementCollection
    private List<Question> questionList;

    public Section(int section_identification, String section_title, String section_description, String obligatoriness,String condition, List<Question> questionList) {
        this.section_identification = section_identification;
        this.section_title = section_title;
        this.section_description = section_description;
        this.obligatoriness = obligatoriness;
        this.condition = condition;
        this.questionList = questionList;
    }

    protected Section() {
    }

    public List<Question> questionList() {
        return questionList;
    }

    public String obligatoriness() {
        return obligatoriness;
    }

    public int section_identification() {
        return section_identification;
    }

    public String section_description() {
        return section_description;
    }

    @Override
    public String toString() {
        return "Section:" +
                " section_identification=" + section_identification +
                " section_title='" + section_title +
                "\nsection_description=" + section_description +
                " obligatoriness=" + obligatoriness ;
    }
}
