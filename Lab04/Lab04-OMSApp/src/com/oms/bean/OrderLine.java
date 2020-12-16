package com.oms.bean;

public class OrderLine {
	private String productId;
	private String productTitle;
	private float productCost;
	private int productQuantity;
	private float productWeight;

	public OrderLine(){
	}
	
	public OrderLine(String productId, String productTitle, int productQuantity, float productCost) {
		super();
		this.productId = productId;
		this.productTitle = productTitle;
		this.productCost = productCost;
		this.productQuantity = productQuantity;
	}

	public OrderLine(String productId, String productTitle, int productQuantity, float productCost, float productWeight) {
		this(productId, productTitle, productQuantity, productCost);
		this.productWeight = productWeight;
	}

	public float getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(float productWeight) {
		this.productWeight = productWeight;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public float getProductCost() {
		return productCost;
	}

	public void setProductCost(float productCost) {
		this.productCost = productCost;
	}

	public int getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
}
