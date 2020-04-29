package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.main.Product;
import com.main.Refrigerator;

public class TestInsertion {

	Refrigerator refrigerator = new Refrigerator(5, 6, 7);
	
	/**
	 * test for invalid product size
	 * @throws Exception
	 */
	@Test
	public void testInvalidSize() throws Exception {
		Assertions.assertThrows(Exception.class, () -> refrigerator.putProduct(new Product("Apple", "Invalid")));
	}

	/**
	 * test large block
	 * @throws Exception if block  is full or for invalid size
	 */
	@Test
	public void testLargeBlock() throws Exception{
		refrigerator.putProduct(new Product("Apple", "LARGE"));
		refrigerator.putProduct(new Product("Apple", "LARGE"));
		refrigerator.putProduct(new Product("Apple", "LARGE"));
		refrigerator.putProduct(new Product("Apple", "LARGE"));
		refrigerator.putProduct(new Product("Apple", "LARGE"));
		refrigerator.putProduct(new Product("Apple", "LARGE"));
		refrigerator.putProduct(new Product("Apple", "LARGE"));
		Assertions.assertThrows(Exception.class, () -> refrigerator.putProduct(new Product("Apple", "LARGE")));
	}
	/**
	 * test medium size block 
	 * @throws Exception if medium and large block is full or invalid/large size product insert
	 */
	@Test
	public void testMediumBlock() throws Exception{
		refrigerator.putProduct(new Product("Apple", "MEDIUM"));
		refrigerator.putProduct(new Product("Apple", "MEDIUM"));
		refrigerator.putProduct(new Product("Apple", "MEDIUM"));
		refrigerator.putProduct(new Product("Apple", "MEDIUM"));
		refrigerator.putProduct(new Product("Apple", "MEDIUM"));
		refrigerator.putProduct(new Product("Apple", "MEDIUM"));
		refrigerator.putProduct(new Product("Apple", "MEDIUM"));
		refrigerator.putProduct(new Product("Apple", "MEDIUM"));
		refrigerator.putProduct(new Product("Apple", "MEDIUM"));
		refrigerator.putProduct(new Product("Apple", "MEDIUM"));
		refrigerator.putProduct(new Product("Apple", "MEDIUM"));
		refrigerator.putProduct(new Product("Apple", "MEDIUM"));
		refrigerator.putProduct(new Product("Apple", "MEDIUM"));
		Assertions.assertThrows(Exception.class, () -> refrigerator.putProduct(new Product("Apple", "LARGE")));
		Assertions.assertThrows(Exception.class, () -> refrigerator.putProduct(new Product("Apple", "MEDIUM")));
	}
	
	/**
	 * test small size block 
	 * @throws Exception if small,medium and large block is full or invalid/large/medium size product insert
	 */	
	@Test
	public void testSmallBlock() throws Exception{
		refrigerator.putProduct(new Product("Apple", "SMALL"));
		refrigerator.putProduct(new Product("Apple", "SMALL"));
		refrigerator.putProduct(new Product("Apple", "SMALL"));
		refrigerator.putProduct(new Product("Apple", "SMALL"));
		refrigerator.putProduct(new Product("Apple", "SMALL"));
	
		refrigerator.putProduct(new Product("Apple", "SMALL"));
		refrigerator.putProduct(new Product("Apple", "SMALL"));
		refrigerator.putProduct(new Product("Apple", "SMALL"));
		refrigerator.putProduct(new Product("Apple", "SMALL"));
		refrigerator.putProduct(new Product("Apple", "SMALL"));
		refrigerator.putProduct(new Product("Apple", "SMALL"));
		

		refrigerator.putProduct(new Product("Apple", "SMALL"));
		refrigerator.putProduct(new Product("Apple", "SMALL"));
		refrigerator.putProduct(new Product("Apple", "SMALL"));
		refrigerator.putProduct(new Product("Apple", "SMALL"));
		refrigerator.putProduct(new Product("Apple", "SMALL"));
		refrigerator.putProduct(new Product("Apple", "SMALL"));
		refrigerator.putProduct(new Product("Apple", "SMALL"));
		
		Assertions.assertThrows(Exception.class, () -> refrigerator.putProduct(new Product("Apple", "SMALL")));
		Assertions.assertThrows(Exception.class, () -> refrigerator.putProduct(new Product("Apple", "MEDIUM")));
		Assertions.assertThrows(Exception.class, () -> refrigerator.putProduct(new Product("Apple", "LARGE")));
	}
	
}
