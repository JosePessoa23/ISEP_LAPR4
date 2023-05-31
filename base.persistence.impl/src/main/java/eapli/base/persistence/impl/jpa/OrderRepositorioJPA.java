package eapli.base.persistence.impl.jpa;

import eapli.base.order.domain.Product_Order;
import eapli.base.order.domain.State;
import eapli.base.order.persistence.OrderRepository;
import eapli.base.product.domain.Product;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class OrderRepositorioJPA extends BasepaRepositoryBase<Product_Order,Integer,Integer> implements OrderRepository {

    public OrderRepositorioJPA() {
        super("eapli.base");
    }

    @Override
    public Iterable<Product_Order> findAllOrderToBePrepared() {
        final TypedQuery<Product_Order> query = entityManager().createQuery("SELECT d FROM Product_Order d WHERE d.state = :state", Product_Order.class);
        query.setParameter("state", State.To_be_prepared);
        return query.getResultList();
    }

    @Override
    public Iterable<Product_Order> findAllOrderReadyForPackaging() {
        final TypedQuery<Product_Order> query = entityManager().createQuery("SELECT d FROM Product_Order d WHERE d.state = :state", Product_Order.class);
        query.setParameter("state", State.Ready_for_packaging);
        return query.getResultList();
    }

    @Override
    public Iterable<Product_Order> findAllOrderDispatched() {
        final TypedQuery<Product_Order> query = entityManager().createQuery("SELECT d FROM Product_Order d WHERE d.state = :state", Product_Order.class);
        query.setParameter("state", State.Dispatched);
        return query.getResultList();
    }

    @Override
    public Product_Order findOrderWithid(int identification) {
        final TypedQuery<Product_Order> query = entityManager().createQuery("SELECT d FROM Product_Order d WHERE d.id = ?1", Product_Order.class);
        query.setParameter(1,identification);
        return query.getSingleResult();
    }
}
