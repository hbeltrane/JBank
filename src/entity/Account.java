package entity;

import java.util.ArrayList;
import java.util.Date;

import db.AccountEntity;
import db.CustomerEntity;
import db.MovementEntity;
/**
 * 
 * Account entity business rules
 *
 */
public class Account {
	private String accNumber;
	private String accType;
	private int accTypeId;
	private double balance;
	private double transferAmount;
	private int transferQuantity;
	private int customerId;
	private Date openDate;
/**
 * Class constructor
 */
	public Account() {
		this.accNumber = null;
		this.accType = null;
		this.balance = 0;
		this.transferAmount = 0;
		this.transferQuantity = 0;
		this.customerId = 0;
		this.openDate = null;
	}
/**
 * Class constructor
 * @param accNumber
 * @param accType
 * @param accTypeId
 * @param balance
 * @param transferAmount
 * @param transferQuantity
 * @param customerId
 * @param openDate
 */
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

/**
 * Class constructor
 * @param accNumber
 * @param accType
 * @param balance
 * @param transferAmount
 * @param transferQuantity
 * @param customerId
 * @param openDate
 */
	public Account(String accNumber, String accType, double balance, double transferAmount, int transferQuantity, int customerId, Date openDate) {
		this.accNumber = accNumber;
		this.accType = accType;
		this.balance = balance;
		this.transferAmount = transferAmount;
		this.transferQuantity = transferQuantity;
		this.customerId = customerId;
		this.openDate = openDate;
	}

/**
 * Class constructor
 * @param accType
 * @param balance
 * @param transferAmount
 * @param transferQuantity
 * @param customerId
 * @param openDate
 */
	public Account(String accType, int accTypeId, double balance, double transferAmount, int transferQuantity, int customerId, Date openDate) {
		this.accType = accType;
		this.accTypeId = accTypeId;
		this.balance = balance;
		this.transferAmount = transferAmount;
		this.transferQuantity = transferQuantity;
		this.customerId = customerId;
		this.openDate = openDate;
	}

/**
 * Class constructor
 * @param inAccount
 */
	public Account(Account inAccount) {
		this.accNumber = inAccount.accNumber;
		this.accType = inAccount.accType;
		this.balance = inAccount.balance;
		this.transferAmount = inAccount.transferAmount;
		this.transferQuantity = inAccount.transferQuantity;
		this.customerId = inAccount.customerId;
		this.openDate = inAccount.openDate;
	}

/**
 * Sets account number
 * @param accNumber
 */
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

/**
 * Sets account type
 * @param accType
 */
	public void setAccType(String accType) {
		this.accType = accType;
	}

/**
 * Sets account type ID
 * @param accTypeId
 */
	public void setAccTypeId(int accTypeId) {
		this.accTypeId = accTypeId;
	}

/**
 * Sets balance
 * @param balance
 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

/**
 * Sets transfer amount
 * @param transferAmount
 */
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}

/**
 * Sets transfer quantity
 * @param transferQuantity
 */
	public void setTransferQuantity(int transferQuantity) {
		this.transferQuantity = transferQuantity;
	}

/**
 * Sets customer ID
 * @param customerId
 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

/**
 * Sets open date
 * @param openDate
 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

/**
 * Gets account number
 * @return
 */
	public String getAccNumber() {
		return accNumber;
	}

/**
 * Gets account type
 * @return
 */
	public String getAccType() { return accType; }

/** 
 * Gets account type ID
 * @return
 */
	public int getAccTypeId() {
		return accTypeId;
	}

/**
 * Gets balance
 * @return
 */
	public double getBalance() {
		return balance;
	}

/**
 * Gets transfer amount
 * @return
 */
	public double getTransferAmount() {
		return transferAmount;
	}

/**
 * Gets transfer quantity
 * @return
 */
	public int getTransferQuantity() {
		return transferQuantity;
	}

/** 
 * Gets customer ID
 * @return
 */
	public int getCustomerId() {
		return customerId;
	}

/**
 * Gets open date
 * @return
 */
	public Date getOpenDate() {
		return openDate;
	}

/**
 * Gets account information
 * @param activeCustomer
 * @param activeAccount
 * @param accountMovements
 * @param result
 */
	public void viewAccount(Customer activeCustomer, Account activeAccount, ArrayList<Movement> accountMovements, Return result) {
		accountMovements.clear();
		CustomerEntity.getCustomerById(activeCustomer, activeAccount.getCustomerId(), result);
		if (result.getCode() == "00") {
			AccountEntity.viewAccount(activeAccount, accountMovements, result);
		}
	}

/**
 * Deletes an account
 * @param activeAccount
 * @param activeAgent
 * @param result
 */
	public void deleteAccount(Movement activeMovement, Account activeAccount, Agent activeAgent, Return result) {
		result.setCode("00");
		if (activeAccount.getBalance() != 0) {
			int txId = 7;
			double fee = MovementEntity.checkFee(txId, activeMovement, result);
			activeMovement.setSourceAccount(activeAccount.getAccNumber());
			activeMovement.setAmount(activeAccount.getBalance() - fee);
			withdraw(activeMovement, activeAccount, activeAgent, result);
			activeMovement.setAmount(activeAccount.getBalance() - fee);
			result.setCode("05");
		}
		if (activeAccount.getBalance() == 0)
		AccountEntity.deleteAccount(activeAccount, activeAgent, result);
	}

/**
 * Performs deposit transaction
 * @param activeMovement
 * @param activeAccount
 * @param activeAgent
 * @param result
 */
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

/**
 * Performs withdrawal information
 * @param activeMovement
 * @param activeAccount
 * @param activeAgent
 * @param result
 */
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

/**
 * Performs transfer transactions
 * @param transferOwn
 * @param activeMovement
 * @param activeAccount
 * @param activeAgent
 * @param result
 */
	public void transfer(boolean transferOwn, Movement activeMovement, Account activeAccount, Agent activeAgent, Return result) {
		Account destinationAccount = new Account();
		destinationAccount.setAccNumber(activeMovement.getDestinationAccount());
		AccountEntity.searchAccount(destinationAccount, result);
		if (result.getCode() == "00") {
			if (!(activeAccount.getCustomerId() == destinationAccount.getCustomerId() && transferOwn) && !(activeAccount.getCustomerId() != destinationAccount.getCustomerId() && !transferOwn)) {
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
						destinationAccount.setBalance(destinationAccount.getBalance() + activeMovement.getAmount());
						AccountEntity.updateAccount(destinationAccount, result);
					}
				}
			}
		}
	}
}
