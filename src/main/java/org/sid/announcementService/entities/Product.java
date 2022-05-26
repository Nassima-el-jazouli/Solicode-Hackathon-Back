package org.sid.announcementService.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "announce")
public class Product {
    @Id
    private String id;
    private String title;
    private Double quantity;
    private String image;
    private String category;
    private String address;
    private String numTel;
    private int score;
    private boolean validation;
    private boolean isValidate;
    private  boolean toPublish;
    private  boolean isRejected;


    public Product() {
    }



	public Product(String id, String title, Double quantity, String image, String category, String address,
			String numTel, int score, boolean validation, boolean isValidate, boolean toPublish, boolean isRejected) {
		super();
		this.id = id;
		this.title = title;
		this.quantity = quantity;
		this.image = image;
		this.category = category;
		this.address = address;
		this.numTel = numTel;
		this.score = score;
		this.validation = validation;
		this.isValidate = isValidate;
		this.toPublish = toPublish;
		this.isRejected = isRejected;
	}







	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Double getQuantity() {
		return quantity;
	}



	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getNumTel() {
		return numTel;
	}



	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	

	public int getScore() {
		return score;
	}



	public void setScore(int score) {
		this.score = score;
	}



	public boolean isValidation() {
		return validation;
	}



	public void setValidation(boolean validation) {
		this.validation = validation;
	}



	



	public boolean isValidate() {
		return isValidate;
	}



	public void setValidate(boolean isValidate) {
		this.isValidate = isValidate;
	}



	public boolean isToPublish() {
		return toPublish;
	}



	public void setToPublish(boolean toPublish) {
		this.toPublish = toPublish;
	}



	public boolean isRejected() {
		return isRejected;
	}



	public void setRejected(boolean isRejected) {
		this.isRejected = isRejected;
	}


    
}
