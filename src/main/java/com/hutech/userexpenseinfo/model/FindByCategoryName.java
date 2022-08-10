package com.hutech.userexpenseinfo.model;

public class FindByCategoryName {
	private String categoryName;
	private int id;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FindByCategoryName(String categoryName, int id) {
		super();
		this.categoryName = categoryName;
		this.id = id;
	}
	public FindByCategoryName() {
		super();
		
	}

}
