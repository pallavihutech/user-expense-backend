package com.hutech.userexpenseinfo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserExpense {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// @JsonFormat(pattern = "yyyy-mm-dd", shape = Shape.STRING)

	private String expenseId;
	private String paid_by;
	private String date;
	private double amount;
	private String mode_of_payment;
	private String nature_of_expense;
	private String cost_of_center;
	private boolean status;
	private int quantity;
	private double subTotal;
	private String description;

	public String getPaid_by() {
		return paid_by;
	}

	public void setPaid_by(String paid_by) {
		this.paid_by = paid_by;
	}

	public String getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(String expenseId) {
		this.expenseId = expenseId;
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

	public UserExpense(String paid_by, String date, double amount, String mode_of_payment, String nature_of_expense,
			String cost_of_center, boolean status, int quantity, String expenseId, double subTotal,
			String description) {
		super();
		this.expenseId = expenseId;
		this.paid_by = paid_by;
		this.date = date;
		this.amount = amount;
		this.subTotal = subTotal;
		this.mode_of_payment = mode_of_payment;
		this.nature_of_expense = nature_of_expense;
		this.cost_of_center = cost_of_center;
		this.status = status;
		this.quantity = quantity;
		this.description = description;

	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserExpense() {
		super();

	}

}
