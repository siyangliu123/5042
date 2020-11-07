package fit5042.controllers;

import java.io.Serializable;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named(value = "contactCustomer")
public class ContactCustomer implements Serializable {
	
	private int contactCustomerID;
	private String contactCustomerFirstName;
	private String contactCustomerLastName;
	private String contactCustomerPhone;
	private String contactCustomerEmail;
	private int customerID;
	
	Set<ContactCustomer> contactCustomers;

	public ContactCustomer(int contactCustomerID, String contactCustomerFirstName, String contactCustomerLastName,
			String contactCustomerPhone, String contactCustomerEmail) {
		super();
		this.contactCustomerID = contactCustomerID;
		this.contactCustomerFirstName = contactCustomerFirstName;
		this.contactCustomerLastName = contactCustomerLastName;
		this.contactCustomerPhone = contactCustomerPhone;
		this.contactCustomerEmail = contactCustomerEmail;
	}
	
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

	public Set<ContactCustomer> getContactCustomers() {
		return contactCustomers;
	}

	public void setContactCustomers(Set<ContactCustomer> contactCustomers) {
		this.contactCustomers = contactCustomers;
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
		result = prime * result + ((contactCustomers == null) ? 0 : contactCustomers.hashCode());
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
		if (contactCustomers == null) {
			if (other.contactCustomers != null)
				return false;
		} else if (!contactCustomers.equals(other.contactCustomers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ContactCustomer [contactCustomerID=" + contactCustomerID + ", contactCustomerFirstName="
				+ contactCustomerFirstName + ", contactCustomerLastName=" + contactCustomerLastName
				+ ", contactCustomerPhone=" + contactCustomerPhone + ", contactCustomerEmail=" + contactCustomerEmail
				+ ", contactCustomers=" + contactCustomers + "]";
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	

	

}
