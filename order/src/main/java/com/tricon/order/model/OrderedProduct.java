package com.tricon.order.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class OrderedProduct {
	@Min(1)
	@Max(50000)
	@NotNull
	private Long productId;
	@Min(1)
	@Max(500000)
	@NotNull
	private Double amount;
	@NotNull
	private String currency;
	@Valid
	private Tax tax;
	@Min(1)
	@Max(60000)
	private Double total;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@NotNull
	private Date sDelivery;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date aDelivery;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@NotNull
	private Date sShipping;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date aShipping;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getsDelivery() {
		return sDelivery;
	}

	public void setsDelivery(Date sDelivery) {
		this.sDelivery = sDelivery;
	}

	public Date getaDelivery() {
		return aDelivery;
	}

	public void setaDelivery(Date aDelivery) {
		this.aDelivery = aDelivery;
	}

	public Date getsShipping() {
		return sShipping;
	}

	public void setsShipping(Date sShipping) {
		this.sShipping = sShipping;
	}

	public Date getaShipping() {
		return aShipping;
	}

	public void setaShipping(Date aShipping) {
		this.aShipping = aShipping;
	}

	public OrderedProduct(Long productId, Double amount, String currency, Tax tax, Double total, Date sDelivery,
			Date aDelivery, Date sShipping, Date aShipping) {
		super();
		this.productId = productId;
		this.amount = amount;
		this.currency = currency;
		this.tax = tax;
		this.total = total;
		this.sDelivery = sDelivery;
		this.aDelivery = aDelivery;
		this.sShipping = sShipping;
		this.aShipping = aShipping;
	}

	public OrderedProduct() {
		super();
	}

	@Override
	public String toString() {
		return "OrderedProduct [productId=" + productId + ", amount=" + amount + ", currency=" + currency + ", tax="
				+ tax + ", total=" + total + ", sDelivery=" + sDelivery + ", aDelivery=" + aDelivery + ", sShipping="
				+ sShipping + ", aShipping=" + aShipping + "]";
	}

}
