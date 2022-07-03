package entity;

import java.util.Date;

public class Movement {
	private int movementId;
	private String sourceAccount;
	private String destinationAccount;
	private double amount;
	private double previousBalance;
	private double newBalance;
	private Date movementDate;
	private int transactionId;
	
	public Movement() {
		this.movementId = 0;
		this.sourceAccount = null;
		this.destinationAccount = null;
		this.amount = 0;
		this.previousBalance = 0;
		this.newBalance = 0;
		this.movementDate = null;
		this.transactionId = 0;
	}
	
	public Movement(int movementId, String sourceAccount, String destinationAccount, double amount, double previousBalance, double newBalance, Date movementDate, int transactionId) {
		this.movementId = movementId;
		this.sourceAccount = sourceAccount;
		this.destinationAccount = destinationAccount;
		this.amount = amount;
		this.previousBalance = previousBalance;
		this.newBalance = newBalance;
		this.movementDate = movementDate;
		this.transactionId = transactionId;
	}
	
	public void setMovementId(int movementId) {
		this.movementId = movementId;
	}
	
	public void setSourceAccount(String sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	
	public void setDestinationAccount(String destinationAccount) {
		this.destinationAccount = destinationAccount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void setPreviousBalance(double previousBalance) {
		this.previousBalance = previousBalance;
	}
	
	public void setNewBalance(double newBalance) {
		this.newBalance = newBalance;
	}
	
	public void setMovementDate(Date movementDate) {
		this.movementDate = movementDate;
	}
	
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	public int getMovementId() {
		return movementId;
	}
	
	public String getSourceAccount() {
		return sourceAccount;
	}
	
	public String getDestinationAccount() {
		return destinationAccount;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public double getPreviousBalance() {
		return previousBalance;
	}
	
	public double getNewBalance() {
		return newBalance;
	}
	
	public Date getMovementDate() {
		return movementDate;
	}
	
	public int getTransactionId() {
		return transactionId;
	}
}
