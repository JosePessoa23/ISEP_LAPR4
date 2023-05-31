package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.List;

@Embeddable
public class SingleChoiceQuestion extends Question implements ValueObject {

    private List<String> answerslist;

    private String choosedAnswer;

    public SingleChoiceQuestion(String question, int question_id, String type, List<String> answerslist) {
        super(question, question_id, type, "single-choice",answerslist);
        this.answerslist = answerslist;
    }

    protected SingleChoiceQuestion() {
    }

    public List<String> getAnswerslist() {
        return answerslist;
    }

    public String getChoosedAnswer() {
        return choosedAnswer;
    }

    public void setChoosedAnswer(String choosedAnswer) {
        this.choosedAnswer = choosedAnswer;
    }
}
