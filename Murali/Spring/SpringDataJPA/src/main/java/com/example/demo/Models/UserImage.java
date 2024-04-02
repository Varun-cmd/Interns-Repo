package com.example.demo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserImage {
	
	@Column
	private String imageUrl;

	public String getImageURL() {
		return imageUrl;
	}

	public void setImageURL(String imageURL) {
		this.imageUrl = imageURL;
	}
	
}
