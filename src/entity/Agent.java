package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import db.AgentEntity;
/**
 * 
 * Agent entity business rules
 *
 */
public class Agent {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private int positionId;

/**
 * Class constructor
 */
	public Agent() {
		this.username = null;
		this.password = null;
		this.firstName = null;
		this.lastName = null;
		this.positionId = 0;
	}

/**
 * Class constructor
 * @param username
 * @param password
 * @param firstName
 * @param lastName
 * @param positionId
 */
	public Agent(String username, String password, String firstName, String lastName, int positionId) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.positionId = positionId;
	}

/**
 * Sets username
 * @param username
 */
	public void setUsername(String username) {
		this.username = username;
	}

/** 
 * Sets password
 * @param password
 */
	public void setPassword(String password) {
		this.password = password;
	}

/**
 * Sets first name
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
 * Sets position ID
 * @param positionId
 */
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

/**
 * Gets username
 * @return
 */
	public String getUsername() {
		return username;
	}

/** 
 * Gets password
 * @return
 */
	public String getPassword() {
		return password;
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
 * Gets position ID
 * @return
 */
	public int getPositionId() {
		return positionId;
	}

/**
 * Performs agent login
 * @param username
 * @param password
 * @param activeAgent
 * @param result
 */
	public void agentLogin(String username, String password, Agent activeAgent, Return result) {
		AgentEntity.validateAgent(username, activeAgent, result);
		if (result.getCode() == "00") {
			if (!password.equals(activeAgent.getPassword()))
				result.setCode("02");
		}
	}

/**
 * Creates a new customer
 * @param activeCustomer
 * @param activeAgent
 * @param result
 */
	public void agentCreateCustomer(Customer activeCustomer, Agent activeAgent, Return result) {
		AgentEntity.createCustomer(activeCustomer, activeAgent, result);
	}

/**
 * Searches customers by a given string
 * @param searchString
 * @param customersResult
 * @param result
 */
	public void agentSearchCustomers(String searchString, ArrayList<Customer> customersResult, Return result) {
		customersResult.clear();
		if (searchString.length() > 1)
			AgentEntity.searchCustomers(searchString, customersResult, result);
	}

/**
 * Searches accounts by a given string
 * @param searchString
 * @param accountsResult
 * @param result
 */
	public void agentSearchAccounts(String searchString, ArrayList<Account> accountsResult, Return result) {
		accountsResult.clear();
		if (searchString.length() > 1)
			AgentEntity.searchAccounts(searchString, accountsResult, result);
	}

/**
 * Opens an account
 * @param activeAccount
 * @param activeAgent
 * @param result
 */
	public void openAccount(Account activeAccount, Agent activeAgent, Return result) {
		int accTypeA = 0;
		int accTypeB = 0;
		int accTypeC = 0;
		switch (activeAccount.getAccType()) {
		case ("Checking"):
			accTypeA = 1;
			accTypeB = 2;
			accTypeC = 3;
			break;
		case ("Saving"):
			accTypeA = 4;
			accTypeB = 5;
			accTypeC = 6;
			break;
		case ("Investing"):
			accTypeA = 7;
			accTypeB = 8;
			accTypeC = 9;
			break;
		}
		ArrayList<String> existingAccounts = new ArrayList<String>();
		AgentEntity.checkExistingAccounts(activeAccount, existingAccounts, Integer.toString(accTypeA), Integer.toString(accTypeB), Integer.toString(accTypeC), result);
		if (result.getCode() == "00") {
			Collections.sort(existingAccounts);
			Integer tempAccountNumber = (accTypeA * 100000000) + ((int) (Math.random() * 100000000));
			while (existingAccounts.contains(tempAccountNumber)) {
				Random randNum = new Random();
				if (randNum.nextBoolean()) {
					tempAccountNumber = (accTypeB * 100000000) + ((int) (Math.random() * 100000000));
				}
				else {
					tempAccountNumber = (accTypeC * 100000000) + ((int) (Math.random() * 100000000));
				}
			}
			activeAccount.setAccNumber(Integer.toString(tempAccountNumber));
			activeAccount.setBalance(0);
			activeAccount.setTransferAmount(0);
			activeAccount.setTransferQuantity(0);
			AgentEntity.openAccount(activeAccount, activeAgent, result);
		}
	}
}
