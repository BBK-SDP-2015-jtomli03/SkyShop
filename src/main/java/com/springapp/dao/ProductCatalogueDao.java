package com.springapp.dao;

import com.springapp.model.Product;
import com.springapp.model.ProductImpl;

import java.util.ArrayList;

public interface ProductCatalogueDao {
	public abstract Product insertProduct(ProductImpl product);
	public abstract void updateProduct(ProductImpl product);
	public abstract void deleteProduct(ProductImpl product);
	public abstract ArrayList getAllProducts();
	public abstract Product getProductById(int productId);
}
