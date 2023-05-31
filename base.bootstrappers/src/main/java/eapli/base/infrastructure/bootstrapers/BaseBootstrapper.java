/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.agv.application.ConfigureAGVController;
import eapli.base.agv.domain.*;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.customer.domain.Customer;
import eapli.base.customer.persistence.CustomerRepository;
import eapli.base.order.application.RegisterProduct_OrderController;
import eapli.base.order.domain.Product_Order;
import eapli.base.order.persistence.OrderRepository;
import eapli.base.product.domain.Product;
import eapli.base.product.domain.ProductCategory;
import eapli.base.product.persistance.ProductCategoryRepository;
import eapli.base.product.persistance.ProductRepository;
import eapli.base.surveymanagement.domain.*;
import eapli.base.surveymanagement.persistence.SurveyRepository;
import eapli.base.warehouse.application.AddJsonFileController;
import eapli.base.warehouse.domain.AGVDocks;
import eapli.base.warehouse.domain.Shelf;
import eapli.base.warehouse.persistence.WarehouseRepository;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.UserBuilderHelper;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.strings.util.Strings;
import eapli.framework.validations.Invariants;

import javax.naming.SizeLimitExceededException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Base Bootstrapping data app
 *
 * @author Paulo Gandra de Sousa
 */
@SuppressWarnings("squid:S106")
public class BaseBootstrapper implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseBootstrapper.class);

    private static final String ADMIN_A1 = "Password1";
    private static final String ADMIN = "admin";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AuthenticationService authenticationService = AuthzRegistry.authenticationService();
    private final UserRepository userRepository = PersistenceContext.repositories().users();
    private final AddJsonFileController controller = new AddJsonFileController();
    private final ProductCategoryRepository categoryRepository = PersistenceContext.repositories().productCategories();
    private final ProductRepository productRepository = PersistenceContext.repositories().products();
    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customer();
    private final OrderRepository orderRepository = PersistenceContext.repositories().order();
    private final SurveyRepository surveyRepository = PersistenceContext.repositories().survey();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();

    @Override
    public boolean execute() {
        // declare bootstrap actions
        final Action[] actions = { new MasterUsersBootstrapper(), };

        registerAdmin();
        registerWarehouse();
        registerSalesClerk();
        registerSalesManager();
        authenticateForBootstrapping();
        createWarehouse();
        createCustomer();
        createCategory();
        try {
            createSurvey();
        } catch (SizeLimitExceededException e) {
            e.printStackTrace();
        }


        // execute all bootstrapping
        boolean ret = true;
        for (final Action boot : actions) {
            System.out.println("Bootstrapping " + nameOfEntity(boot) + "...");
            ret &= boot.execute();
        }
        return ret;
    }

    /**
     * register a power user directly in the persistence layer as we need to
     * circumvent authorisations in the Application Layer
     */
    private boolean registerAdmin() {
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername(ADMIN).withPassword(ADMIN_A1).withName("Jon", "Travolta")
                .withEmail("joe@email.org").withRoles(BaseRoles.ADMIN);
        final SystemUser newUser = userBuilder.build();

        SystemUser poweruser;
        try {
            poweruser = userRepository.save(newUser);
            assert poweruser != null;
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", newUser.username());
            LOGGER.trace("Assuming existing record", e);
            return false;
        }
    }

    private boolean registerWarehouse() {
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername("warehouse").withPassword("Password1").withName("Joe", "Jeff")
                .withEmail("joejeff@email.com").withRoles(BaseRoles.WAREHOUSE_EMPLOYEE);
        final SystemUser newUser = userBuilder.build();

        SystemUser poweruser;
        try {
            poweruser = userRepository.save(newUser);
            assert poweruser != null;
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", newUser.username());
            LOGGER.trace("Assuming existing record", e);
            return false;
        }
    }

    private boolean registerSalesClerk() {
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername("salesclerk").withPassword("Password1").withName("Jeff", "Jeff")
                .withEmail("jeffjeff@email.com").withRoles(BaseRoles.SALESCLERK);
        final SystemUser newUser = userBuilder.build();

        SystemUser poweruser;
        try {
            poweruser = userRepository.save(newUser);
            assert poweruser != null;
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", newUser.username());
            LOGGER.trace("Assuming existing record", e);
            return false;
        }
    }

    private boolean registerSalesManager() {
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername("salesmanager").withPassword("Password1").withName("John", "Jeff")
                .withEmail("johnjeff@email.com").withRoles(BaseRoles.SALESMANAGER);
        final SystemUser newUser = userBuilder.build();

        SystemUser poweruser;
        try {
            poweruser = userRepository.save(newUser);
            assert poweruser != null;
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", newUser.username());
            LOGGER.trace("Assuming existing record", e);
            return false;
        }
    }

    /**
     * authenticate a super user to be able to register new users
     *
     */
    protected void authenticateForBootstrapping() {
        authenticationService.authenticate(ADMIN, ADMIN_A1);
        Invariants.ensure(authz.hasSession());
    }

    private String nameOfEntity(final Action boot) {
        final String name = boot.getClass().getSimpleName();
        return Strings.left(name, name.length() - "Bootstrapper".length());
    }

    private void createWarehouse(){
        try {
            controller.addJsonFile("warehouse1.json");
            ConfigureAGVController configureAGVController  = new ConfigureAGVController();
            List<AGVDocks> agvDocks = warehouseRepository.findWarehouse().agvDocks();
            AGVDocks agvDocks1 = agvDocks.get(0);
            AGVDocks agvDocks2 = agvDocks.get(1);
            AGVDocks agvDocks6 = agvDocks.get(5);
            String description = "Very fast";
            String agvmodel = "bmw";
            int weight = 500;
            int volume = 500;
            Identification identification1,identification2,identification6;
            try {
                identification1 = new Identification("1");
                identification2 = new Identification("2");
                identification6 = new Identification("6");
            } catch (SizeLimitExceededException e) {
                throw new RuntimeException(e);
            }
            ShortDescription shortDescription;
            try {
                shortDescription = new ShortDescription(description);
            } catch (SizeLimitExceededException e) {
                throw new RuntimeException(e);
            }
            Model model;
            try {
                model = new Model(agvmodel);
            } catch (SizeLimitExceededException e) {
                throw new RuntimeException(e);
            }
            MaximumWeight maximumWeight = new MaximumWeight(weight);
            MaximumVolume maximumVolume = new MaximumVolume(volume);
            String baseLocation = "AGV dock";
            Autonomy autonomy = new Autonomy(2);
            int agvSpeed = 2;
            try {
                configureAGVController.configureAGV(agvDocks1,identification1,shortDescription,model,maximumWeight,maximumVolume,baseLocation, autonomy, agvSpeed);
                configureAGVController.configureAGV(agvDocks2,identification2,shortDescription,model,maximumWeight,maximumVolume,baseLocation, autonomy, agvSpeed);
                configureAGVController.configureAGV(agvDocks6,identification6,shortDescription,model,maximumWeight,maximumVolume,baseLocation, autonomy, agvSpeed);
            } catch (SizeLimitExceededException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void createCategory(){
        try {
            ProductCategory pc1 = new ProductCategory("description1aaaadfsgehr", "1234");
            ProductCategory pc2 = new ProductCategory("description2asdasdefthd", "45678");
            categoryRepository.save(pc1);
            categoryRepository.save(pc2);

            for(ProductCategory p : categoryRepository.findAllProductCategories()){
                if(p.getCategoryCode().code().equals(pc1.getCategoryCode().code())){
                    pc1 = p;
                }else if(p.getCategoryCode().code().equals(pc2.getCategoryCode().code())){
                    pc2 = p;
                }
            }
            Shelf shelf3 = warehouseRepository.getShelfByID("Warehouse Example 1", 3L, 2L,1L);
            Shelf shelf4 = warehouseRepository.getShelfByID("Warehouse Example 1", 3L, 2L,2L);
            Shelf shelf = warehouseRepository.getShelfByID("Warehouse Example 1", 4L, 1L,1L);
            Shelf shelf2 = warehouseRepository.getShelfByID("Warehouse Example 1", 4L, 2L,1L);
            Product p = new Product("ab1234", pc1, "brand1", 30, 35, "123456782345", "cd1231", "12313", "short", "extended description123", "simulatePhoto", shelf, true, 30.0, 30.0);
            Product p2 = new Product("fv1234", pc2, "brand1", 35, 50, "111156782345", "cd1245", "12311", "short1", "extended description456", "simulatePhoto", shelf2, true, 30.0, 30.0);
            Product p3 = new Product("fg5678", pc1, "brand2", 50, 70, "111111111111", "hj5345", "11111", "short2", "extended description4545", "simulatePhoto", shelf3, true, 30.0, 30.0);
            Product p4 = new Product("dd5238", pc2, "brand3", 50, 70, "111111111122", "hj5345", "11123", "short3", "extended description4542", "simulatePhoto", shelf4, true, 30.0, 30.0);
            productRepository.save(p);
            productRepository.save(p2);
            productRepository.save(p3);
            productRepository.save(p4);


            //product list for first order
            List<Product> productList = new ArrayList<>();
            List<Product> productList2 = new ArrayList<>();
            for(Product prod : productRepository.findAllProducts()){
                if(prod.getCode().code().equals("ab1234")){
                    p = prod;
                }else
                if(prod.getCode().code().equals("fv1234")){
                    p2 = prod;
                }else
                if(prod.getCode().code().equals("fg5678")){
                    p3 = prod;
                }else
                if(prod.getCode().code().equals("dd5238")){
                    p4 = prod;
                }
            }
            productList.add(p);
            productList.add(p2);
            productList2.add(p3);
            productList2.add(p4);


            List<Integer> quantity = new ArrayList<>();
            List<Integer> quantity2 = new ArrayList<>();
            quantity.add(1);
            quantity.add(1);
            quantity2.add(1);
            quantity2.add(1);
            List<Customer> customerList = (List<Customer>) customerRepository.findAll();
            Customer customer = customerList.get(0);
            RegisterProduct_OrderController ctrl = new RegisterProduct_OrderController();
            Product_Order order = new Product_Order(new Date(), "Truck", "Card", productList, quantity, "rua dos calvarios", "rua dos calvarios", customer, "phone", "1");
            Product_Order order2 = new Product_Order(new Date(), "Truck", "Card", productList2, quantity2, "rua dos calvarios", "rua dos calvarios", customer, "phone", "1");
            order.paid();
            order2.paid();
            orderRepository.save(order);
            orderRepository.save(order2);
            List<Product_Order> list = (List<Product_Order>) orderRepository.findAll();
            order = list.get(0);
            order2 = list.get(1);
            ctrl.addOrderToQueue(order);
            ctrl.addOrderToQueue(order2);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(){
        try {
            String billing = "Rua dos calvarios";
            List<String> billing_address = new ArrayList<>();
            billing_address.add(billing);
            String delivering = "Rua dos calvarios";
            List<String> delivering_address = new ArrayList<>();
            delivering_address.add(delivering);
            Customer customer = new Customer("Joana Fernandes","PT123456789","joana@gmail.com","+123456789012","female","2000-02-02",billing_address,delivering_address);
            customerRepository.save(customer);
            final SystemUserBuilder userBuilder = UserBuilderHelper.builder();

            userBuilder.withUsername("joana@gmail.com").withPassword("PT123456789").withName("Joana", "Fernandes").withEmail("joana@gmail.com").withRoles(BaseRoles.CLIENT_USER);
            final SystemUser newUser = userBuilder.build();

            SystemUser poweruser;
            poweruser = userRepository.save(newUser);
            ClientUser clientUser = new ClientUser(poweruser,new MecanographicNumber("PT123456789"));
            clientUserRepository.save(clientUser);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createSurvey() throws SizeLimitExceededException {
        Date data = Calendar.getInstance().getTime();
        Calendar cal =Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DAY_OF_MONTH,10);
        data = cal.getTime();
        List<String> la = new ArrayList<>();
        la.add("a)Banana");
        la.add("b)Laranja");
        la.add("c)Kiwi");

        Free_TextQuestion q = new Free_TextQuestion(" Indique quais frutas comprou.", 1, "mandatory");
        SingleChoiceQuestion q1 = new SingleChoiceQuestion(" Indique quais frutas comprou.", 1,"mandatory", la);
        List<Question> qList = new ArrayList<>();

        qList.add(q);
        qList.add(q1);

        Section section = new Section(123, "Section Products", "Produtos", "mandatory", "", qList);

        List<Section> sList = new ArrayList<>();
        sList.add(section);
        Survey s = new Survey("QUEST3", data, "QUEST3", "bem vindo ao questionario. tem 4 perguntas para responder a cerca de produtos que encomendou.","Age;20", sList);
        surveyRepository.save(s);
    }

}
