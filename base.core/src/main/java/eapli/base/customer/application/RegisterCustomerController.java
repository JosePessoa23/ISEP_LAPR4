package eapli.base.customer.application;


import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.customer.domain.Customer;
import eapli.base.customer.persistence.CustomerRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.customer.domain.*;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.UserBuilderHelper;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RegisterCustomerController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserRepository userRepository = PersistenceContext.repositories().users();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();

    /**
     * The customer repository
     */
    private final CustomerRepository customerRepository = PersistenceContext.repositories().customer();

    /**
     * creates a new customer and saves it on repository
     * @param name
     * @param vatID
     * @param email
     * @param phoneNumber
     * @param gender
     * @param birthDate
     * @param billingAddress
     * @param deliveringAddress
     * @return the
     */
    public Customer registerCustomer(String name, String vatID, String email, String phoneNumber, String gender, String birthDate, List<String> billingAddress, List<String> deliveringAddress){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALESCLERK);
        Customer customer = new Customer(name, vatID, email, phoneNumber, gender, birthDate, billingAddress, deliveringAddress);
        customerRepository.save(customer);
        registerCustomer(email, vatID, name);
        return null;
    }

    private boolean registerCustomer(String username, String password, String name) {
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();

        userBuilder.withUsername(username).withPassword(password).withName(name, name).withEmail(username).withRoles(BaseRoles.CLIENT_USER);
        final SystemUser newUser = userBuilder.build();

        SystemUser poweruser;
        try {
            poweruser = userRepository.save(newUser);
            ClientUser clientUser = new ClientUser(poweruser,new MecanographicNumber(password));
            clientUserRepository.save(clientUser);
            assert poweruser != null;
            assert clientUser != null;
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            System.out.println("Error, already exists an user with that credentials");
            return false;
        }
    }


}
