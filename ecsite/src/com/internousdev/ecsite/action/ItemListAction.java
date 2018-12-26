package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport {
	private List<ItemInfoDTO> ItemInfoDTOList=new ArrayList<ItemInfoDTO>();
	public String execute() {
		String ret=ERROR;
		ItemListDAO dao=new ItemListDAO();

		ItemInfoDTOList=dao.select();
		if(ItemInfoDTOList.size()>0) {
			ret=SUCCESS;
		} else {
			ret=ERROR;
		}
		return ret;
	}
	public List<ItemInfoDTO> getItemInfoDTOList(){
		return ItemInfoDTOList;
	}
	public void setItemInfoDTOList(List<ItemInfoDTO> itemInfoDTOList) {
		ItemInfoDTOList=itemInfoDTOList;
	}
}
