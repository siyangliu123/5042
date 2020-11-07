package fit5042.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.repository.entity.Customer;

@RequestScoped
@Named("searchCustomer")
public class SearchCustomer {
    private boolean showForm = true;

    private Customer customer;

    CustomerApplication app;

    private int searchByInt;
    private String searchByString;

    private int contactPersonId;

    public int getContactPersonId() {

        return contactPersonId;
    }

    public void setContactPersonId(int contactPersonId) {
        this.contactPersonId = contactPersonId;
    }

    public CustomerApplication getApp() {
        return app;
    }

    public void setApp(CustomerApplication app) {
        this.app = app;
    }
    private String typeOfIndustry;

    public String getSearchByString() {
        return searchByString;
    }

    public void setSearchByString(String searchByString) {
        this.searchByString = searchByString;
    }

    public int getSearchByInt() {
        return searchByInt;
    }

    public void setSearchByInt(int searchByInt) {
        this.searchByInt = searchByInt;
    }

    public String getSearchByTypeOfIndustry() {
        return typeOfIndustry;
    }

    public void setSearchByTypeOfIndustry(String typeOfIndustry) {
        this.typeOfIndustry = typeOfIndustry;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isShowForm() {
        return showForm;
    }

    public SearchCustomer() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (CustomerApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "customerApplication");

        app.updateCustomerList();
    }

    /**
     * @param customer Id
     */
    public void searchCustomerById(int customerId) {
        try {
            app.searchCustomerById(customerId);
        } catch (Exception ex) {

        }
        showForm = true;

    }

    public void searchCustomerByTypeOfIndustry(String typeOfIndustry) {
        try {
            app.searchCustomerByTypeOfIndustry(typeOfIndustry);
        } catch (Exception ex) {

        }
        showForm = true;
    }

//    public void searchCustomerByContactPersonId(int contactPersonId) {
//        try {
//        	int p = contactPersonId;
//            //search all properties by contact person from db via EJB 
//            app.searchCustomerByContactPersonId(contactPersonId);
//        } catch (Exception ex) {
//
//        }
//        showForm = true;
//    }

    public void searchAll() {
        try {
            //return all properties from db via EJB
            app.searchAll();
        } catch (Exception ex) {

        }
        showForm = true;
    }
}
