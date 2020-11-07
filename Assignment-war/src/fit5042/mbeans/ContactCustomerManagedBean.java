package fit5042.mbeans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fit5042.repository.ContactCustomerRepository;
import fit5042.repository.entity.ContactCustomer;

@ManagedBean(name = "contactCustomerManagedBean")
@SessionScoped
public class ContactCustomerManagedBean {

	@EJB
	ContactCustomerRepository contactCustomerRepository;

	public List<ContactCustomer> getAllContactCustomers() {
		try {
            List<ContactCustomer> contactCustomers = contactCustomerRepository.getAllContactCustomers();
            return contactCustomers;
        } catch (Exception ex) {
            Logger.getLogger(ContactCustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}

	public ContactCustomer getContactCustomer(int contactCustomerID) {
		try {
            return contactCustomerRepository.getContactCustomer(contactCustomerID);
        } catch (Exception ex) {
            Logger.getLogger(ContactCustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
	}
	
	public void addContactCustomer(fit5042.controllers.ContactCustomer localContactCustomer) {
    	ContactCustomer contactCustomer = convertContactCustomerToEntity(localContactCustomer);

        try {
        	contactCustomerRepository.addContactCustomer(contactCustomer);
        } catch (Exception ex) {
            Logger.getLogger(ContactCustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private ContactCustomer convertContactCustomerToEntity(fit5042.controllers.ContactCustomer localContactCustomer) {
    	ContactCustomer customer = new ContactCustomer();
        String customerFirstName = localContactCustomer.getContactCustomerFirstName();
        String customerLastName = localContactCustomer.getContactCustomerLastName();
        String customerPhone = localContactCustomer.getContactCustomerPhone();
        String customerEmail = localContactCustomer.getContactCustomerEmail();
        customer.setContactCustomerFirstName(customerFirstName);
        customer.setContactCustomerLastName(customerLastName);
        customer.setContactCustomerPhone(customerPhone);
        customer.setContactCustomerEmail(customerEmail);
        return customer;
	}
    
    public void removeContactCustomer(int contactCustomerId) 
    {
        try {
            contactCustomerRepository.deleteContactCustomer(contactCustomerId);
        } catch (Exception ex) {
            Logger.getLogger(ContactCustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editContactCustomer(ContactCustomer contactCustomer)
    {
        try {
            
        	contactCustomerRepository.editContactCustomer(contactCustomer);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer Contact has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(ContactCustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

}
