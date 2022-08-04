package entity;

public class Product {
	private String productType;
	private double interestRate;
	private double amountLimit;
	private int quantityLimit;
	private double minimumBalance;
	
	public Product() {
		this.productType = "";
		this.interestRate = 0;
		this.amountLimit = 0;
		this.quantityLimit = 0;
		this.minimumBalance = 0;
	}
	
	public Product(String productType, double interestRate, double amountLimit, int quantityLimit, double minimumBalance) {
		this.productType = productType;
		this.interestRate = interestRate;
		this.amountLimit = amountLimit;
		this.quantityLimit = quantityLimit;
		this.minimumBalance = minimumBalance;
	}
	
	public double getAmountLimit() {
		return amountLimit;
	}
	
	public int getQuantityLimit() {
		return quantityLimit;
	}
	
	public double getMinimumBalance() {
		return minimumBalance;
	}
}
