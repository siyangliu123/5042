package fit5042.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.mbeans.ContactCustomerManagedBean;
import fit5042.repository.entity.ContactCustomer;


@RequestScoped
@Named("addContactCustomer")
public class AddContactCustomer {
    @ManagedProperty(value="#{contactCustomerManagedBean}") 
    ContactCustomerManagedBean contactCustomerManagedBean;
    
    private boolean showForm = true;

    private ContactCustomer contactCustomer;
    
    ContactCustomerApplication app;
    
    public void setContactCustomer(ContactCustomer ContactCustomer){
        this.contactCustomer = ContactCustomer;
    }
    
    public ContactCustomer getContactCustomer(){
        return contactCustomer;
    }
    
    public boolean isShowForm() {
        return showForm;
    }

    public AddContactCustomer() 
    {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app  = (ContactCustomerApplication) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "contactCustomerApplication");
        
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        contactCustomerManagedBean = (ContactCustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "contactCustomerManagedBean");
    }

    public void addContactCustomer(fit5042.controllers.ContactCustomer localContactCustomer) {
 	   
       try
       {

    	   contactCustomerManagedBean.addContactCustomer(localContactCustomer);
           app.searchAll();
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ContactCustomer has been added succesfully"));
       }
       catch (Exception ex)
       {
           
       }
        showForm = true;
    }
   
}

