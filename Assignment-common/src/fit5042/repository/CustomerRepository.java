package fit5042.repository;

import java.util.List;

import javax.ejb.Remote;

import fit5042.repository.entity.Customer;


@Remote
public interface CustomerRepository {
    public void addCustomer(Customer customer) throws Exception;

    public Customer getCustomer(int id) throws Exception;

    public List<Customer> getAllCustomers() throws Exception;
        
    public void deleteCustomer(int customerId) throws Exception;
    
    public void editCustomer(Customer customer) throws Exception;

	public List<Customer> searchCustomerByTypeOfIndustry(String typeOfIndustry);

	public List<Customer> searchCustomerByUser(String username);
}
