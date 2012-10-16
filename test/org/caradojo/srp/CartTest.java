package org.caradojo.srp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.mock;

import java.util.Date;

import org.caradojo.srp.Cart;
import org.caradojo.srp.Client;
import org.caradojo.srp.Product;
import org.junit.Before;
import org.junit.Test;

public class CartTest {

	Cart cart;
	
	@Before
	public void setUp() {
		Client client = mock(Client.class);
		cart = new Cart(client, new Date());
	}
		
	@Test
	public void newCartHasNoProductInside() {
		assertThat(cart.getProducts(), emptyCollectionOf(Product.class));
	}

	@Test
	public void iCanAddAProductIntoACart() {
		Product product = mock(Product.class);
		cart.addProduct(product);
		
		assertThat(cart.getProducts(), hasSize(1));
	}
	
}