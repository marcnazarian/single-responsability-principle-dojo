package org.caradojo.srp;

public class CartMailer implements CartVisitor {

	StringBuilder content = new StringBuilder();

	public String computeMailContent(Cart cart) {
		cart.accept(this);
		return getMailContent();
	}
	
	@Override
	public void visit(Cart cart) {
		content.append("Bonjour,\n" + 
					"Votre panier composé le creationDate " + 
				    " comporte les éléments suivants :\n");
	}

	@Override
	public void visit(Product product) {
		content.append("- " + product.getName() + " au prix de "
				+ product.getPrice() + "\n");
	}

	public String getMailContent() {
		return content.toString();
	}
	
}