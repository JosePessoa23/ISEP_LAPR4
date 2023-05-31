package eapli.base.persistence.impl.inmemory;

import eapli.base.customer.domain.Customer;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.domain.SurveyAnswer;
import eapli.base.surveymanagement.persistence.SurveyAnswerRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemorySurveyAnswerRepository extends InMemoryDomainRepository<SurveyAnswer,Long> implements SurveyAnswerRepository {
    static {
        InMemoryInitializer.init();
    }


    @Override
    public List<Survey> findSurveysAnsweredByCustomer(Customer customer) {
        return null;
    }

    @Override
    public Iterable<SurveyAnswer> findSurveyAnswerBySurvey(long id) {
        return null;
    }
}
