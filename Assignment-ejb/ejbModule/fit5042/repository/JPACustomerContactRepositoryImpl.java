package fit5042.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fit5042.repository.entity.ContactCustomer;

@Stateless
public class JPACustomerContactRepositoryImpl implements ContactCustomerRepository {
	@PersistenceContext(unitName = "Assignment")
    private EntityManager entityManager;

	@Override
	public void addContactCustomer(ContactCustomer contactCustomer) throws Exception {
		List<ContactCustomer> contactCustomers =  entityManager.createNamedQuery(contactCustomer.GET_ALL_QUERY_NAME).getResultList(); 
		contactCustomer.setContactCustomerID(contactCustomers.size() + 1);
        entityManager.persist(contactCustomer);		
	}

	@Override
	public ContactCustomer getContactCustomer(int id) throws Exception {
		ContactCustomer contactCustomer = entityManager.find(ContactCustomer.class, id);
        return contactCustomer;
	}

	@Override
	public List<ContactCustomer> getAllContactCustomers() throws Exception {
		
		TypedQuery<ContactCustomer> query =
		entityManager.createQuery("SELECT c FROM ContactCustomer c", ContactCustomer.class);
		List<ContactCustomer> results = new ArrayList<ContactCustomer>(query.getResultList());
		return results;
	}

	@Override
	public void deleteContactCustomer(int contactCustomerId) throws Exception {
        ContactCustomer contactCustomer = this.getContactCustomer(contactCustomerId);

        if (contactCustomer != null) {
            entityManager.remove(contactCustomer);
        }
		
	}

	@Override
	public void editContactCustomer(ContactCustomer contactCustomer) throws Exception {
		try {
            entityManager.merge(contactCustomer);
        } catch (Exception ex) {
            
        }
		
	}
}
