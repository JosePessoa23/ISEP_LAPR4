package eapli.base.surveymanagement.application.controller;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.surveymanagement.application.grammar.Grammar;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.Section;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.dto.SectionDTO;
import eapli.base.surveymanagement.persistence.SurveyRepository;

import javax.naming.SizeLimitExceededException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisterSurveyController {

    private final SurveyRepository surveyRepository = PersistenceContext.repositories().survey();

    public void registerSurvey(String code, Date finalDate, String title, String welcomeMessage,String condition,List<Integer> num_questions ,List<SectionDTO> sectionsListdto, List<Question> questionList) throws SizeLimitExceededException {
        int lower=0;
        int high = num_questions.get(0);
        List<Section> sectionList = new ArrayList<>();
        for (int i =0; i<num_questions.size();i++){
            List<Question> questionList2 = new ArrayList<>();
            for (int k=lower; k< high;k++){
                questionList2.add(questionList.get(k));
            }
            SectionDTO sectionDTO = sectionsListdto.get(i);
            sectionList.add(new Section(sectionDTO.section_identification,sectionDTO.section_description,sectionDTO.section_title,sectionDTO.obligatoriness,sectionDTO.condition,questionList2));
            int aux = high;
            high = high + lower ;
            lower = aux ;
        }

        Survey survey = new Survey(code,finalDate,title,welcomeMessage,condition,sectionList);
        surveyRepository.save(survey);
    }

    public void registerSurvey(String file, String condition) throws IOException, SizeLimitExceededException {
        Grammar grammar = new Grammar();
        Survey survey = grammar.checkSurvey(file);
        Survey surveyFinal = new Survey (survey.code().code(), survey.finalDate(), survey.title(), survey.welcomeMessage(), condition, survey.sectionsList());
        surveyRepository.save(surveyFinal);
    }


}
