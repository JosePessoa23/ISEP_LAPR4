package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Embeddable
public class Question implements ValueObject {

    private String question;

    private int question_id;

    private String questionObligatoriness;

    private String type;

    private String answerllist;

    public Question(String question, int question_id, String questionObligatoriness, String type) {
        this.question = question;
        this.question_id = question_id;
        this.questionObligatoriness = questionObligatoriness;
        this.type=type;
        this.answerllist = "";
    }

    public Question(String question, int question_id, String questionObligatoriness, String type, String answerlist) {
        this.question = question;
        this.question_id = question_id;
        this.questionObligatoriness = questionObligatoriness;
        this.type = type;
        this.answerllist = answerlist;
    }

    public Question(String question, int question_id, String questionObligatoriness, String type, List<String> answerlist) {
        StringBuilder la = new StringBuilder();
        for (String le: answerlist) {
            la.append(le).append("\n");
        }
        this.question = question;
        this.question_id = question_id;
        this.questionObligatoriness = questionObligatoriness;
        this.type = type;
        this.answerllist = la.toString();
    }


    protected Question() {
    }

    public String type() {
        return type;
    }

    public String question() {
        return question;
    }

    @Override
    public String toString() {
        return "Question:" +
                "question= " + question +
                " question_id=" + question_id +
                "\nquestionType=" + type ;
    }

    public List<String> answerlist() {
        String[] la = answerllist.split("\n");
        List<String> list = new ArrayList<>(Arrays.asList(la));
        return list;
    }

    public String obligatoriness() {
        return questionObligatoriness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return question_id == question1.question_id && question.equals(question1.question) && type.equals(question1.type);
    }
}

