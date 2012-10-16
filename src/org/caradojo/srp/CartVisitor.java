package org.caradojo.srp;
public interface CartVisitor {

	void visit(Cart cart);
	
	void visit(Product product);
	
}
