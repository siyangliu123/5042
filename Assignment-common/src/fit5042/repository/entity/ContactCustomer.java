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
    @Column
	private String createdBy;

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
    @JoinColumn(name = "customerID")
	public int getContactCustomer() {
		return customerID;
	}
	public void setContactCustomer(int customerID) {
		this.customerID = customerID;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactCustomerEmail == null) ? 0 : contactCustomerEmail.hashCode());
		result = prime * result + ((contactCustomerFirstName == null) ? 0 : contactCustomerFirstName.hashCode());
		result = prime * result + contactCustomerID;
		result = prime * result + ((contactCustomerLastName == null) ? 0 : contactCustomerLastName.hashCode());
		result = prime * result + ((contactCustomerPhone == null) ? 0 : contactCustomerPhone.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + customerID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactCustomer other = (ContactCustomer) obj;
		if (contactCustomerEmail == null) {
			if (other.contactCustomerEmail != null)
				return false;
		} else if (!contactCustomerEmail.equals(other.contactCustomerEmail))
			return false;
		if (contactCustomerFirstName == null) {
			if (other.contactCustomerFirstName != null)
				return false;
		} else if (!contactCustomerFirstName.equals(other.contactCustomerFirstName))
			return false;
		if (contactCustomerID != other.contactCustomerID)
			return false;
		if (contactCustomerLastName == null) {
			if (other.contactCustomerLastName != null)
				return false;
		} else if (!contactCustomerLastName.equals(other.contactCustomerLastName))
			return false;
		if (contactCustomerPhone == null) {
			if (other.contactCustomerPhone != null)
				return false;
		} else if (!contactCustomerPhone.equals(other.contactCustomerPhone))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (customerID != other.customerID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContactCustomer [contactCustomerID=" + contactCustomerID + ", contactCustomerFirstName="
				+ contactCustomerFirstName + ", contactCustomerLastName=" + contactCustomerLastName
				+ ", contactCustomerPhone=" + contactCustomerPhone + ", contactCustomerEmail=" + contactCustomerEmail
				+ ", createdBy=" + createdBy + ", customerID=" + customerID + "]";
	}
	
    
    
    
}
