package com.eshop.model;

public class Product {

    private int productId;    
    private String code;
    private String description;
    private String details;
    private double price;
    public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	

    public Product() {}

    public int getId() {
        return productId;
    }

    public void setId(int productId) {
        this.productId = productId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public String getImageURL() {
        String imageURL = "/resources/images/" + code + ".jpg";
        return imageURL;
    }

    
}