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
	
	private int getCustomerId() {
		return customerId;
	}
	
	private String getPin() {
		return pin;
	}
	
	private String getFirstName() {
		return firstName;
	}
	
	private String getLastName() {
		return lastName;
	}
	
	private String getAddress() {
		return address;
	}
	
	private String getEmail() {
		return email;
	}
	
	private String getPhoneNumber() {
		return phoneNumber;
	}
	
	private Date getCreationDate() {
		return creationDate;
	}
}
