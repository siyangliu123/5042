package fit5042.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.mbeans.CustomerManagedBean;


@RequestScoped
@Named("removeCustomer")
public class RemoveCustomer {
    @ManagedProperty(value="#{customerManagedBean}") 
    CustomerManagedBean customerManagedBean;
    
    private boolean showForm = true;
    private Customer customer;
    CustomerApplication app;
    
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public boolean isShowForm() {
        return showForm;
    }

    public RemoveCustomer() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (CustomerApplication) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "customerApplication");
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        String username = ec.getRemoteUser();
        app.updateCustomerList(username);
        
        //instantiate customerManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "customerManagedBean");
    }


    public void removeCustomer(int customerId) {
       try
       {
            customerManagedBean.removeCustomer(customerId);
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            String username = ec.getRemoteUser();
            app.updateCustomerList(username);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been deleted succesfully"));     
       }
       catch (Exception ex)
       {
           
       }
       showForm = true;

    }
 
}

