package entity;

import java.util.ArrayList;
import java.util.Date;

import db.CustomerEntity;

/**
 * 
 * Customer entity business rules
 *
 */
public class Customer {
	private int customerId;
	private String pin;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	private Date creationDate;

/**
 * Class constructor
 */
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
	
/**
 * Class constructor
 * @param pin
 * @param firstName
 * @param lastName
 * @param address
 * @param phoneNumber
 * @param email
 * @param creationDate
 */
	public Customer(String pin, String firstName, String lastName, String address, String phoneNumber, String email, Date creationDate) {
		this.pin = pin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.creationDate = creationDate;
	}
	
/**
 * Class constructor
 * @param customerId
 * @param pin
 * @param firstName
 * @param lastName
 * @param address
 * @param phoneNumber
 * @param email
 * @param creationDate
 */
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

/**
 * Class constructor
 * @param inCustomer
 */
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

/** 
 * Sets customer ID
 * @param customerId
 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

/**
 * Sets PIN
 * @param pin
 */
	public void setPin(String pin) {
		this.pin = pin;
	}

/**
 * Sets first name
 * @param firstName
 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

/**
 * Sets last name
 * @param lastName
 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

/**
 * Sets address
 * @param address
 */
	public void setAddress(String address) {
		this.address = address;
	}

/**
 * Sets phone number
 * @param phoneNumber
 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

/**
 * Sets email
 * @param email
 */
	public void setEmail(String email) {
		this.email = email;
	}

/**
 * Sets creation date
 * @param creationDate
 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

/**
 * Gets customer ID
 * @return
 */
	public int getCustomerId() {
		return customerId;
	}

/**
 * Gets PIN
 * @return
 */
	public String getPin() {
		return pin;
	}

/**
 * Gets first name
 * @return
 */
	public String getFirstName() {
		return firstName;
	}

/**
 * Gets last name
 * @return
 */
	public String getLastName() {
		return lastName;
	}
	
/**
 * Gets full name
 * @return
 */
	public String getFullName() { return firstName + " " + lastName; }

/**
 * Gets address
 * @return
 */
	public String getAddress() {
		return address;
	}

/**
 * Gets email
 * @return
 */
	public String getEmail() {
		return email;
	}

/**
 * Gets phone number
 * @return
 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

/**
 * Gets creation date
 * @return
 */
	public Date getCreationDate() {
		return creationDate;
	}

/**
 * Gets customer information
 * @param activeCustomer
 * @param customerAccounts
 * @param result
 */
	public void viewCustomer(Customer activeCustomer, ArrayList<Account> customerAccounts, Return result) {
		customerAccounts.clear();
		CustomerEntity.viewCustomer(activeCustomer, customerAccounts, result);
	}

/**
 * Updates a customer
 * @param activeCustomer
 * @param result
 */
	public void updateCustomer(Customer activeCustomer, Return result) {
		CustomerEntity.updateCustomer(activeCustomer, result);
	}

/**
 * Deletes a customer
 * @param activeCustomer
 * @param activeAgent
 * @param result
 */
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
