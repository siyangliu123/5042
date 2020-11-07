package fit5042.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.mbeans.ContactCustomerManagedBean;


@RequestScoped
@Named("removeContactCustomer")
public class RemoveContactCustomer {
    @ManagedProperty(value="#{contactCustomerManagedBean}") 
    ContactCustomerManagedBean contactCustomerManagedBean;
    
    private boolean showForm = true;
    private ContactCustomer contactCustomer;
    ContactCustomerApplication app;
    
    public void setContactCustomer(ContactCustomer contactCustomer){
        this.contactCustomer = contactCustomer;
    }
    
    public ContactCustomer getContactCustomer(){
        return contactCustomer;
    }
    
    public boolean isShowForm() {
        return showForm;
    }

    public RemoveContactCustomer() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (ContactCustomerApplication) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "contactCustomerApplication");
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        String username = ec.getRemoteUser();
        app.updateContactCustomerList(username);
        
        //instantiate contactCustomerManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        contactCustomerManagedBean = (ContactCustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "contactCustomerManagedBean");
    }


    public void removeContactCustomer(int contactCustomerId) {
       try
       {
            contactCustomerManagedBean.removeContactCustomer(contactCustomerId);
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            String username = ec.getRemoteUser();
            app.updateContactCustomerList(username);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ContactCustomer has been deleted succesfully"));     
       }
       catch (Exception ex)
       {
           
       }
       showForm = true;

    }
 
}

