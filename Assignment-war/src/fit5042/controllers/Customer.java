package fit5042.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import fit5042.repository.entity.Address;
import fit5042.repository.entity.ContactCustomer;


@RequestScoped
@Named(value = "customer")
public class Customer implements Serializable {
	private int customerID;
	private String customerFirstName;
	private String customerLastName;
	private String customerPhone;
	private String customerEmail;
	private Address customerAddress;
	private String customerTypeOfIndustry;
	
	private String streetNumber;
    private String streetAddress;
    private String suburb;
    private String postcode;
    private String state;

	List<ContactCustomer> customerContactCustomer;
    
    private Set<Customer> customers;

        
    public Customer() {
    }
    
	public Customer(int customerID, String customerFirstName, String customerLastName, String customerPhone,
			String customerEmail, Address customerAddress,
			String customerTypeOfIndustry) {
		super();
		this.customerID = customerID;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.customerTypeOfIndustry = customerTypeOfIndustry;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public Address getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}
	public List<ContactCustomer> getCustomerContactPerson() {
		return customerContactCustomer;
	}
	public void setCustomerContactPerson(List<ContactCustomer> customerContactCustomer) {
		this.customerContactCustomer = customerContactCustomer;
	}
	public String getCustomerTypeOfIndustry() {
		return customerTypeOfIndustry;
	}
	public void setCustomerTypeOfIndustry(String customerTypeOfIndustry) {
		this.customerTypeOfIndustry = customerTypeOfIndustry;
	}
	
	
	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

    
}
