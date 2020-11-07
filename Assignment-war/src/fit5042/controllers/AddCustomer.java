package fit5042.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.mbeans.CustomerManagedBean;
import fit5042.repository.entity.Customer;


@RequestScoped
@Named("addCustomer")
public class AddCustomer {
    @ManagedProperty(value="#{customerManagedBean}") 
    CustomerManagedBean customerManagedBean;
    
    private boolean showForm = true;

    private Customer customer;
    
    CustomerApplication app;
    
    public void setCustomer(Customer Customer){
        this.customer = Customer;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public boolean isShowForm() {
        return showForm;
    }

    public AddCustomer() 
    {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app  = (CustomerApplication) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "customerApplication");
        
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "customerManagedBean");
    }

    public void addCustomer(fit5042.controllers.Customer localCustomer) {
 	   
       try
       {

    	   customerManagedBean.addCustomer(localCustomer);
           app.searchAll();
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been added succesfully"));
       }
       catch (Exception ex)
       {
           
       }
        showForm = true;
    }
   
}

