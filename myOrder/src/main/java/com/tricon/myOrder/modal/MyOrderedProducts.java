package com.tricon.myOrder.modal;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tricon.myOrder.pojoClasses.Product;
import com.tricon.myOrder.pojoClasses.Tax;

@Component
public class MyOrderedProducts {
	private Product product;
	private Double amount;
	private String currency;
	private Tax tax;
	private Double total;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date sDelivery;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date aDelivery;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date sShipping;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date aShipping;
	@Override
	public String toString() {
		return "MyOrderedProducts [product=" + product + ", amount=" + amount + ", currency=" + currency + ", tax="
				+ tax + ", total=" + total + ", sDelivery=" + sDelivery + ", aDelivery=" + aDelivery + ", sShipping="
				+ sShipping + ", aShipping=" + aShipping + "]";
	}
	public MyOrderedProducts() {
		super();
	}
	public MyOrderedProducts(Product product, Double amount, String currency, Tax tax, Double total, Date sDelivery,
			Date aDelivery, Date sShipping, Date aShipping) {
		super();
		this.product = product;
		this.amount = amount;
		this.currency = currency;
		this.tax = tax;
		this.total = total;
		this.sDelivery = sDelivery;
		this.aDelivery = aDelivery;
		this.sShipping = sShipping;
		this.aShipping = aShipping;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
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
}
