package eapli.base.agv.persistence;

import eapli.base.agv.domain.AGV;
import eapli.base.order.domain.Product_Order;
import eapli.framework.domain.repositories.DomainRepository;

public interface AGVRepository extends DomainRepository<Long, AGV> {
    /**
     * Return all the AGV's
     * @return all AGV's
     */
    Iterable<AGV> findAllAGV();

    /**
     * Return all AGVs that are able to carry the order
     * @return
     */
    Iterable<AGV> findAbleAGVs(double orderWeight, double orderVolume);

    AGV findAGVWithid(String id);
}
