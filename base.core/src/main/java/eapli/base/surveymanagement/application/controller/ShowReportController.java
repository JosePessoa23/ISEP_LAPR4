package eapli.base.surveymanagement.application.controller;

import eapli.base.customer.domain.Customer;
import eapli.base.customer.persistence.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.surveymanagement.domain.*;
import eapli.base.surveymanagement.dto.SurveyDTO;
import eapli.base.surveymanagement.persistence.SurveyAnswerRepository;
import eapli.base.surveymanagement.persistence.SurveyRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ShowReportController {

    private final SurveyRepository surveyRepository = PersistenceContext.repositories().survey();
    private final SurveyAnswerRepository surveyAnswerRepository = PersistenceContext.repositories().surveyAnswer();
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customer();

    private Survey survey =null;
    private List<SurveyAnswer> list;

    public List<SurveyDTO> getSurveyList(){
        List<Survey> surveyList = (List<Survey>) surveyRepository.findAll();

        return toDto(surveyList);
    }


    private List<SurveyDTO> toDto(List<Survey> list){
        List<SurveyDTO> surveyDTOList = new ArrayList<>();
        for (Survey survey: list) {
            surveyDTOList.add(survey.toDTO());
        }
        return surveyDTOList;
    }

    public int[] getCommonInformation(long survey_id){
        survey = surveyRepository.findSurveyByID(survey_id);
        list = (List<SurveyAnswer>) surveyAnswerRepository.findSurveyAnswerBySurvey(survey_id);
        int[] ints = new int[2];
        ints[1] = list.size();
        List<Customer> customerList = (List<Customer>) customerRepository.findAll();


        String [] aux;
        int max =0;
        for(Customer s: customerList){

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate aniversario = LocalDate.parse(s.birthDate().birthDate(), formatter);
            Period periodo = Period.between(aniversario, LocalDate.now());
            int idade = periodo.getYears();

            aux=survey.survey_condition().split(";");
            switch(aux[0]){
                case("Age"):
                    if(Integer.parseInt(aux[1])<= idade ){
                        max++;
                    }
                    break;
                case("Gender"):
                    if(aux[1].equalsIgnoreCase(s.gender().gender())){
                        max++;
                    }
                    break;
                case("No condition"):
                    max++;
                    break;
            }
        }

        ints[0] = max;
        return ints;
    }


    public String getQuestionInfo(){
        StringBuilder information= new StringBuilder();
        for (Section section: survey.sectionsList()) {
            information.append(String.format("SectionID : %d   Section Description: %s\n", section.section_identification(), section.section_description()));

            for (Question question: section.questionList()) {
                int numSurveyAnswers= list.size();
                int numAnswers=0;
                for (SurveyAnswer surveyAnswer :list) {

                    for (Question help : surveyAnswer.answers().keySet()) {
                        if (help.equals(question)){
                            numAnswers++;
                        }
                    }
                }


                information.append(String.format("Question: %s   Question type : %s\n", question.question(), question.type()));
                information.append(String.format("Number of answers to the survey: %d\nNumber of answers to the question: %d\n%% of responses obtained: %.0f%% \n", numSurveyAnswers,numAnswers,((double) numAnswers/numSurveyAnswers) *100));

                switch(question.type()){
                    case "single-choice" :
                    case "single-choice with input value" :
                    case "scalling options" :
                        information.append("Distribution (in %%) of answers for each alternative\n");
                        for (String la: question.answerlist()) {
                            int aux= 0;
                            String resposta = null;
                            for (SurveyAnswer surveyAnswer:list) {
                                for (Question help : surveyAnswer.answers().keySet()) {
                                    if (help.equals(question)){
                                        resposta = surveyAnswer.answers().get(help);
                                    }
                                }
                                if ( resposta != null && resposta.equals(la)){
                                    aux++;
                                }
                            }
                            information.append(String.format("%s = %.0f%%\n", la,((double) aux/numAnswers) *100));
                        }
                        break;
                    case "multiple-choice" :
                    case "multiple-choice with input value" :
                        information.append("Distribution (in %%) of answers for each alternative\n");
                        for (String la: question.answerlist()) {
                            int aux= 0;
                            List<String> resposta =new ArrayList<>();
                            for (SurveyAnswer surveyAnswer:list) {
                                for (Question help : surveyAnswer.answers().keySet()) {
                                    if (help.equals(question)){
                                        resposta = List.of(surveyAnswer.answers().get(help).split(";"));
                                    }
                                }
                                la = la.replace(";","");

                                if (resposta.contains(la)){
                                    aux++;
                                }
                            }
                            information.append(String.format("%s = %.0f%%\n", la,((double) aux/numAnswers) *100));
                        }

                        information.append("Distribution (in %) of combined responses\n");
                        for (int i =0; i<question.answerlist().size();i++) {
                            String la = question.answerlist().get(i);
                            for (int k = i+1; k < question.answerlist().size(); k++) {
                                String le = question.answerlist().get(k);
                                int aux = 0;
                                List<String> resposta = new ArrayList<>();
                                for (SurveyAnswer surveyAnswer : list) {
                                    for (Question help : surveyAnswer.answers().keySet()) {
                                        if (help.equals(question)) {
                                            resposta = List.of(surveyAnswer.answers().get(help).split(";"));
                                        }
                                    }
                                    la = la.replace(";", "");
                                    le = le.replace(";","");

                                    if (resposta.contains(la) && resposta.contains(le)) {
                                        aux++;
                                    }
                                }
                                information.append(String.format("%s %s = %.0f%%\n", la,le, ((double) aux / numAnswers) * 100));
                            }
                        }


                        break;

                    case "sorting options" :
                        information.append("Distribution (in %%) of answers for each alternative\n");
                        List<String> stringList2 = question.answerlist();
                        stringList2.remove("sorting options");
                        for (String la: stringList2) {
                            for (int i=0; i<stringList2.size() ;i++) {
                                int aux= 0;
                                List<String> resposta = new ArrayList<>();
                                for (SurveyAnswer surveyAnswer : list) {
                                    for (Question help : surveyAnswer.answers().keySet()) {
                                        if (help.equals(question)) {
                                            resposta = List.of(surveyAnswer.answers().get(help).split(";"));

                                        }
                                    }
                                    la = la.replace(";", "");
                                    la = la.replace(".","");



                                    if ( !resposta.isEmpty() && resposta.get(i).equals(la)) {
                                        aux++;
                                    }
                                }
                                information.append(String.format("%s- %dºLugar = %.0f%%\n", la,i+1, ((double) aux / numAnswers) * 100));
                            }
                        }

                        break;
                }
                information.append("\n");
            }
        }
        return information.toString();
    }

}
