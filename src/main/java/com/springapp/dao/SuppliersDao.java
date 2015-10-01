package com.springapp.dao;

import com.springapp.model.ProductSupplier;
import com.springapp.model.Supplier;

import java.util.List;

public interface SuppliersDao {
	public abstract Supplier createSupplier(ProductSupplier supplier);
	public abstract Supplier updateSupplier(ProductSupplier supplier);
	public abstract void deleteSupplier(ProductSupplier supplier);
	public abstract Supplier cancelSupplier(ProductSupplier supplier);
	public abstract Boolean cancelSupplier(int supplierId);
	public abstract List<Supplier> getAllSuppliers();
}
