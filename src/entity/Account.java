package entity;

import java.util.ArrayList;
import java.util.Date;

import db.AccountEntity;
import db.CustomerEntity;
import db.MovementEntity;

public class Account {
	private String accNumber;
	private String accType;
	private int accTypeId;
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
	
	public Account(String accNumber, String accType, int accTypeId, double balance, double transferAmount, int transferQuantity, int customerId, Date openDate) {
		this.accNumber = accNumber;
		this.accType = accType;
		this.accTypeId = accTypeId;
		this.balance = balance;
		this.transferAmount = transferAmount;
		this.transferQuantity = transferQuantity;
		this.customerId = customerId;
		this.openDate = openDate;
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
	
	public Account(String accType, double balance, double transferAmount, int transferQuantity, int customerId, Date openDate) {
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
	
	public void setAccTypeId(int accTypeId) {
		this.accTypeId = accTypeId;
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
	
	public String getAccType() { return accType; }
	
	public int getAccTypeId() {
		return accTypeId;
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
	
	public void viewAccount(Customer activeCustomer, Account activeAccount, ArrayList<Movement> accountMovements, Return result) {
		accountMovements.clear();
		CustomerEntity.getCustomerById(activeCustomer, activeAccount.getCustomerId(), result);
		if (result.getCode() == "00") {
			AccountEntity.viewAccount(activeAccount, accountMovements, result);
		}
	}
	
	public void deleteAccount(Account activeAccount, Agent activeAgent, Return result) {
		if (activeAccount.getBalance() == 0) {
			AccountEntity.deleteAccount(activeAccount, activeAgent, result);
		}
		else {
			result.setCode("05");
		}
	}
	
	public void deposit(Movement activeMovement, Account activeAccount, Agent activeAgent, Return result) {
		int txId = 7;
		double fee = MovementEntity.checkFee(txId, activeMovement, result);
		if (result.getCode() == "00") {
			activeMovement.setAmount(activeMovement.getAmount() - fee);
			activeMovement.setPreviousBalance(activeAccount.getBalance());
			activeMovement.setNewBalance(activeAccount.getBalance() + activeMovement.getAmount());
			activeAccount.setBalance(activeMovement.getNewBalance());
			MovementEntity.createTransaction(txId, activeMovement, activeAgent, result);
			AccountEntity.updateAccount(activeAccount, result);
		}
	}
	
	public void withdraw(Movement activeMovement, Account activeAccount, Agent activeAgent, Return result) {
		Product activeProduct = new Product();
		int txId = 8;
		double fee = MovementEntity.checkFee(txId, activeMovement, result);
		if (result.getCode() == "00") {
			AccountEntity.checkLimits(activeAccount, activeProduct, result);
			if (result.getCode() == "00") {
				activeMovement.setAmount(activeMovement.getAmount());
				activeMovement.setPreviousBalance(activeAccount.getBalance());
				activeMovement.setNewBalance(activeAccount.getBalance() - activeMovement.getAmount() - fee);
				if (activeMovement.getNewBalance() < activeProduct.getMinimumBalance()) {
					result.setCode("06");
				}
				else if (result.getCode() == "00") {
					activeAccount.setTransferAmount(activeAccount.getTransferAmount() + activeMovement.getAmount());
					activeAccount.setTransferQuantity(activeAccount.getTransferQuantity() + 1);
					activeAccount.setBalance(activeMovement.getNewBalance());
					MovementEntity.createTransaction(txId, activeMovement, activeAgent, result);
					AccountEntity.updateAccount(activeAccount, result);
				}
			}
		}
	}
	
	public void transfer(boolean transferOwn, Movement activeMovement, Account activeAccount, Agent activeAgent, Return result) {
		Account destinationAccount = new Account();
		//Movement destinationMovement = new Movement();
		destinationAccount.setAccNumber(activeMovement.getDestinationAccount());
		AccountEntity.searchAccount(destinationAccount, result);
		if (result.getCode() == "00") {
			if (!(activeAccount.getCustomerId() == destinationAccount.getCustomerId() && transferOwn) && !(activeAccount.getCustomerId() != destinationAccount.getCustomerId() && !transferOwn)) {
//				if (result.getCode() == "00") {
//					//activeMovement.setSourceAccount(activeAccount.getAccNumber());
//					//activeMovement.setDestinationAccount(destinationAccount.getAccNumber());
//				}
//			}
//			else {
				if (transferOwn) {
					result.setCode("11");
				}
				else {
					result.setCode("10");
				}
			}
		}
		else {
			result.setCode("99");
		}
		if (result.getCode() == "00") {
			Product activeProduct = new Product();
			int txId = 9;
			double fee = MovementEntity.checkFee(txId, activeMovement, result);
			if (result.getCode() == "00") {
				AccountEntity.checkLimits(activeAccount, activeProduct, result);
				if (result.getCode() == "00") {
					//activeMovement.setAmount(activeMovement.getAmount());
					activeMovement.setPreviousBalance(activeAccount.getBalance());
					activeMovement.setNewBalance(activeAccount.getBalance() - activeMovement.getAmount() - fee);
					if (activeMovement.getNewBalance() < activeProduct.getMinimumBalance()) {
						result.setCode("06");
					}
					else if (activeAccount.getTransferQuantity() > activeProduct.getAmountLimit()) {
						result.setCode("07");
					}
					else if (activeAccount.getTransferAmount() + activeMovement.getAmount() > activeProduct.getAmountLimit()) {
						result.setCode("08");
					}
					else if (result.getCode() == "00") {
						activeAccount.setTransferAmount(activeAccount.getTransferAmount() + activeMovement.getAmount());
						activeAccount.setTransferQuantity(activeAccount.getTransferQuantity() + 1);
						activeAccount.setBalance(activeMovement.getNewBalance());
						MovementEntity.createTransaction(txId, activeMovement, activeAgent, result);
						AccountEntity.updateAccount(activeAccount, result);
						// Update destination account
						//destinationMovement.setSourceAccount(activeAccount.getAccNumber());
						//destinationMovement.setDestinationAccount(destinationAccount.getAccNumber());
						//destinationMovement.setAmount(activeMovement.getAmount());
						//destinationMovement.setPreviousBalance(destinationAccount.getBalance());
						//destinationMovement.setNewBalance(destinationAccount.getBalance() + destinationMovement.getAmount());
						//destinationMovement.setDescription(activeMovement.getDescription());
						destinationAccount.setBalance(destinationAccount.getBalance() + activeMovement.getAmount());
						//MovementEntity.createTransaction(txId, destinationMovement, activeAgent, result);
						AccountEntity.updateAccount(destinationAccount, result);
					}
				}
			}
		}
	}
}
