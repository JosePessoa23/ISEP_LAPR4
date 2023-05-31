package eapli.base.order.application;

import eapli.base.customer.domain.Customer;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.order.domain.Product_Order;
import eapli.base.order.dto.Product_OrderDTOComplete;
import eapli.base.order.persistence.OrderRepository;
import eapli.base.product.domain.Product;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DispatchOrderController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    /**
     * The order repository
     */
    private final OrderRepository orderRepository = PersistenceContext.repositories().order();

    /**
     * Returns a list of orders ready for packing
     * @return list of orders ready for packing
     */
    public List<Product_OrderDTOComplete> getOrdersToBeReadyForPackaging() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE);
        Iterable<Product_Order> orderslist = orderRepository.findAllOrderReadyForPackaging();
        List<Product_OrderDTOComplete> orderslistDto = new ArrayList<>();
        for(Product_Order s : orderslist){
            orderslistDto.add(s.toDTOComplete());
        }
        return orderslistDto;
    }

    public void changeStatus(Product_OrderDTOComplete orderdto){
        Product_Order order = orderRepository.findOrderWithid(orderdto.id);
        order.dispatched();
        orderRepository.save(order);
    }
}
