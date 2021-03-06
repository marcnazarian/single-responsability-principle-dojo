package org.caradojo.srp;

public class RealProduct extends Product {

	private String name;
	private float price;
	
	public RealProduct(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	float getPrice() {
		return price;
	}

	@Override
	String getName() {
		return name;
	}

}