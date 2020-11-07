package fit5042.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CONTACT_CUSTOMER")
@NamedQueries({@NamedQuery(name = ContactCustomer.GET_ALL_QUERY_NAME, query = "SELECT c FROM ContactCustomer c")})
public class ContactCustomer implements Serializable{
	public static final String GET_ALL_QUERY_NAME = "ContactCustomer.getAll";
	@Id
    @GeneratedValue
    @Column(name = "contact_customer_id")
	private int contactCustomerID;
    @Column
	private String contactCustomerFirstName;
    @Column
	private String contactCustomerLastName;
    @Column
	private String contactCustomerPhone;
    @Column
	private String contactCustomerEmail;

	private int customerID;
    
    public ContactCustomer() {
    	
    }
	
	public int getContactCustomerID() {
		return contactCustomerID;
	}
	public void setContactCustomerID(int contactCustomerID) {
		this.contactCustomerID = contactCustomerID;
	}
	public String getContactCustomerFirstName() {
		return contactCustomerFirstName;
	}
	public void setContactCustomerFirstName(String contactCustomerFirstName) {
		this.contactCustomerFirstName = contactCustomerFirstName;
	}
	public String getContactCustomerLastName() {
		return contactCustomerLastName;
	}
	public void setContactCustomerLastName(String contactCustomerLastName) {
		this.contactCustomerLastName = contactCustomerLastName;
	}
	public String getContactCustomerPhone() {
		return contactCustomerPhone;
	}
	public void setContactCustomerPhone(String contactCustomerPhone) {
		this.contactCustomerPhone = contactCustomerPhone;
	}
	public String getContactCustomerEmail() {
		return contactCustomerEmail;
	}
	public void setContactCustomerEmail(String contactCustomerEmail) {
		this.contactCustomerEmail = contactCustomerEmail;
	}
    @ManyToOne
    @JoinColumn(name = "customer_id")
	public int getContactCustomer() {
		return customerID;
	}
	public void setContactCustomer(int customerID) {
		this.customerID = customerID;
	}
    
    
    
}
