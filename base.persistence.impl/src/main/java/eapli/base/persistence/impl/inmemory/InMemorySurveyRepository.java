package eapli.base.persistence.impl.inmemory;

import eapli.base.surveymanagement.domain.Survey;
import eapli.base.surveymanagement.persistence.SurveyRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemorySurveyRepository extends InMemoryDomainRepository<Survey,Long> implements SurveyRepository {
    static {
        InMemoryInitializer.init();
    }


    @Override
    public Survey findSurveyByID(long id) {
        return null;
    }
}
