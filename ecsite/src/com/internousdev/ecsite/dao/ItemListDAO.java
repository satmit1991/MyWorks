package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {

	private DBConnector dbConnector=new DBConnector();
	private Connection con=dbConnector.getConnection();
//
//	public ArrayList<ItemInfoDTO> getCreateItemInfo(String item_transaction_id) throws SQLException{
//		ArrayList<ItemInfoDTO> itemInfoDTOList=new ArrayList<ItemInfoDTO>();
//		String sql="SELECT iit.item_name,iit.total_price,iit.total_stock FROM item_info_transaction iit LEFT JOIN user_buy_item_transacction ubit ON ubit.item_transaction_id WHERE ubit.item_transaction_id=? ORDER BY iit.insert_date DESC";
//		try {
//			PreparedStatement preparedStatement=con.prepareStatement(sql);
//			preparedStatement.setString(1, item_transaction_id);
//
//			ResultSet resultSet=preparedStatement.executeQuery();
//
//			while(resultSet.next()) {
//				ItemInfoDTO dto=new ItemInfoDTO();
//				dto.setInsert_date(resultSet.getString("item_name"));
//				dto.setTotalPrice(resultSet.getString("total_price"));
//				dto.setTotalStock(resultSet.getString("total_stock"));
//				dto.setInsert_date(resultSet.getString("insert_date"));
//				itemInfoDTOList.add(dto);
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			con.close();
//		}
//		return itemInfoDTOList;
//	}

	List<ItemInfoDTO> itemInfoDTOList=new ArrayList<ItemInfoDTO>();

	public List<ItemInfoDTO> select(){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="select * from item_info_transaction";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				ItemInfoDTO dto=new ItemInfoDTO();
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalStock(rs.getString("total_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				itemInfoDTOList.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return itemInfoDTOList;
	}

	public int ItemCreateHistoryDelete(String item_transaction_id) throws SQLException{
		String sql="DELETE FROM item_info_transaction WHERE item_transaction_id=?";
		PreparedStatement preparedStatement;
		int result=0;
		try {
			preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			result=preparedStatement.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				con.close();
			}
		return result;
	}
}
