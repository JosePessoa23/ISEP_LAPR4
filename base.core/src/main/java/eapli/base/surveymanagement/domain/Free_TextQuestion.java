package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Free_TextQuestion extends Question implements ValueObject {

    private String answer;

    public Free_TextQuestion(String question, int question_id, String type) {
        super(question, question_id, type, "free-text");
    }

    protected Free_TextQuestion() {
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
