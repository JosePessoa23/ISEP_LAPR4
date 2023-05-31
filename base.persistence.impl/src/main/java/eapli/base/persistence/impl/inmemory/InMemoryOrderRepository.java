package eapli.base.persistence.impl.inmemory;

import eapli.base.order.domain.Product_Order;
import eapli.base.order.persistence.OrderRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryOrderRepository extends InMemoryDomainRepository<Product_Order,Integer> implements OrderRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<Product_Order> findAllOrderToBePrepared() {
        return null;
    }

    @Override
    public Iterable<Product_Order> findAllOrderReadyForPackaging() {
        return null;
    }

    @Override
    public Iterable<Product_Order> findAllOrderDispatched() {
        return null;
    }

    @Override
    public Product_Order findOrderWithid(int id) {
        return null;
    }
}
