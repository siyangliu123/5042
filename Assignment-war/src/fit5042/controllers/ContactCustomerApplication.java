package fit5042.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.mbeans.ContactCustomerManagedBean;
import fit5042.repository.entity.ContactCustomer;


@Named(value = "contactCustomerApplication")
@ApplicationScoped

public class ContactCustomerApplication {
	@ManagedProperty(value="#{contactCustomerManagedBean}") 
    ContactCustomerManagedBean contactCustomerManagedBean;
    
    private ArrayList<ContactCustomer> contactCustomers;

    private boolean showForm = true;
  
    public boolean isShowForm() {
        return showForm;
    }

    public ContactCustomerApplication() throws Exception {       
        contactCustomers = new ArrayList<>();
        
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        contactCustomerManagedBean = (ContactCustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "contactCustomerManagedBean");
        
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        String username = ec.getRemoteUser();
        searchAll();
    }

    public ArrayList<ContactCustomer> getContactCustomers() {
        return contactCustomers;
    }
    
    private void setContactCustomers(ArrayList<ContactCustomer> newContactCustomers) {
        this.contactCustomers = newContactCustomers;
    }
    
    public void updateContactCustomerList(String username)
    {
    	
        if (contactCustomers != null && contactCustomers.size() > 0)
        {
            
        }
        else
        {
        	contactCustomers.clear();

        		for (ContactCustomer contactCustomer : contactCustomerManagedBean.getAllContactCustomers())
                {
                	contactCustomers.add(contactCustomer);
                }
            

            setContactCustomers(contactCustomers);
        }
    }
    
    public void searchContactCustomerById(int contactCustomerID)
    {
    	contactCustomers.clear();
        
    	contactCustomers.add(contactCustomerManagedBean.getContactCustomer(contactCustomerID));
    }
    
    
    
    public void searchAll()
    {
        contactCustomers.clear();
        
        for (ContactCustomer contactCustomer : contactCustomerManagedBean.getAllContactCustomers())
        {
        	contactCustomers.add(contactCustomer);
        }
        
        setContactCustomers(contactCustomers);
    }
}
