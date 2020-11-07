package fit5042.repository.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
@NamedQueries({@NamedQuery(name = Customer.GET_ALL_QUERY_NAME, query = "SELECT c FROM Customer c")})
public class Customer implements Serializable{
	public static final String GET_ALL_QUERY_NAME = "Customer.getAll";
	
    @Id
    @GeneratedValue
    @Column(name = "customer_id")
	private int customerID;
    @Column
	private String customerFirstName;
    @Column
	private String customerLastName;
    @Column
	private String customerPhone;
    @Column
	private String customerEmail;
    @Column
	private Address customerAddress;
    private List<ContactCustomer> customerContactCustomer;
    @Column
	private String customerTypeOfIndustry;
	

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
	@Embedded
	public Address getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}
    @OneToMany(mappedBy = "contactCustomer", targetEntity = ContactCustomer.class, cascade = { CascadeType.ALL}, fetch=FetchType.EAGER)
	public List<ContactCustomer> getCustomerContactCustomer() {
		return customerContactCustomer;
	}
	public void setCustomerContactCustomer(List<ContactCustomer> customerContactCustomer) {
		this.customerContactCustomer = customerContactCustomer;
	}
	public String getCustomerTypeOfIndustry() {
		return customerTypeOfIndustry;
	}
	public void setCustomerTypeOfIndustry(String customerTypeOfIndustry) {
		this.customerTypeOfIndustry = customerTypeOfIndustry;
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
	
	

}
