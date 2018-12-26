package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport implements SessionAware {
	public Map<String,Object> session;
	private ItemListDeleteCompleteDAO itemListDeleteCompleteDAO=new ItemListDeleteCompleteDAO();
	private ArrayList<ItemInfoDTO> itemInfoList=new ArrayList<ItemInfoDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{
		if(!session.containsKey("id")) {
			return ERROR;
		}
		if(deleteFlg==null) {
			String item_transaction_id=session.get("id").toString();
			itemInfoList=itemListDeleteCompleteDAO.getCreateItemInfo(item_transaction_id);
		} else if(deleteFlg.equals("1")) {
			delete();
		}
		String result=SUCCESS;
		return result;
	}
	public void delete() throws SQLException{
		String item_transaction_id=session.get("id").toString();

		int res=itemListDeleteCompleteDAO.ItemCreateHistoryDelete(item_transaction_id);
		if(res>0) {
			itemInfoList=null;
				setMessage("商品情報を正しく削除しました。");
		} else if(res==0) {
			setMessage("商品情報の削除に失敗しました。");
		}
	}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg=deleteFlg;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}

	public ArrayList<ItemInfoDTO> itemInfoList(){
		return this.itemInfoList;
	}

	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message=message;
	}
}
