/**
 * Copyright(C) 2019  Luvina Software Company
 * CommonDB.java, 2019-10-04 TuoiLV
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Description
 * @author TuoiLV
 */
public class CommonDB {
	//khai báo user của localhost
		private static final String USER = "root";
		//khái báo mật khẩu của localhost
		private static final String PASS = "LVTsinhvienit1";
		// Khai báo connection
		protected static Connection con;
			
		/**
		 * kết nối tới Server
		 */
		public void openConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/jspservlet",USER,PASS);
			} catch (ClassNotFoundException ex) {
				System.out.println("Driver không tìm thấy");
				System.out.println(ex.getMessage());
			} catch (SQLException ex) {
				System.out.println("kết nối thất bại");
				System.out.println(ex.getMessage());
			}
		}
			
		/**
		 * đóng kết nối tới Server
		 */
		public void closeConnection() {
			try {
				if (!con.isClosed()) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Đóng kết nối thất bại");
			} catch (NullPointerException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Server không tìm thấy hoặc chưa kết nối");
			}
		}
}
