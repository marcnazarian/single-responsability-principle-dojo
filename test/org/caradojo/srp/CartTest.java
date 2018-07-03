package org.caradojo.srp;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.mock;

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