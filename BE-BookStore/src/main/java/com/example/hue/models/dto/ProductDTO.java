package com.example.hue.models.dto;

import javax.persistence.Id;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class ProductDTO {

	@Id
	private Long id;

	@NotEmpty
	@Size(min = 2, message = "Product name should have at least 2 characters")
	private String name;

	@Size(max = 255, message = "Product description should have at least 255 characters")
	private String description;

	@NotNull
	@Min(0)
	private BigDecimal unitPrice;

	private String imageUrl;

	private String imageStore;

	@NotNull
	private Boolean active;

	@NotNull
	@Min(0)
	private int unitInStock;

	private Date dateCreated;

	private Date lastUpdated;

	private ProductCategoryDTO category;

//	private Set<RateDTO> rates;

	public ProductDTO() {
		super();
	}

	public ProductDTO(Long id, String name, String description, BigDecimal unitPrice, String imageUrl,
			String imageStore, Boolean active, int unitInStock, Date dateCreated, Date lastUpdated,
			ProductCategoryDTO categoryDTO) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.imageUrl = imageUrl;
		this.imageStore = imageStore;
		this.active = active;
		this.unitInStock = unitInStock;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.category = categoryDTO;
	}

//	public Set<RateDTO> getRates() {
//		return rates;
//	}
//
//	public void setRates(Set<RateDTO> rates) {
//		this.rates = rates;
//	}

	public String getImageStore() {
		return imageStore;
	}

	public void setImageStore(String imageStore) {
		this.imageStore = imageStore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getUnitInStock() {
		return unitInStock;
	}

	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public ProductCategoryDTO getCategory() {
		return category;
	}

	public void setCategory(ProductCategoryDTO category) {
		this.category = category;
	}

}
