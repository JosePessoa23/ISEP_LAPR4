package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.List;

@Embeddable
public class MultipleChoiceQuestion extends Question implements ValueObject {

    private List<String> answerslist;

    private int num_max_choices;

    private List<String> choosedAnswer;

    public MultipleChoiceQuestion(String question, int question_id, String type, List<String> answerslist, int num_max_choices) {
        super(question, question_id, type, "multiple-choice",answerslist);
        this.answerslist = answerslist;
        this.num_max_choices = num_max_choices;
    }

    protected MultipleChoiceQuestion() {

    }

    public List<String> answerslist() {
        return answerslist;
    }

    public List<String> choosedAnswer() {
        return choosedAnswer;
    }

    public int num_max_choices() {
        return num_max_choices;
    }

    public void setChoosedAnswer(List<String> choosedAnswer) {
        this.choosedAnswer = choosedAnswer;
    }
}
