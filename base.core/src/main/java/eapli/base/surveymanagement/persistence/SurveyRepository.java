package eapli.base.surveymanagement.persistence;

import eapli.base.surveymanagement.domain.Survey;
import eapli.framework.domain.repositories.DomainRepository;

public interface SurveyRepository extends DomainRepository<Long, Survey> {


    /**
     * Returns the survey with the desired id
     * @param id
     * @return customer
     */
    Survey findSurveyByID(long id);

}
