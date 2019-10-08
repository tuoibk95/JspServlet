/**
 * Copyright(C) 2019  Luvina Software Company
 * UserDatabase.java, 2019-10-06 TuoiLV
 */
package model;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Description
 * @author TuoiLV
 */
public class UserDatabaseModel extends CommonDBModel{
	
	public UserDatabaseModel() throws ClassNotFoundException, IOException {
		super();
	}

	public ArrayList<UserModel> getList() {
	ArrayList<UserModel> list = new ArrayList<>();
	String sql = "SELECT * FROM user";
	try {
		openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		// Thực hiện truy vấn trả về list bản ghi
		ResultSet rs = ps.executeQuery();
		// Lấy bản ghi và add vào list
		while (rs.next()) {
			// Khai báo và set tt cho user
			UserModel users = new UserModel();
			users.setID(rs.getString("id"));
			users.setName(rs.getString("name"));
			users.setBirthday(rs.getDate("birthday"));
			users.setBirthspace(rs.getString("birthplace"));
			list.add(users);
		}
	} catch (Exception ex) {
		// TODO: handle exception
		ex.printStackTrace();
	} finally {
		closeConnection();
	}
	
	return list;
	
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		ArrayList<UserModel> list = new UserDatabaseModel().getList();
		for (UserModel listUser : list) {
			System.out.println(listUser.getID());
		}
	}
}
