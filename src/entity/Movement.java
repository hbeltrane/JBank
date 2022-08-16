package entity;

import java.util.Date;

/**
 * 
 * Movement entity business rules
 *
 */
public class Movement {
	private int movementId;
	private String sourceAccount;
	private String destinationAccount;
	private double amount;
	private double previousBalance;
	private double newBalance;
	private Date movementDate;
	private String description;

/**
 * Class constructor
 */
	public Movement() {
		this.movementId = 0;
		this.sourceAccount = null;
		this.destinationAccount = null;
		this.amount = 0;
		this.previousBalance = 0;
		this.newBalance = 0;
		this.movementDate = null;
		this.description = null;
	}

/**
 * Class constructor
 * @param sourceAccount
 * @param destinationAccount
 * @param amount
 * @param previousBalance
 * @param newBalance
 * @param movementDate
 * @param description
 */
	public Movement(String sourceAccount, String destinationAccount, double amount, double previousBalance, double newBalance, Date movementDate, String description) {
		this.sourceAccount = sourceAccount;
		this.destinationAccount = destinationAccount;
		this.amount = amount;
		this.previousBalance = previousBalance;
		this.newBalance = newBalance;
		this.movementDate = movementDate;
		this.description = description;
	}
	
/**
 * Class constructor
 * @param movementId
 * @param sourceAccount
 * @param destinationAccount
 * @param amount
 * @param previousBalance
 * @param newBalance
 * @param movementDate
 * @param description
 */
	public Movement(int movementId, String sourceAccount, String destinationAccount, double amount, double previousBalance, double newBalance, Date movementDate, String description) {
		this.movementId = movementId;
		this.sourceAccount = sourceAccount;
		this.destinationAccount = destinationAccount;
		this.amount = amount;
		this.previousBalance = previousBalance;
		this.newBalance = newBalance;
		this.movementDate = movementDate;
		this.description = description;
	}

/**
 * Sets movement ID
 * @param movementId
 */
	public void setMovementId(int movementId) {
		this.movementId = movementId;
	}

/** 
 * Sets source account
 * @param sourceAccount
 */
	public void setSourceAccount(String sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

/**
 * Sets destination account
 * @param destinationAccount
 */
	public void setDestinationAccount(String destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

/**
 * Sets amount
 * @param amount
 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

/**
 * Sets previous balance
 * @param previousBalance
 */
	public void setPreviousBalance(double previousBalance) {
		this.previousBalance = previousBalance;
	}

/**
 * Sets new balance
 * @param newBalance
 */
	public void setNewBalance(double newBalance) {
		this.newBalance = newBalance;
	}

/**
 * Sets movement date
 * @param movementDate
 */
	public void setMovementDate(Date movementDate) {
		this.movementDate = movementDate;
	}

/**
 * Sets description
 * @param description
 */
	public void setDescription(String description) {
		this.description = description;
	}

/**
 * Gets movement ID
 * @return
 */
	public int getMovementId() {
		return movementId;
	}

/**
 * Gets source account
 * @return
 */
	public String getSourceAccount() {
		return sourceAccount;
	}

/**
 * Gets destination account
 * @return
 */
	public String getDestinationAccount() {
		return destinationAccount;
	}

/**
 * Gets amount
 * @return
 */
	public double getAmount() {
		return amount;
	}

/**
 * Gets previous balance
 * @return
 */
	public double getPreviousBalance() {
		return previousBalance;
	}

/**
 * Gets new balance
 * @return
 */
	public double getNewBalance() {
		return newBalance;
	}

/**
 * Gets movement date
 * @return
 */
	public Date getMovementDate() {
		return movementDate;
	}

/**
 * Gets description
 * @return
 */
	public String getDescription() {
		return description;
	}
}
