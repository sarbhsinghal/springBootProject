package com.tricon.myOrder.pojoClasses;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;


public class Product {

	@NotNull
	@Min(1)
	@Max(50000)
	private Long id;
	@NotNull
	@Size(min = 2, max = 100)
	private String name;
	@NotNull
	@Size(min = 2, max = 50)
	private String type;
	@NotNull
	@URL
	private String image_url;
	@Valid
	private Price price;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Product(Long id, String name, String type, String image_url, Price price) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.image_url = image_url;
		this.price = price;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", image_url=" + image_url + ", price="
				+ price + "]";
	}

}
