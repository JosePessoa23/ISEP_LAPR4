package eapli.base.customer.persistence;

import eapli.base.customer.domain.Customer;
import eapli.base.customer.domain.Email;
import eapli.framework.domain.repositories.DomainRepository;

public interface CustomerRepository extends DomainRepository<Integer, Customer> {

    /**
     * Returns the customer with the desired id
     * @param str
     * @return customer
     */
    Customer findCustumerByID(String str);

    /**
     * Returns the customer with the desired email
     * @param email
     * @return customer
     */
    Customer findCustomerByEmail(Email email);
}
