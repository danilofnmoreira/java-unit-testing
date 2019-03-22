package br.com.marimbondo.asserts;

import static java.time.LocalDate.of;
import static java.time.Month.APRIL;
import static java.time.Month.DECEMBER;
import static java.time.Month.JULY;
import static java.time.Month.NOVEMBER;
import static java.util.List.of;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import br.com.marimbondo.Product;
import br.com.marimbondo.Shop;

public class AssertMethods {

	Shop shop;

	@Before
	public void setUp() {
		shop = new Shop();
	}

	@Test
	public void assertArrayEqualsTest() {

		List<Product> productsToBuy = of(new Product("Macarrao", of(2019, APRIL, 21), 33.0),
				new Product("Cebola", of(2019, DECEMBER, 20), 50.0), new Product("Celular", of(2019, JULY, 10), 11.0),
				new Product("Mouse", of(2019, NOVEMBER, 18), 42.0), new Product("Arroz", of(2019, DECEMBER, 14), 20.0));
		Double money = 100.0;

		Product[] actuals = shop.buyProducts(productsToBuy, money).toArray(new Product[0]);

		Product[] expecteds = of(new Product("Celular", of(2019, JULY, 10), 11.0),
				new Product("Arroz", of(2019, DECEMBER, 14), 20.0), new Product("Macarrao", of(2019, APRIL, 21), 33.0))
						.toArray(new Product[0]);

		assertArrayEquals(expecteds, actuals); // The assertArrayEquals() method will test whether two arrays are
												// equal to each other. In other words, if the two arrays
												// contain the same number of elements, and if all the elements
												// in the array are equal to each other in the same order. Call
												// the equals() for compare.
	}

	@Test
	public void assertEqualsTest() {
		Product macarrao = shop.hasTheProduct("Macarrao");
		Product expected = new Product("Macarrao", of(2019, APRIL, 21), 33.0);
		assertEquals(expected, macarrao); // The assertEquals() method compares two objects for equality, using
											// their equals() method
	}

	@Test
	public void assertTrueTest() {
		boolean isOpen = shop.isOpen();
		Assume.assumeTrue(isOpen);
		assertTrue(isOpen);
	}

	@Test
	public void assertFalseTest() {
		boolean isClose = shop.isClose();
		Assume.assumeTrue(isClose);
		assertTrue(isClose);
	}

	@Test
	public void assertNullTest() {
		Product product = shop.hasTheProduct("coxinha");
		assertNull(product);
	}

	@Test
	public void assertNotNullTest() {
		Product product = shop.hasTheProduct("Macarrao");
		assertNotNull(product);
	}

	@Test
	public void assertSameTest() {
		Product m1 = shop.hasTheProduct("Macarrao");
		Product m2 = shop.hasTheProduct("Macarrao");
		assertSame(m1, m2); // The assertSame() and assertNotSame() methods tests if two object references
							// point to the same object or not. It is not enough that the two objects
							// pointed to are equals according to their equals() methods. It must be exactly
							// the same object pointed to.
	}

	@Test
	public void assertNotSameTest() {
		Product m1 = shop.hasTheProduct("Macarrao");
		Product m2 = shop.hasTheProduct("Cebola");
		assertNotSame(m1, m2);
	}

}
