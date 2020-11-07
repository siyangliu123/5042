package fit5042.repository;

import java.util.List;

import javax.ejb.Remote;

import fit5042.repository.entity.ContactCustomer;

@Remote
public interface ContactCustomerRepository {
	public void addContactCustomer(ContactCustomer customer) throws Exception;

    public ContactCustomer getContactCustomer(int id) throws Exception;

    public List<ContactCustomer> getAllContactCustomers() throws Exception;
        
    public void deleteContactCustomer(int contactCustomerId) throws Exception;
    
    public void editContactCustomer(ContactCustomer contactCustomer) throws Exception;
}
