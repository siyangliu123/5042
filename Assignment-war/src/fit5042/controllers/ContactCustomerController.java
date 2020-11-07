package fit5042.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "contactCustomerController")
@RequestScoped
public class ContactCustomerController {

    private int contactCustomerID;
    
    public int getContactCustomerID() {
        return contactCustomerID;
    }

    public void setContactCustomerID(int contactCustomerID) {
        this.contactCustomerID = contactCustomerID;
    }
    private fit5042.repository.entity.ContactCustomer contactCustomer;
    

    public ContactCustomerController() {
    	contactCustomerID = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("contactCustomerID"));
        contactCustomer = getContactCustomer();
    }

    public fit5042.repository.entity.ContactCustomer getContactCustomer() {
        if (contactCustomer == null) {
            ELContext context
                    = FacesContext.getCurrentInstance().getELContext();
            ContactCustomerApplication app
                    = (ContactCustomerApplication) FacesContext.getCurrentInstance()
                            .getApplication()
                            .getELResolver()
                            .getValue(context, null, "contactCustomerApplication");
            return app.getContactCustomers().get(--contactCustomerID); 
        }
        return contactCustomer;
    }
}
