package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.List;

@Embeddable
public class SortingQuestion extends Question implements ValueObject {

    private List<String> answerslist;

    private List<String> choosedAnswer;

    public SortingQuestion(String question, int question_id, String type, List<String> answerslist) {
        super(question, question_id, type, "sorting options",answerslist);
        this.answerslist = answerslist;
    }

    protected SortingQuestion() {

    }

    public List<String> answerslist() {
        return answerslist;
    }

    public List<String> choosedAnswer() {
        return choosedAnswer;
    }

    public void setChoosedAnswer(List<String> choosedAnswer) {
        this.choosedAnswer = choosedAnswer;
    }
}
