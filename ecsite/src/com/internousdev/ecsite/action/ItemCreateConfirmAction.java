package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{
	private String itemName;
	private String totalPrice;
	private String totalStock;
	public Map<String,Object> session;
	private String errorMessage;

	public String execute() {
		String result=SUCCESS;

		if(!(itemName.equals(""))
				&& !(totalPrice.equals(""))
				&& !(totalStock.equals(""))) {
			session.put("itemName", itemName);
			session.put("totalPrice", totalPrice);
			session.put("totalStock", totalStock);
		} else {
			setErrorMessage("未入力の項目があります。");
			result=ERROR;
		}
		return result;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName=itemName;
	}

	public  String getTotalPrice() {
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

	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage=errorMessage;
	}

}
