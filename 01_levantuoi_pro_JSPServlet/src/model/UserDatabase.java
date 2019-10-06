/**
 * Copyright(C) 2019  Luvina Software Company
 * UserDatabase.java, 2019-10-06 TuoiLV
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Description
 * @author TuoiLV
 */
public class UserDatabase extends CommonDB{
	public ArrayList<ListUser> getList() {
	ArrayList<ListUser> list = new ArrayList<>();
	String sql = "SELECT * FROM user";
	try {
		openConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		// Thực hiện truy vấn trả về list bản ghi
		ResultSet rs = ps.executeQuery();
		// Lấy bản ghi và add vào list
		while (rs.next()) {
			// Khai báo và set tt cho user
			ListUser users = new ListUser();
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
	
	public static void main(String[] args) {
		ArrayList<ListUser> list = new UserDatabase().getList();
		for (ListUser listUser : list) {
			System.out.println(listUser.getID());
		}
	}
}
