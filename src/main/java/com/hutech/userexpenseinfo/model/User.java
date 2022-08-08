package com.hutech.userexpenseinfo.model;

public class User {

	String paid_by;
	String month;
	int year;
	int date;
	double amount;
	String mode_of_payment;
	String nature_of_expense;
	String cost_of_center;
	boolean status;
	int quantity;

	public String getPaid_by() {
		return paid_by;
	}

	public void setPaid_by(String paid_by) {
		this.paid_by = paid_by;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMonth() {
		return month;
	}

	public User(String paid_by, int year, String month, int date, double amount, String mode_of_payment,
			String nature_of_expense, String cost_of_center,boolean status, int quantity) {
		super();
		this.paid_by = paid_by;
		this.date = date;
		this.year = year;
		this.month = month;
		this.date = date;
		this.amount = amount;
		this.mode_of_payment = mode_of_payment;
		this.nature_of_expense = nature_of_expense;
		this.cost_of_center = cost_of_center;
		this.status=status;
		this.quantity=quantity;

	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMode_of_payment() {
		return mode_of_payment;
	}

	public void setMode_of_payment(String mode_of_payment) {
		this.mode_of_payment = mode_of_payment;
	}

	public String getNature_of_expense() {
		return nature_of_expense;
	}

	public void setNature_of_expense(String nature_of_expense) {
		this.nature_of_expense = nature_of_expense;
	}

	public String getCost_of_center() {
		return cost_of_center;
	}

	public void setCost_of_center(String cost_of_center) {
		this.cost_of_center = cost_of_center;
	}
	public User() {
		super();

	}
}
