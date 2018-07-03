package org.caradojo.srp;

public class CartMailer implements CartVisitor {

	StringBuilder content = new StringBuilder();

	public String computeMailContent(Cart cart) {
		cart.accept(this);
		return content.toString();
	}
	
	@Override
	public void visit(Cart cart) {
		content.append("Bonjour,\n" + 
					"Votre panier composé le " + cart.getReadableCreationDate() +
				    " comporte les éléments suivants :\n");
	}

	@Override
	public void visit(Product product) {
		content.append("- " + product.getName() + " au prix de "
				+ product.getPrice() + "\n");
	}
	
}