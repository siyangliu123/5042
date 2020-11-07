package fit5042.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "customerController")
@RequestScoped
public class CustomerController {

    private int customerID;
    
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    private fit5042.repository.entity.Customer customer;
    

    public CustomerController() {
    	customerID = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("customerID"));
        customer = getCustomer();
    }

    public fit5042.repository.entity.Customer getCustomer() {
        if (customer == null) {
            ELContext context
                    = FacesContext.getCurrentInstance().getELContext();
            CustomerApplication app
                    = (CustomerApplication) FacesContext.getCurrentInstance()
                            .getApplication()
                            .getELResolver()
                            .getValue(context, null, "customerApplication");
            return app.getCustomers().get(--customerID); 
        }
        return customer;
    }
}
