package entity;

import java.util.ArrayList;
import java.util.Date;

import db.AccountEntity;
import db.CustomerEntity;
import db.MovementEntity;

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
	
	public void viewAccount(Customer activeCustomer, Account activeAccount, ArrayList<Movement> accountMovements, Return result) {
		accountMovements = new ArrayList<Movement>();
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
		int txId = 9;
		double fee = MovementEntity.checkFee(txId, activeMovement, result);
		if (result.getCode() == "00") {
			AccountEntity.checkLimits(activeAccount, activeProduct, result);
			if (result.getCode() == "00") {
				activeMovement.setAmount(activeMovement.getAmount() - fee);
				activeMovement.setPreviousBalance(activeAccount.getBalance());
				activeMovement.setNewBalance(activeAccount.getBalance() + activeMovement.getAmount());
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
	
	public void transfer(boolean transferOwn, Movement activeMovement, Account activeAccount, String destinationAccount, Agent activeAgent, Return result) {
		if ((activeAccount.getCustomerId() == AccountEntity.searchAccount(destinationAccount, result) && transferOwn) || (activeAccount.getCustomerId() != AccountEntity.searchAccount(destinationAccount, result) && !transferOwn)) {
			if (result.getCode() == "00") {
				activeMovement.setDestinationAccount(destinationAccount);
			}
		}
		else if (transferOwn) {
			result.setCode("06");
		}
		else if (!transferOwn) {
			result.setCode("06");
		}
		if (result.getCode() == "00") {
			Product activeProduct = new Product();
			int txId = 9;
			double fee = MovementEntity.checkFee(txId, activeMovement, result);
			if (result.getCode() == "00") {
				AccountEntity.checkLimits(activeAccount, activeProduct, result);
				if (result.getCode() == "00") {
					activeMovement.setAmount(activeMovement.getAmount() - fee);
					activeMovement.setPreviousBalance(activeAccount.getBalance());
					activeMovement.setNewBalance(activeAccount.getBalance() + activeMovement.getAmount());
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
					}
				}
			}
		}
	}
}
