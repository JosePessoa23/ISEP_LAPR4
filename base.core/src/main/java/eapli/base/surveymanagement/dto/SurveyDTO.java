package eapli.base.surveymanagement.dto;


public class SurveyDTO {


    public Long id;

    public String code;

    public String title;
    public String welcomeMessage;
    public String survey_condition;

    public SurveyDTO(Long id, String code, String title, String welcomeMessage, String survey_condition) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.welcomeMessage = welcomeMessage;
        this.survey_condition = survey_condition;
    }

    @Override
    public String toString() {
        return "Survey:" +
                "id=" + id +
                " code=" + code +
                "\ntitle='" + title ;
    }
}
