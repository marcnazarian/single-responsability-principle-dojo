package org.caradojo.srp;

public class MailCart implements CartVisitor {

	StringBuilder content = new StringBuilder();

	public String computeMailContent(Cart cart) {
		cart.accept(this);
		return getContent();
	}
	
	@Override
	public void visit(Cart cart) {
		content.append("Bonjour,\nVotre panier composé le creationDate"
				+ " comporte les éléments suivants :\n");
	}

	@Override
	public void visit(Product product) {
		content.append("- " + product.getName() + " au prix de "
				+ product.getPrice() + "\n");

	}

	public String getContent() {
		return content.toString();
	}
	
}