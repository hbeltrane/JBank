package entity;

import java.util.ArrayList;
import java.util.Date;

import db.CustomerEntity;

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
	
	public Customer(Customer inCustomer) {
		this.customerId = inCustomer.customerId;
		this.pin = inCustomer.pin;
		this.firstName = inCustomer.firstName;
		this.lastName = inCustomer.lastName;
		this.address = inCustomer.address;
		this.phoneNumber = inCustomer.phoneNumber;
		this.email = inCustomer.email;
		this.creationDate = inCustomer.creationDate;
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
	public String getFullName() { return firstName + " " + lastName; }
	
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
	
	public void viewCustomer(Customer activeCustomer, ArrayList<Account> customerAccounts, Return result) {
		customerAccounts = new ArrayList<Account>();
		CustomerEntity.viewCustomer(activeCustomer, customerAccounts, result);
	}
	
	public void updateCustomer(Customer activeCustomer, Return result) {
		CustomerEntity.updateCustomer(activeCustomer, result);
	}
	
	public void deleteCustomer(Customer activeCustomer, Agent activeAgent, Return result) {
		ArrayList<Account> customerAccounts = new ArrayList<Account>();
		CustomerEntity.viewCustomer(activeCustomer, customerAccounts, result);
		if (customerAccounts.size() > 0) {
			result.setCode("04");
		}
		else {
			CustomerEntity.deleteCustomer(activeCustomer, activeAgent, result);
		}
	}
}
