package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import db.AgentEntity;

public class Agent {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private int positionId;
	
	public Agent() {
		this.username = null;
		this.password = null;
		this.firstName = null;
		this.lastName = null;
		this.positionId = 0;
	}
	
	public Agent(String username, String password, String firstName, String lastName, int positionId) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.positionId = positionId;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public String getFullName() { return firstName + " " + lastName; }
	
	public int getPositionId() {
		return positionId;
	}
	
	public void agentLogin(String username, String password, Agent activeAgent, Return result) {
		AgentEntity.validateAgent(username, activeAgent, result);
		if (result.getCode() == "00") {
			if (!password.equals(activeAgent.getPassword()))
				result.setCode("02");
		}
	}
	
	public void agentCreateCustomer(Customer activeCustomer, Agent activeAgent, Return result) {
		AgentEntity.createCustomer(activeCustomer, activeAgent, result);
	}
	
	public void agentSearchCustomers(String searchString, ArrayList<Customer> customersResult, Return result) {
		customersResult.clear();
		if (searchString.length() > 2)
			AgentEntity.searchCustomers(searchString, customersResult, result);
	}
	
	public void agentSearchAccounts(String searchString, ArrayList<Account> accountsResult, Return result) {
		accountsResult.clear();
		if (searchString.length() > 2)
			AgentEntity.searchAccounts(searchString, accountsResult, result);
	}
	
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
			Integer tempAccountNumber = (accTypeA * 100000000) + (1 + (int) (Math.random() * 10000000));
			while (existingAccounts.contains(tempAccountNumber)) {
				Random randNum = new Random();
				if (randNum.nextBoolean()) {
					tempAccountNumber = (accTypeB * 100000000) + (1 + (int) (Math.random() * 10000000));
				}
				else {
					tempAccountNumber = (accTypeC * 100000000) + (1 + (int) (Math.random() * 10000000));
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
