package com;
public class Car {

private String id = "";
private int mileage = 0;
private int mpg = 0;
private double cost = 0.0;
private double salesPrice = 0.0;
private boolean isSold = false;
private double priceSold = 0.0;
private double profit = 0.0;

public Car() {
}


public Car(String id, int mileage, int mpg, double cost, double salesPrice) {
	this.id = id;
	this.mileage = mileage;
	this.mpg = mpg;
	this.cost = cost;
	this.salesPrice = salesPrice;
	this.isSold=false;
	this.priceSold = 0.0;
	this.profit = 0.0;
}
public String getId() {
	return this.id;
}

public int getMileage() {
	return this.mileage;
}

public int getMpg() {
	return this.mpg;
}
public double getCost() {
	return this.cost;
}

public double getSalesPrice() {
	return this.salesPrice;
}

public boolean getIsSold() {
	return this.isSold;
}

public double getPriceSold() {
	return this.priceSold;
}

public double getProfit() {
	return this.profit;
}

@Override
public String toString() {
	return "Car ID: " + this.id + "\n"
	+ "Mileage: " + this.mileage + "\n"
	+ "MPG: " + this.mpg + "\n"
	+ "Cost: " + this.cost + "\n"
	+ "Sales Price: " + this.salesPrice + "\n"
	+ "Sold: " + this.isSold + "\n"
	+ "Price Sold: " + this.priceSold + "\n"
	+ "Profit: " + this.profit;
}


public void setId(String newId) {
	this.id = newId;
}

public void setMileage(int newMileage) {
	this.mileage = newMileage;
}

public void setMpg(int newMpg) {
	this.mpg = newMpg;
}

public void setCost(double newCost) {
	this.cost = newCost;
}

public void setSalesPrice(double newSalesPrice) {
	this.salesPrice = newSalesPrice;
}




public int compareMPG(Car otherCar) {
	if (this.mpg < otherCar.getMpg()) {
		return -1;
	}
	if (this.mpg > otherCar.getMpg()) {
		return 1;
}
	return 0;

}

public void sellCar(double priceSold) {
	isSold = true;
	this.priceSold = priceSold;
	profit = priceSold - cost;
}
public int compareMiles(Car otherCar) {
	if (this.mileage < otherCar.getMileage()) {
		return -1;
	}
	if (this.mileage > otherCar.getMileage()) {
		return 1;
}
	return 0;
}
public int comparePrice(Car otherCar) {
	if (this.cost < otherCar.getCost()) {
		return -1;
	}
	if (this.cost > otherCar.getCost()) {
		return 1;
}
	return 0;
}


}