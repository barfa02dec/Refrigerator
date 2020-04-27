package com.main;

import java.util.ArrayList;
import java.util.List;
/**
 * Represents refrigerator and operation on refrigerator
 * @author Dharmendra.barfa
 */
public class Refrigerator {
	//List of products in a block
	private List<Product> smallBlock;
	private List<Product> mediumBlock;
	private List<Product> largeBlock;

	//Number of products can store in block
	private int smallBlockSize;
	private int mediumBlockSize;
	private int largeBlockSize;

	//Available space in a block 
	private int availableSmallBlockSize;
	private int availableMediumBlockSize;
	private int availableLargeBlockSize;
	
	//Constructor for initialize block size and available block size
	public Refrigerator(int smallBlockSize, int mediumBlockSize, int largeBlockSize) {
		super();
		this.smallBlockSize = smallBlockSize;
		this.mediumBlockSize = mediumBlockSize;
		this.largeBlockSize = largeBlockSize;
		this.smallBlock = new ArrayList<>();
		this.mediumBlock = new ArrayList<>();
		this.largeBlock = new ArrayList<>();
		this.availableSmallBlockSize = smallBlockSize;
		this.availableMediumBlockSize = mediumBlockSize;
		this.availableLargeBlockSize = largeBlockSize;
	}

	public List<Product> getSmallBlock() {
		return smallBlock;
	}

	public void setSmallBlock(List<Product> smallBlock) {
		this.smallBlock = smallBlock;
	}

	public List<Product> getMediumBlock() {
		return mediumBlock;
	}

	public void setMediumBlock(List<Product> mediumBlock) {
		this.mediumBlock = mediumBlock;
	}

	public List<Product> getLargeBlock() {
		return largeBlock;
	}

	public void setLargeBlock(List<Product> largeBlock) {
		this.largeBlock = largeBlock;
	}

	public int getSmallBlockSize() {
		return smallBlockSize;
	}

	public void setSmallBlockSize(int smallBlockSize) {
		this.smallBlockSize = smallBlockSize;
	}

	public int getMediumBlockSize() {
		return mediumBlockSize;
	}

	public void setMediumBlockSize(int mediumBlockSize) {
		this.mediumBlockSize = mediumBlockSize;
	}

	public int getLargeBlockSize() {
		return largeBlockSize;
	}

	public void setLargeBlockSize(int largeBlockSize) {
		this.largeBlockSize = largeBlockSize;
	}

	public int getAvailableSmallBlockSize() {
		return availableSmallBlockSize;
	}

	public void setAvailableSmallBlockSize(int availableSmallBlockSize) {
		this.availableSmallBlockSize = availableSmallBlockSize;
	}

	public int getAvailableMediumBlockSize() {
		return availableMediumBlockSize;
	}

	public void setAvailableMediumBlockSize(int availableMediumBlockSize) {
		this.availableMediumBlockSize = availableMediumBlockSize;
	}

	public int getAvailableLargeBlockSize() {
		return availableLargeBlockSize;
	}

	public void setAvailableLargeBlockSize(int availableLargeBlockSize) {
		this.availableLargeBlockSize = availableLargeBlockSize;
	}
	
	/**
	 * @param Product
	 * @return Success message if product stored successfully
	 * @throws Exception when product can not store in refrigerator
	 */
	public String putProduct(Product product) throws Exception {	
		//throw exception if size is invalid
		if(!product.getSize().equals("SMALL") && !product.getSize().equals("MEDIUM") && !product.getSize().equals("LARGE"))
			throw new Exception("Invalid product size");
		//Store small size product
		if(product.getSize().equals("SMALL")) {
			//store small size product in small block
			if(availableSmallBlockSize > 0) {
				smallBlock.add(product);
				--availableSmallBlockSize;
			}
			//store small size product in medium block
			else if(availableMediumBlockSize > 0) {
				mediumBlock.add(product);
				--availableMediumBlockSize;
			}
			//store small size product in large block
			else if(availableLargeBlockSize > 0) {
				largeBlock.add(product);
				--availableLargeBlockSize;
			}else {
				throw new Exception("Refrigerator is full");
			}
		}
		//Store medium size product
		if(product.getSize().equals("MEDIUM")) {
			//store in medium block
			if(availableMediumBlockSize > 0) {
				 mediumBlock.add(product);
				 --availableMediumBlockSize;
			}
			//store in medium block
			else if(availableLargeBlockSize > 0) {
				 largeBlock.add(product);
				 --availableLargeBlockSize;
			 }else {
				 throw new Exception("Can not store product.");
			 }
		}
		//Store large size product
		if(product.getSize().equals("LARGE")) {
			//store in large block
			if(availableLargeBlockSize > 0) {
				largeBlock.add(product);
				--availableLargeBlockSize;
			}else {
				throw new Exception("Can not store product.");
			}
		}
		return product + " is stored";
	}
	/**
	 * 
	 * @param product
	 * @return Product object
	 * @throws Exception if product is not available
	 */
	public Product getProduct(Product product) throws Exception {
		Product p = new Product();
		//search and return small product in small block
		if(product.getSize().equals("SMALL")  && availableSmallBlockSize <= smallBlockSize) {
			for(Product getProduct : smallBlock) {
				if(product.equals(getProduct)) {
					p = getProduct;
					smallBlock.remove(p);
					++availableSmallBlockSize;
					return p;
				}
			}			
		}
		//search and return small and medium size product in medium block
		else if((product.getSize().equals("SMALL") || product.getSize().equals("MEDIUM")) && availableMediumBlockSize <= mediumBlockSize ) {
			for(Product getProduct : mediumBlock) {
				if(product.equals(getProduct)) {
					p = getProduct;
					mediumBlock.remove(p);
					++availableMediumBlockSize;
					return p;
				}
			}
		}
		//search and return all size product in large block
		else if((product.getSize().equals("SMALL") || product.getSize().equals("MEDIUM") || product.getSize().equals("LARGE")) && availableLargeBlockSize <= largeBlockSize ) {
			for(Product getProduct : largeBlock) {
				if(product.equals(getProduct)) {
					p = getProduct;
					largeBlock.remove(p);
					++availableLargeBlockSize;
					return p;
				}
			}
		}
		throw new Exception("Can not found product");
	} 
	
}
