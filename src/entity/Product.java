package entity;

import db.*;

import java.util.*;

import static db.ProductEntity.viewProductsDetail;

/**
 * 
 * Product entity business rules
 *
 */
public class Product {

	private String productType;
	private double interestRate;
	private double amountLimit;
	private int quantityLimit;
	private double minimumBalance;

/**
 * Class constructor
 */
	public Product() {
		this.productType = "";
		this.interestRate = 0;
		this.amountLimit = 0;
		this.quantityLimit = 0;
		this.minimumBalance = 0;
	}

/**
 * Class constructor
 * @param productType
 * @param interestRate
 * @param amountLimit
 * @param quantityLimit
 * @param minimumBalance
 */
	public Product(String productType, double interestRate, double amountLimit, int quantityLimit, double minimumBalance) {
		this.productType = productType;
		this.interestRate = interestRate;
		this.amountLimit = amountLimit;
		this.quantityLimit = quantityLimit;
		this.minimumBalance = minimumBalance;
	}
	
/**
 * Sets product type
 * @param productType
 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
/**
 * Sets interest rate
 * @param interestRate
 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
/**
 * Sets amount limit
 * @param amountLimit
 */
	public void setAmountLimit(double amountLimit) {
		this.amountLimit = amountLimit;
	}
	
/**
 * Sets quantity limit
 * @param quantityLimit
 */
	public void setQuantityLimit(int quantityLimit) {
		this.quantityLimit = quantityLimit;
	}
	
/**
 * Sets minimum balance
 * @param minimumBalance
 */
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	
/**
 * Gets product type
 * @return
 */
	public String getProductType() { return productType; }
	
/**
 * Gets interest rate
 * @return
 */
	public double getInterestRate() { return interestRate; }
	
/**
 * Gets amount limit
 * @return
 */
	public double getAmountLimit() {
		return amountLimit;
	}

/**
 * Gets quantity limit
 * @return
 */
	public int getQuantityLimit() {
		return quantityLimit;
	}

/**
 * Gets minimum balance
 * @return
 */
	public double getMinimumBalance() { return minimumBalance; }
	
/**
 * Gets products list
 * @param result
 * @return
 */
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
	
/**
 * Gets product details
 * @param products
 * @param result
 * @return
 */
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
