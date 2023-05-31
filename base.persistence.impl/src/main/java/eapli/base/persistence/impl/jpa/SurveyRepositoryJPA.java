package eapli.base.persistence.impl.jpa;

import eapli.base.customer.domain.Customer;
import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.persistence.SurveyRepository;

import javax.persistence.TypedQuery;

public class SurveyRepositoryJPA extends BasepaRepositoryBase<Survey,Long,Long> implements SurveyRepository {

    public SurveyRepositoryJPA() {
        super("eapli.base");
    }


    @Override
    public Survey findSurveyByID(long id) {
        final TypedQuery<Survey> query = entityManager().createQuery("SELECT d FROM Survey d WHERE d.id = :id ", Survey.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }
}
