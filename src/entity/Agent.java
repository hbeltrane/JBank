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
	
	public int getPositionId() {
		return positionId;
	}
	
	public int agentLogin(String username, String password, Agent activeAgent) {
		int status = AgentEntity.validateAgent(username, activeAgent);
		if (status == 0) {
			if (password.equals(activeAgent.getPassword()))
				return 0;
			else
				return 2;
		}
		else
			return status;
	}
	
	public void agentSearch(String searchString, ArrayList<Customer> customersResult, ArrayList<Account> accountsResult) {
		AgentEntity.searchCustomers(searchString, customersResult);
		AgentEntity.searchAccounts(searchString, accountsResult);
	}
}
