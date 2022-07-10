package entity;

import java.util.ArrayList;
import java.util.Date;

import db.AccountEntity;
import db.CustomerEntity;

public class Account {
	private String accNumber;
	private String accType;
	private double balance;
	private double transferAmount;
	private int transferQuantity;
	private int customerId;
	private Date openDate;
	
	public Account() {
		this.accNumber = null;
		this.accType = null;
		this.balance = 0;
		this.transferAmount = 0;
		this.transferQuantity = 0;
		this.customerId = 0;
		this.openDate = null;
	}
	
	public Account(String accNumber, String accType, double balance, double transferAmount, int transferQuantity, int customerId, Date openDate) {
		this.accNumber = accNumber;
		this.accType = accType;
		this.balance = balance;
		this.transferAmount = transferAmount;
		this.transferQuantity = transferQuantity;
		this.customerId = customerId;
		this.openDate = openDate;
	}
	
	public Account(Account inAccount) {
		this.accNumber = inAccount.accNumber;
		this.accType = inAccount.accType;
		this.balance = inAccount.balance;
		this.transferAmount = inAccount.transferAmount;
		this.transferQuantity = inAccount.transferQuantity;
		this.customerId = inAccount.customerId;
		this.openDate = inAccount.openDate;
	}
	
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	
	public void setAccType(String accType) {
		this.accType = accType;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}
	
	public void setTransferQuantity(int transferQuantity) {
		this.transferQuantity = transferQuantity;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	
	public String getAccNumber() {
		return accNumber;
	}
	
	public String getAccType() {
		return accType;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getTransferAmount() {
		return transferAmount;
	}
	
	public int getTransferQuantity() {
		return transferQuantity;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public Date getOpenDate() {
		return openDate;
	}
	
	public void viewAccount(Customer inCustomer, Account inAccount, ArrayList<Movement> accountMovements) {
		CustomerEntity.getCustomerById(inCustomer, inAccount.getCustomerId());
		AccountEntity.viewAccount(inAccount, accountMovements);
	}
}
