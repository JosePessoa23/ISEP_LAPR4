package eapli.base.surveymanagement.application.controller;

import eapli.base.customer.domain.Customer;
import eapli.base.customer.domain.Email;
import eapli.base.customer.persistence.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.surveymanagement.domain.Question;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.domain.SurveyAnswer;
import eapli.base.surveymanagement.persistence.SurveyAnswerRepository;
import eapli.base.surveymanagement.persistence.SurveyRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class QuestionnaireListController {

    private final SurveyAnswerRepository surveyAnswerRepository = PersistenceContext.repositories().surveyAnswer();
    private final SurveyRepository surveyRepository = PersistenceContext.repositories().survey();
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customer();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public List<Survey> getQuestionnairesList() throws ParseException {
        Username username = authz.session().get().authenticatedUser().username();
        Email email = new Email(username.toString());
        Customer customer = customerRepository.findCustomerByEmail(email);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate aniversario = LocalDate.parse(customer.birthDate().birthDate(), formatter);
        Period periodo = Period.between(aniversario, LocalDate.now());
        int idade = periodo.getYears();
        String gender = customer.gender().gender();
        //1 ir buscar a lista dos surveys ja respondidos (surveyAnswer)
        List<Survey> answeredSurveys = surveyAnswerRepository.findSurveysAnsweredByCustomer(customer);
        //2 ir buscar todos os surveys, for each survey split a condição por ; switch case idade, genero (ja tenho de ter a idade e o gender do customer)
        List<Survey> surveys = (List<Survey>) surveyRepository.findAll();
        List<Survey> availableSurveys = new ArrayList<>();
        String [] aux;
        for(Survey s: surveys){
            aux=s.survey_condition().split(";");
            switch(aux[0]){
                case("Age"):
                    if(Integer.parseInt(aux[1])<=idade && !answeredSurveys.contains(s)){
                        availableSurveys.add(s);
                    }
                    break;
                case("Gender"):
                    if(aux[1].equalsIgnoreCase(gender) && !answeredSurveys.contains(s)){
                        availableSurveys.add(s);
                    }
                    break;
                case("No condition"):
                    if(!answeredSurveys.contains(s))
                        availableSurveys.add(s);
                    break;
            }
        }
        return availableSurveys;
    }

    public void answerSurvey(Survey survey, Map<Question, String> answers){
        Username username = authz.session().get().authenticatedUser().username();
        Email email = new Email(username.toString());
        Customer customer = customerRepository.findCustomerByEmail(email);

        SurveyAnswer surveyAnswer = new SurveyAnswer(customer, survey, answers);
        surveyAnswerRepository.save(surveyAnswer);
    }
}
