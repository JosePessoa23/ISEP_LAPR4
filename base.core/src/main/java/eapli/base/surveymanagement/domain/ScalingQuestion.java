package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.List;

@Embeddable
public class ScalingQuestion extends Question implements ValueObject {

    private List<String> answerslist;

    private List<String> choosedAnswer;

    public ScalingQuestion(String question, int question_id, String type, List<String> answerslist) {
        super(question, question_id, type, "scalling options",answerslist);
        this.answerslist = answerslist;
    }

    protected ScalingQuestion() {

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
