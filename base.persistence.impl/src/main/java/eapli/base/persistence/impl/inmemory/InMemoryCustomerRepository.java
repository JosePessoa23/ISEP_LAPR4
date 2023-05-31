package eapli.base.persistence.impl.inmemory;


import eapli.base.customer.domain.Customer;
import eapli.base.customer.domain.Email;
import eapli.base.customer.persistence.CustomerRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryCustomerRepository extends InMemoryDomainRepository<Customer, Integer> implements CustomerRepository {
    static {
        InMemoryInitializer.init();
    }

    @Override
    public Customer findCustumerByID(String str) {
        return null;
    }

    @Override
    public Customer findCustomerByEmail(Email email) {
        return null;
    }
}
