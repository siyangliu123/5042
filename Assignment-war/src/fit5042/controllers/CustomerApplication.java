package fit5042.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.mbeans.CustomerManagedBean;
import fit5042.repository.entity.Customer;


@Named(value = "customerApplication")
@ApplicationScoped

public class CustomerApplication {
	@ManagedProperty(value="#{customerManagedBean}") 
    CustomerManagedBean customerManagedBean;
    
    private ArrayList<Customer> customers;

    private boolean showForm = true;
  
    public boolean isShowForm() {
        return showForm;
    }

    public CustomerApplication() throws Exception {       
        customers = new ArrayList<>();
        
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "customerManagedBean");
        
        updateCustomerList();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    
    private void setCustomers(ArrayList<Customer> newCustomers) {
        this.customers = newCustomers;
    }
    
    public void updateCustomerList()
    {
        if (customers != null && customers.size() > 0)
        {
            
        }
        else
        {
        	customers.clear();

            for (Customer customer : customerManagedBean.getAllCustomers())
            {
            	customers.add(customer);
            }

            setCustomers(customers);
        }
    }
    
    public void searchCustomerById(int customerID)
    {
    	customers.clear();
        
    	customers.add(customerManagedBean.getCustomer(customerID));
    }
    
    public void searchCustomerByTypeOfIndustry(String typeOfIndustry) {
    	customers.clear();

        for (Customer customer : customerManagedBean.searchCustomerByTypeOfIndustry(typeOfIndustry)) {
        	customers.add(customer);
        }

        setCustomers(customers);
    }
    
    
    public void searchAll()
    {
        customers.clear();
        
        for (Customer customer : customerManagedBean.getAllCustomers())
        {
        	customers.add(customer);
        }
        
        setCustomers(customers);
    }
}
