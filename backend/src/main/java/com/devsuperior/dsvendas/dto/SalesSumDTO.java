package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

public class SalesSumDTO implements Serializable {
	
	/** 	 * 07/05/2021 V1 	 */
	private static final long serialVersionUID = 1L;
	private String sellerName;
	private double sum;
	
	public SalesSumDTO() {}

	public SalesSumDTO(Seller seller, double sum) {
		super();
		this.sellerName = seller.getName();
		this.sum = sum;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}
	
	
}
