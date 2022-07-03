package entity;

public class Agent {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private int positionId;
	
	private Agent(String username, String password, String firstName, String lastName, int positionId) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.positionId = positionId;
	}

	private String getUsername() {
		return username;
	}
	
	private String getPassword() {
		return password;
	}
	
	private String getFirstName() {
		return firstName;
	}
	
	private String getLastName() {
		return lastName;
	}
	
	private int getPositionId() {
		return positionId;
	}
	
	public static int agentLogin(String username, String password) {
		int login = AgentEntity.validateAgent(username, password);
		if (login == 0) {
			Agent activeAgent = New Agent("SELECT * ");
		}
		return login;
	}
}
