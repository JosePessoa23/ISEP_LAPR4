package eapli.base.order.persistence;

import eapli.base.order.domain.Product_Order;
import eapli.framework.domain.repositories.DomainRepository;

public interface OrderRepository extends DomainRepository<Integer, Product_Order> {

    /**
     * Return all orders available
     * @return all orders available
     */
    Iterable<Product_Order> findAllOrderToBePrepared();

    /**
     * Return all orders ready for packaging
     * @return all orders ready for packaging
     */
    Iterable<Product_Order> findAllOrderReadyForPackaging();

    /**
     * Return all orders delivered by carrier
     * @return all orders delivered by carrier
     */
    Iterable<Product_Order> findAllOrderDispatched();

    /**
     * Return a order by id
     * @param id the order id
     * @return the order
     */
    Product_Order findOrderWithid(int id);
}
