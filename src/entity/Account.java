package entity;

import java.util.Date;

public class Account {
	private String accNumber;
	private int accType;
	private double balance;
	private double transferAmount;
	private int transferQuantity;
	private int customerId;
	private Date openDate;
	
	public Account(String accNumber, int accType, double balance, double transferAmount, int transferQuantity, int customerId, Date openDate) {
		this.accNumber = accNumber;
		this.accType = accType;
		this.balance = balance;
		this.transferAmount = transferAmount;
		this.transferQuantity = transferQuantity;
		this.customerId = customerId;
		this.openDate = openDate;
	}
	
	private String getAccNumber() {
		return accNumber;
	}
	
	private int getAccType() {
		return accType;
	}
	
	private double getBalance() {
		return balance;
	}
	
	private double getTransferAmount() {
		return transferAmount;
	}
	
	private int getTransferQuantity() {
		return transferQuantity;
	}
	
	private int getCustomerId() {
		return customerId;
	}
	
	private Date getOpenDate() {
		return openDate;
	}
}
