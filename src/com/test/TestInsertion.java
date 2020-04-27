package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.main.Product;
import com.main.Refrigerator;

public class TestInsertion {

	Refrigerator refrigerator = new Refrigerator(5, 6, 7);
	
	@Test
	public void testInvalidSize() throws Exception {
		Assertions.assertThrows(Exception.class, () -> refrigerator.putProduct(new Product("Apple", "Invalid")));
	}
	
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
