package org.caradojo.srp;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

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