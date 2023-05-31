package eapli.base.persistence.impl.jpa;

import eapli.base.customer.domain.Customer;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.domain.SurveyAnswer;
import eapli.base.surveymanagement.persistence.SurveyAnswerRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class SurveyAnswerRepositoryJPA extends BasepaRepositoryBase<SurveyAnswer,Long,Long> implements SurveyAnswerRepository {

    public SurveyAnswerRepositoryJPA() {
        super("eapli.base");
    }


    @Override
    public List<Survey> findSurveysAnsweredByCustomer(Customer customer) {
        final TypedQuery<Survey> query = entityManager().createQuery("SELECT d.survey FROM SurveyAnswer d WHERE d.customer.id = :customer ", Survey.class);
        query.setParameter("customer",customer.identity());
        return query.getResultList();
    }

    @Override
    public Iterable<SurveyAnswer> findSurveyAnswerBySurvey(long id) {
        final TypedQuery<SurveyAnswer> query = entityManager().createQuery("SELECT d FROM SurveyAnswer d WHERE d.survey.id = :id ", SurveyAnswer.class);
        query.setParameter("id",id);
        return query.getResultList();
    }
}
