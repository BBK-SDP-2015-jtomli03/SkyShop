package com.springapp.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements Product {

	private int id;

	private String productCode;
	private String name;
	private String shortDescription;
	private String longDescription;
	private BigDecimal price;
	private String imageUrl;
	private int reorderLevel;
	private List<Supplier> suppliers = new ArrayList<Supplier>();
	private String shelfLocation = null;
	private String rowLocation = null;
	private int stockLevel = -100;
	private boolean discontinued = false;

	public ProductImpl(int id, String productCode, String name, String shortDescription, String longDescription, BigDecimal price, String imageUrl, int reorderLevel, List<Supplier> suppliers, String shelfLocation, String rowLocation, int stockLevel, boolean discontinued) {
		this.id = id;
		this.productCode = productCode;
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.price = price;
		this.imageUrl = imageUrl;
		this.reorderLevel = reorderLevel;
		this.suppliers = suppliers;
		this.shelfLocation = shelfLocation;
		this.rowLocation = rowLocation;
		this.stockLevel = stockLevel;
		this.discontinued = discontinued;
	}

	public ProductImpl(String productCode, String name, String shortDescription, String longDescription, BigDecimal price, String imageUrl, String rowLocation, String shelfLocation, int reOrderLevel, int stockLevel, boolean discontinued) {
		this.productCode = productCode;
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.price = price;
		this.imageUrl = imageUrl;
		this.rowLocation = rowLocation;
		this.shelfLocation = shelfLocation;
		this.reorderLevel = reorderLevel;
		this.stockLevel = stockLevel;
		this.discontinued = discontinued;
	}

	@Override
	public String getShortDescription() {
		return shortDescription;
	}

	@Override
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@Override
	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
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










	





	
