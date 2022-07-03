package entity;

import java.util.Date;

public class Customer {
	private int customerId;
	private String pin;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	private Date creationDate;
	
	public Customer() {
		this.customerId = 0;
		this.pin = null;
		this.firstName = null;
		this.lastName = null;
		this.address = null;
		this.phoneNumber = null;
		this.email = null;
		this.creationDate = null;
	}
	
	public Customer(int customerId, String pin, String firstName, String lastName, String address, String phoneNumber, String email, Date creationDate) {
		this.customerId = customerId;
		this.pin = pin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.creationDate = creationDate;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public String getPin() {
		return pin;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
}
