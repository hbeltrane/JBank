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
	
	private Movement(int movementId, String sourceAccount, String destinationAccount, double amount, double previousBalance, double newBalance, Date movementDate, int transactionId) {
		this.movementId = movementId;
		this.sourceAccount = sourceAccount;
		this.destinationAccount = destinationAccount;
		this.amount = amount;
		this.previousBalance = previousBalance;
		this.newBalance = newBalance;
		this.movementDate = movementDate;
		this.transactionId = transactionId;
	}
	
	private int getMovementId() {
		return movementId;
	}
	
	private String getSourceAccount() {
		return sourceAccount;
	}
	
	private String getDestinationAccount() {
		return destinationAccount;
	}
	
	private double getAmount() {
		return amount;
	}
	
	private double getPreviousBalance() {
		return previousBalance;
	}
	
	private double getNewBalance() {
		return newBalance;
	}
	
	private Date getMovementDate() {
		return movementDate;
	}
	
	private int getTransactionId() {
		return transactionId;
	}
}
