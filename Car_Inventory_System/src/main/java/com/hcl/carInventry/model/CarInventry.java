package com.hcl.carInventry.model;

import lombok.Builder;

@Builder
public class CarInventry {

	private int inventryNo;
	private String make;
	private String model;
	private double year;
	private double salesPrice;

	public int getInventryNo() {
		return inventryNo;
	}

	public void setInventryNo(int inventryNo) {
		this.inventryNo = inventryNo;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getYear() {
		return year;
	}

	public void setYear(double year) {
		this.year = year;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public CarInventry(int inventryNo, String make, String model, double year, double salesPrice) {
		super();
		this.inventryNo = inventryNo;
		this.make = make;
		this.model = model;
		this.year = year;
		this.salesPrice = salesPrice;
	}

	public CarInventry() {
		super();
	}
}