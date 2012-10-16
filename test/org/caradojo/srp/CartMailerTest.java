package org.caradojo.srp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.caradojo.srp.Cart;
import org.caradojo.srp.CartMailer;
import org.caradojo.srp.Product;
import org.caradojo.srp.RealProduct;
import org.hamcrest.Matchers;
import org.junit.Test;

public class CartMailerTest {

	@Test
	public void computeEmailContent() {
		CartMailer cartMailer = new CartMailer();

		Cart cart = mock(Cart.class);
		Product product1 = new RealProduct("product 1", 2.45f);
		Product product2 = new RealProduct("product 2", 10f);
		
		doCallRealMethod().when(cart).accept(cartMailer);
		when(cart.getProducts()).thenReturn(Arrays.asList(product1, product2));
		
		String computeMailContent = cartMailer.computeMailContent(cart);
		assertThat(computeMailContent, Matchers.containsString("product 1 au prix de 2.45"));
		assertThat(computeMailContent, Matchers.containsString("product 2 au prix de 10"));
	}
}