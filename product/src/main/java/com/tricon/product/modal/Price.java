package com.tricon.product.modal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Currency;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Price {
	@NotNull
	private Double amount;
	@NotNull
	private String currency;
	@Valid
	private Tax tax;

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
public Price(Double amount, String currency, Tax tax) {
	super();
	this.amount = amount;
	this.currency = currency;
	this.tax = tax;
}
public Price() {
	super();
}
@Override
public String toString() {
	return "Price [amount=" + amount + ", currency=" + currency + ", tax=" + tax + "]";
}

}
