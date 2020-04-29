package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.main.Product;
import com.main.Refrigerator;

public class TestDeletion {

	Refrigerator refrigerator = new Refrigerator(5, 6, 7);
	
	/**
	 * get available product from refrigerator
	 * @throws Exception
	 */
	@Test
	public void getValidProduct() throws Exception {
		Product smallProduct = new Product("Apple", "SMALL");
		Product mediumProduct = new Product("Apple", "MEDIUM");
		Product largeProduct = new Product("Apple", "LARGE");
		refrigerator.putProduct(smallProduct);
		refrigerator.putProduct(mediumProduct);
		refrigerator.putProduct(largeProduct);
		Assertions.assertEquals(smallProduct, refrigerator.getProduct(smallProduct));
		Assertions.assertEquals(mediumProduct, refrigerator.getProduct(mediumProduct));
		Assertions.assertEquals(largeProduct, refrigerator.getProduct(largeProduct));
	}
	/**
	 * get product which is not available in refrigerator
	 * @throws Exception
	 */
	@Test
	public void getInvalidProduct() throws Exception {
		Assertions.assertThrows(Exception.class, ()-> refrigerator.getProduct(new Product("Apple", "SMALL")));
		Assertions.assertThrows(Exception.class, ()-> refrigerator.getProduct(new Product("Apple", "MEDIUM")));
		Assertions.assertThrows(Exception.class, ()-> refrigerator.getProduct(new Product("Apple", "LARGE")));
		
		refrigerator.putProduct(new Product("Apple", "LARGE"));
		Assertions.assertThrows(Exception.class, ()-> refrigerator.getProduct(new Product("Orange", "LARGE")));
	}
	
}
