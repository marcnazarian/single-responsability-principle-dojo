package org.caradojo.srp;

import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;

import static org.mockito.Mockito.mock;

public class CartPriceComputerTest {

    @Test
    public void should_compute_price_of_cart() {
        // arrange
        Product product1_1 = new RealProduct("product 1", 1.21f);
        Product product1_2 = new RealProduct("product 1", 1.21f);
        Product product2 = new RealProduct("product 2", 10.05f);
        Product product3 = new RealProduct("product 3", 0.99f);

        Cart cart = new Cart(mock(Client.class), Date.from(Instant.parse("2018-07-03T22:22:22Z")));
        cart.addProduct(product1_1);
        cart.addProduct(product1_2);
        cart.addProduct(product2);
        cart.addProduct(product3);

        // act
        CartPriceComputer cartPriceComputer = new CartPriceComputer();
        float cartPrice = cartPriceComputer.computeCartPrice(cart);
        
        // assert
        Assert.assertEquals(13.46f, cartPrice, 0.001);
    }

}
