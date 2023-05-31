package eapli.base.surveymanagement.persistence;

import eapli.base.customer.domain.Customer;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.domain.SurveyAnswer;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface SurveyAnswerRepository extends DomainRepository<Long, SurveyAnswer> {

    /**
     * Returns the surveys already answered by the customer
     * @param customer
     * @return list of surveys
     */
    List<Survey> findSurveysAnsweredByCustomer(Customer customer);

    /**
     * Returns the survey with the desired id
     * @param id
     * @return
     */
    Iterable<SurveyAnswer> findSurveyAnswerBySurvey(long id);
}
