package fit5042.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import fit5042.mbeans.ContactCustomerManagedBean;
import fit5042.repository.entity.ContactCustomer;

@Named(value = "contactCustomerController")
@RequestScoped
public class ContactCustomerController {
	@ManagedProperty(value="#{contactCustomerManagedBean}")
	ContactCustomerManagedBean contactCustomerManagedBean;
	
	private ArrayList<ContactCustomer> contactCustomers;
	
    private fit5042.repository.entity.ContactCustomer contactCustomer;
    
    private int contactCustomerID;
    
    public int getContactCustomerID() {
        return contactCustomerID;
    }

    public void setContactCustomerID(int contactCustomerID) {
        this.contactCustomerID = contactCustomerID;
    }


    private boolean showForm = true;
  
    public boolean isShowForm() {
        return showForm;
    }

    public ContactCustomerController() throws Exception {       
        contactCustomers = new ArrayList<>();
        
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        contactCustomerManagedBean = (ContactCustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "contactCustomerManagedBean");

        contactCustomer = getContactCustomer();
        
        searchAll();
    }

    public List<ContactCustomer> getContactCustomers() {
        return contactCustomers;
    }
    
    private void setContactCustomers(List<ContactCustomer> newContactCustomers) {
        this.contactCustomers = (ArrayList<ContactCustomer>) newContactCustomers;
    }
    
    public void updateContactCustomerList()
    {
        	contactCustomers.clear();

            for (ContactCustomer contactCustomer : contactCustomerManagedBean.getAllContactCustomers())
            {
            	contactCustomers.add(contactCustomer);
            }

            setContactCustomers(contactCustomers);

    }
    
    public void searchContactCustomerById(int customerID)
    {
    	contactCustomers.clear();
        
    	contactCustomers.add(contactCustomerManagedBean.getContactCustomer(customerID));
    }
    
    
    public void searchAll()
    {
        contactCustomers.clear();
        
//        for (ContactCustomer contactCustomer : contactCustomerManagedBean.getAllContactCustomers())
//        {
//        	contactCustomers.add(contactCustomer);
//        }
        
        setContactCustomers(contactCustomerManagedBean.getAllContactCustomers());
    }

    
    public void addContactCustomer(fit5042.controllers.ContactCustomer localContactCustomer) {
       try
       {
    	   contactCustomerManagedBean.addContactCustomer(localContactCustomer);
           searchAll();
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contact Customer has been added succesfully"));
       }
       catch (Exception ex)
       {
           ex.printStackTrace();
       }
        showForm = true;
    }
    
    public fit5042.repository.entity.ContactCustomer getContactCustomer() {
    	HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    	if(req.getParameter("contactCustomerID")!=null) {
    		contactCustomerID = Integer.parseInt(req.getParameter("contactCustomerID"));
    	}
    	contactCustomer = contactCustomerManagedBean.getContactCustomer(contactCustomerID);
        return contactCustomer;
    }
    
    public void removeContactCustomer(int customerContactId) {
        try
        {
             contactCustomerManagedBean.removeContactCustomer(customerContactId);
             searchAll();
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been deleted succesfully"));     
        }
        catch (Exception ex)
        {
            
        }
        showForm = true;

     }
	
}
