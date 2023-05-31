package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class NumericQuestion extends Question implements ValueObject {

    private int answer;

    public NumericQuestion(String question, int question_id, String type) {
        super(question, question_id, type, "numeric");
    }

    public NumericQuestion() {
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
