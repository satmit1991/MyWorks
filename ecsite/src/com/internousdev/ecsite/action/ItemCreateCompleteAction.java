package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware {

	private String itemName;
	private String totalPrice;
	private String totalStock;
	public Map<String,Object> session;
	private ItemCreateCompleteDAO itemCreateCompleteDAO=new ItemCreateCompleteDAO();

	public String execute() throws SQLException {
		itemCreateCompleteDAO.createItem(session.get("itemName").toString(),
				session.get("totalPrice").toString(),
				session.get("totalStock").toString());
		String result=SUCCESS;
		return result;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName=itemName;
	}

	public String  getTotalPrice() {
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

}
