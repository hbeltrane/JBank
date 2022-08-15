package entity;

import db.*;

import java.util.*;

import static db.ProductEntity.viewProductsDetail;

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
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public void setAmountLimit(double amountLimit) {
		this.amountLimit = amountLimit;
	}
	public void setQuantityLimit(int quantityLimit) {
		this.quantityLimit = quantityLimit;
	}
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	public String getProductType() { return productType; }
	public double getInterestRate() { return interestRate; }
	public double getAmountLimit() {
		return amountLimit;
	}
	
	public int getQuantityLimit() {
		return quantityLimit;
	}
	
	public double getMinimumBalance() { return minimumBalance; }
	public static String[] getProductsList(Return result) {
		ArrayList<String> productsType = new ArrayList<>();
		ProductEntity.viewProductsType(productsType, result);

		String[] productsTypeList = new String[productsType.size()];
		if (Objects.equals(result.getCode(), "00")) {
			for (int i = 0; i < productsType.size(); i++) {
				productsTypeList[i] = productsType.get(i);
			}
		}
		return productsTypeList;
	}
	public static String[] getProductsDetail(ArrayList<Product> products, Return result) {
		viewProductsDetail(products, result);
		String[] productsTypeList = new String[products.size()];
		if (Objects.equals(result.getCode(), "00")) {
			for (int i = 0; i < products.size(); i++) {
				productsTypeList[i] = products.get(i).getProductType();
			}
		}
		return productsTypeList;
	}
}
