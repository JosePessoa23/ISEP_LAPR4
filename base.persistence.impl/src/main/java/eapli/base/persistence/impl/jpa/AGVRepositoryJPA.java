package eapli.base.persistence.impl.jpa;

import eapli.base.agv.domain.AGV;
import eapli.base.agv.domain.CurrentTask;
import eapli.base.agv.persistence.AGVRepository;
import eapli.base.order.domain.Product_Order;

import javax.persistence.TypedQuery;

public class AGVRepositoryJPA extends BasepaRepositoryBase<AGV,Long,Long> implements AGVRepository {

    public AGVRepositoryJPA() {
        super("eapli.base");
    }

    @Override
    public Iterable<AGV> findAllAGV(){
        final TypedQuery<AGV> query = entityManager().createQuery("SELECT d FROM AGV d",AGV.class);
        return  query.getResultList();
    }

    @Override
    public Iterable<AGV> findAbleAGVs(double orderWeight, double orderVolume) {
        final TypedQuery<AGV> query = entityManager().createQuery("SELECT d FROM AGV d WHERE d.maximumVolume.maximumVolume>=?1 AND d.maximumWeight.maximumWeight>=?2 AND d.currentTask = ?3", AGV.class);
        query.setParameter(1, orderVolume);
        query.setParameter(2, orderWeight);
        query.setParameter(3, CurrentTask.FREE);
        return query.getResultList();
    }

    @Override
    public AGV findAGVWithid(String id) {
        final TypedQuery<AGV> query = entityManager().createQuery("SELECT d FROM AGV d WHERE d.identification.identification = ?1", AGV.class);
        query.setParameter(1,id);
        return query.getSingleResult();
    }

}
