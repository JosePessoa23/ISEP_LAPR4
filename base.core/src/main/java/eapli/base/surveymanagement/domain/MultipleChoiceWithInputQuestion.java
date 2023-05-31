package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.List;

@Embeddable
public class MultipleChoiceWithInputQuestion extends Question implements ValueObject {

    private List<String> answerslist;

    private List<String> choosedAnswer;

    private int num_max_choices;

    private String input;

    public MultipleChoiceWithInputQuestion(String question, int question_id, String type, List<String> answerslist, int num_max_choices) {
        super(question, question_id, type, "multiple-choice with input value",answerslist);
        this.answerslist = answerslist;
        this.num_max_choices = num_max_choices;
    }

    protected MultipleChoiceWithInputQuestion() {
    }

    public List<String> getAnswerslist() {
        return answerslist;
    }

    public List<String> getChoosedAnswer() {
        return choosedAnswer;
    }

    public int num_max_choices() {
        return num_max_choices;
    }

    public String getInput() {
        return input;
    }

    public void setChoosedAnswer(List<String> choosedAnswer) {
        this.choosedAnswer = choosedAnswer;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
