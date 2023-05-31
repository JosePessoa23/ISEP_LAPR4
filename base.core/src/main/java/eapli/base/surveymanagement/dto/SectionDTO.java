package eapli.base.surveymanagement.dto;

public class SectionDTO {

    public int section_identification;

    public String section_title;

    public String section_description;

    public String obligatoriness;

    public String condition;

    public SectionDTO(int section_identification, String section_title, String section_description, String obligatoriness, String condition) {
        this.section_identification = section_identification;
        this.section_title = section_title;
        this.section_description = section_description;
        this.obligatoriness = obligatoriness;
        this.condition = condition;
    }
}
