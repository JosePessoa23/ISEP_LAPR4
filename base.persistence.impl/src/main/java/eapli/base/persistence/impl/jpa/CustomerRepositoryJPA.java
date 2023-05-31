package eapli.base.persistence.impl.jpa;



import eapli.base.customer.domain.Customer;
import eapli.base.customer.domain.Email;
import eapli.base.customer.persistence.CustomerRepository;

import javax.persistence.TypedQuery;
import java.util.Optional;

public class CustomerRepositoryJPA extends BasepaRepositoryBase<Customer,Integer,Integer> implements CustomerRepository {
     public CustomerRepositoryJPA() {
            super("eapli.base");
     }


        @Override
        public Optional<Customer> ofIdentity(Integer id) {
            return Optional.empty();
        }

        @Override
        public void deleteOfIdentity(Integer entityId) {

        }

    @Override
    public Customer findCustumerByID(String str) {
        final TypedQuery<Customer> query = entityManager().createQuery("SELECT d FROM Customer d WHERE d.id = :str ", Customer.class);
        query.setParameter("str",Integer.parseInt(str));
        return query.getSingleResult();
    }

    @Override
    public Customer findCustomerByEmail(Email email) {
        final TypedQuery<Customer> query = entityManager().createQuery("SELECT d FROM Customer d WHERE d.email = :email ", Customer.class);
        query.setParameter("email",email);
        return query.getSingleResult();
    }
}
