package org.caradojo.srp;

public class CartPriceComputer implements CartVisitor {

    private static float cartPrice;

    public float computeCartPrice(Cart cart) {
        cart.accept(this);
        return cartPrice;
    }
    
    @Override
    public void visit(Cart cart) {
        cartPrice = 0f;
    }

    @Override
    public void visit(Product product) {
        cartPrice += product.getPrice();
    }

}
