package fit5042.mbeans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fit5042.repository.CustomerRepository;
import fit5042.repository.entity.Address;
import fit5042.repository.entity.Customer;

@ManagedBean(name = "customerManagedBean")
@SessionScoped
public class CustomerManagedBean {
	@EJB
	CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		try {
            List<Customer> customers = customerRepository.getAllCustomers();
            return customers;
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}

	public Customer getCustomer(int customerID) {
		try {
            return customerRepository.getCustomer(customerID);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
	}
	
    public void addCustomer(Customer customer) 
    {
        try {
             customerRepository.addCustomer(customer);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
    public void addCustomer(fit5042.controllers.Customer localCustomer) {
    	Customer customer = convertCustomerToEntity(localCustomer);

        try {
        	customerRepository.addCustomer(customer);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Customer convertCustomerToEntity(fit5042.controllers.Customer localCustomer) {
    	Customer customer = new Customer();
        String customerFirstName = localCustomer.getCustomerFirstName();
        String customerLastName = localCustomer.getCustomerLastName();
        String customerPhone = localCustomer.getCustomerPhone();
        String customerEmail = localCustomer.getCustomerEmail();
        String customerTypeOfIndustry = localCustomer.getCustomerTypeOfIndustry();
        String streetNumber = localCustomer.getStreetNumber();
        String streetAddress = localCustomer.getStreetAddress();
        String suburb = localCustomer.getSuburb();
        String postcode = localCustomer.getPostcode();
        String state = localCustomer.getState();
        Address customerAddress = new Address(streetNumber, streetAddress, suburb, postcode, state);
        customer.setCustomerFirstName(customerFirstName);
        customer.setCustomerLastName(customerLastName);
        customer.setCustomerPhone(customerPhone);
        customer.setCustomerEmail(customerEmail);
        customer.setCustomerAddress(customerAddress);
        customer.setCustomerTypeOfIndustry(customerTypeOfIndustry);
        return customer;
	}
    
    public void removeCustomer(int customerId) 
    {
        try {
            customerRepository.deleteCustomer(customerId);
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editCustomer(Customer customer)
    {
        try {
            String s = customer.getCustomerAddress().getStreetNumber();
            Address address = customer.getCustomerAddress();
            address.setStreetNumber(s);
            customer.setCustomerAddress(address);
            
            customerRepository.editCustomer(customer);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
