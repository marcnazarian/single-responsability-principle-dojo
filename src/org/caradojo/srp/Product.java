package org.caradojo.srp;
public abstract class Product {

	abstract float getPrice();

	abstract String getName();
	
	void accept(CartVisitor v) {
		v.visit(this);
	}

}