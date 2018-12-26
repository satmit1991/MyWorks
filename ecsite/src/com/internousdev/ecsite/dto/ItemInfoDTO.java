package com.internousdev.ecsite.dto;

public class ItemInfoDTO {

	private String itemName;
	private String totalPrice;
	private String totalStock;
	private String insert_date;

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName=itemName;
	}

	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice=totalPrice;
	}

	public String getTotalStock() {
		return totalStock;
	}
	public void setTotalStock(String totalStock) {
		this.totalStock=totalStock;
	}

	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date=insert_date;
	}
}
