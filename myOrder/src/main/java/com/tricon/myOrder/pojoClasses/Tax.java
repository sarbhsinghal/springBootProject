package com.tricon.myOrder.pojoClasses;

import javax.validation.constraints.NotNull;


public class Tax {
	@NotNull
	private Double CGST;
	@NotNull
	private Double SGST;
	public Double getCGST() {
		return CGST;
	}
	public void setCGST(Double cGST) {
		CGST = cGST;
	}
	public Double getSGST() {
		return SGST;
	}
	public void setSGST(Double sGST) {
		SGST = sGST;
	}
	public Tax(Double cGST, Double sGST) {
		super();
		CGST = cGST;
		SGST = sGST;
	}
	public Tax() {
		super();
	}
	@Override
	public String toString() {
		return "Tax [CGST=" + CGST + ", SGST=" + SGST + "]";
	}
	

}
