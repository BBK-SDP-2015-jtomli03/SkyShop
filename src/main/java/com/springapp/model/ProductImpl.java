package com.springapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductImpl implements Product {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "code")
	private String productCode;
	@Column(name= "tid")
	private int productTypeId;
	@Column(name= "name")
	private String name;
	private String description;
	private BigDecimal price;
	private String imageUrl;
	private int stockLevel = -100;
	private int reorderLevel;
	private List<Supplier> suppliers = new ArrayList<Supplier>();
	private boolean discontinued = false;
	private String shelfLocation = null;
	private String rowLocation = null;

	public ProductImpl(int id, int tid, String productCode, String name, String description, BigDecimal price, String imageUrl){
		this.id = id;
		this.productTypeId = tid;
		this.productCode = productCode;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void addProductSupplier(Supplier supplier){
		suppliers.add(supplier);
	}

	@Override
	public List<Supplier> getProductSuppliers() {
		return suppliers;
	}

	@Override
	public String getProductCode() {
		return productCode;
	}

	@Override
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getStockLevel() {
		return stockLevel;
	}

	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}

	public int adjustStockLevel(int numOfItemsBought) {
		this.stockLevel -= numOfItemsBought;
		return stockLevel;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTid() {
		return productTypeId;
	}

	public void setTid(int tid) {
		this.productTypeId = tid;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	@Override
	public String toString() {
		return "ProductId: " + id
				+ ", name "
				+ name
				+ ", imageUrl "
				+ imageUrl
				+ ", shelf "
				+ shelfLocation
				+ ", row "
				+ rowLocation;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getShelfLocation() {
		return shelfLocation;
	}

	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
	}

	public String getRowLocation() {
		return rowLocation;
	}

	public void setRowLocation(String rowLocation) {
		this.rowLocation = rowLocation;
	}
}










	





	
