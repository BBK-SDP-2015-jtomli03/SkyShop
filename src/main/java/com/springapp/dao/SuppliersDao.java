package com.springapp.dao;

import com.springapp.model.Supplier;
import com.springapp.model.SupplierImpl;

import java.util.List;

public interface SuppliersDao {
	public abstract Supplier createSupplier(SupplierImpl supplier);
	public abstract Supplier updateSupplier(SupplierImpl supplier);
	public abstract void deleteSupplier(SupplierImpl supplier);
	public abstract Supplier cancelSupplier(SupplierImpl supplier);
	public abstract Boolean cancelSupplier(int supplierId);
	public abstract List<Supplier> getAllSuppliers();
}
