package eapli.base.persistence.impl.inmemory;

import eapli.base.agv.domain.AGV;
import eapli.base.agv.persistence.AGVRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryAGVRepository extends InMemoryDomainRepository<AGV,Long> implements AGVRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<AGV> findAllAGV() {
        return null;
    }

    @Override
    public Iterable<AGV> findAbleAGVs(double orderWeight, double orderVolume) {
        return null;
    }

    @Override
    public AGV findAGVWithid(String id) {
        return null;
    }


}
