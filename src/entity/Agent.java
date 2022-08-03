package entity;

import java.util.ArrayList;
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
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public int getPositionId() {
		return positionId;
	}
	
	public void agentLogin(String username, String password, Agent activeAgent, Return result) {
		AgentEntity.validateAgent(username, activeAgent, result);
		if (result.getCode().equals("00")) {
			if (!password.equals(activeAgent.getPassword()))
				result.setCode("02");
		}
	}
	
	public void agentCreateCustomer(Customer inCustomer, Agent activeAgent, Return result) {
		AgentEntity.createCustomer(inCustomer, activeAgent, result);
	}
	
	public void agentSearchCustomers(String searchString, ArrayList<Customer> customersResult, Return result) {
		AgentEntity.searchCustomers(searchString, customersResult, result);
	}
	
	public void agentSearchAccounts(String searchString, ArrayList<Account> accountsResult, Return result) {
		AgentEntity.searchAccounts(searchString, accountsResult, result);
	}
}
