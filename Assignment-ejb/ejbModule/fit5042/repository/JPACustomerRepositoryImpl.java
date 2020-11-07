package fit5042.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fit5042.repository.entity.Customer;

@Stateless
public class JPACustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext(unitName = "Assignment")
    private EntityManager entityManager;

    @Override
    public void addCustomer(Customer customer) throws Exception {
    	List<Customer> customers =  entityManager.createNamedQuery(customer.GET_ALL_QUERY_NAME).getResultList(); 
        customer.setCustomerID(customers.get(0).getCustomerID() + 1);
        entityManager.persist(customer);
        System.out.println(customer);
    }
     
    @Override
    public Customer getCustomer(int id) throws Exception {
        Customer Customer = entityManager.find(Customer.class, id);
        return Customer;
    }

    @Override
    public List<Customer> getAllCustomers() throws Exception {
    	 TypedQuery<Customer> query =
    			 entityManager.createQuery("SELECT c FROM Customer c", Customer.class);
    		  List<Customer> results = query.getResultList();
    		  return results;
    }


    @Override
    public void deleteCustomer(int CustomerId) throws Exception {
        Customer Customer = this.getCustomer(CustomerId);

        if (Customer != null) {
            entityManager.remove(Customer);
        }
    }

    @Override
    public void editCustomer(Customer customer) throws Exception {   
         try {
            entityManager.merge(customer);
        } catch (Exception ex) {
            
        }
    }


}

