package eapli.base.order.application;


import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.order.domain.Product_Order;
import eapli.base.order.persistence.OrderRepository;
import eapli.base.customer.domain.Customer;
import eapli.base.customer.persistence.CustomerRepository;
import eapli.base.product.domain.Product;
import eapli.base.product.persistance.ProductRepository;
import eapli.base.warehouse.domain.Warehouse;
import eapli.base.warehouse.persistence.WarehouseRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Date;
import java.util.List;

public class RegisterProduct_OrderController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    /**
     * The order repository
     */
    private final OrderRepository orderRepository = PersistenceContext.repositories().order();
    /**
     * The product repository
     */
    private final ProductRepository productRepository = PersistenceContext.repositories().products();
    /**
     * The customer repository
     */
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customer();
    /**
     * The warehouse repository
     */
    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();


    /**
     * Finds all the existing products
     * @return
     */
    public List<Product> findAllProducts(){
        return (List<Product>) productRepository.findAllProductsAvailable();
    }

    /**
     * Finds a product by its ID
     * @param str
     * @return
     */
    public Product findProductByID(String str){
        return productRepository.findProductByID(str);
    }

    /**
     * Finds a customer by its ID
     * @param str
     * @return
     */
    public Customer findCustomerByID(String str){
        return customerRepository.findCustumerByID(str);
    }

    /**
     * Creates a new order and saves it on repository
     * @param registration_time
     * @param shipment_method
     * @param payment
     * @param order_productList
     * @param quantitylist
     * @param bilingaddress
     * @param deliveringaddress
     * @param customer
     * @param sourceofInformation
     * @return
     */
    public Product_Order addOrder(Date registration_time, String shipment_method, String payment, List<Product> order_productList, List<Integer> quantitylist, String bilingaddress, String deliveringaddress, Customer customer, String sourceofInformation) {
        Product_Order productOrder = new Product_Order(registration_time,shipment_method,payment,order_productList,quantitylist,bilingaddress,deliveringaddress,customer,sourceofInformation,authz.session().get().authenticatedUser().username().toString());
        productOrder.paid();
        productOrder = orderRepository.save(productOrder);
        addOrderToQueue(productOrder);
        return productOrder;
    }

    public void addOrderToQueue(Product_Order order){
        Warehouse warehouse = warehouseRepository.findWarehouse();
        warehouse.addOrderToBePrepared(order);
        warehouseRepository.save(warehouse);
    }
}
