package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {

	private DBConnector dbConnector=new DBConnector();
	private Connection connection=dbConnector.getConnection();
	private DateUtil dateUtil=new DateUtil();
	private String sql="INSERT INTO item_info_transaction(item_name,total_price,total_stock,insert_date) VALUES(?,?,?,?)";
	public void createItem(String itemName,String totalPrice,String totalStock) throws SQLException{
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, itemName);
			preparedStatement.setString(2, totalPrice);
			preparedStatement.setString(3, totalStock);
			preparedStatement.setString(4, dateUtil.getDate());
			preparedStatement.execute();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}
