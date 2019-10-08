/**
 * Copyright(C) 2019  Luvina Software Company
 * CommonDB.java, 2019-10-04 TuoiLV
 */
package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import LoadProperties.LoadProperties;

/**
 * Description
 * @author TuoiLV
 */
public class CommonDBModel {
	
	protected Connection conn;
	private String userDB;
	private String passDB;
	private String urlDB;
	private String driverDB;

	/**
	 * Khá»Ÿi táº¡o class khÃ´ng tham sá»‘ Náº¡p Driver jdbc
	 * 
	 * @throws ClassNotFoundException Lá»—i khÃ´ng tÃ¬m tháº¥y class
	 */
	public CommonDBModel() throws ClassNotFoundException, IOException {
		try {
			Properties prop = LoadProperties.readFile();
			driverDB = prop.getProperty("database.driver");
			urlDB = prop.getProperty("database.url");
			userDB = prop.getProperty("database.user");
			passDB = prop.getProperty("database.pass");

			Class.forName(driverDB);
		} catch (ClassNotFoundException | IOException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
		/**
		 * kết nối tới Server
		 */
		public void openConnection() {
			try {
				Class.forName(driverDB);
				conn = DriverManager.getConnection(urlDB, userDB, passDB);
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
				if (!conn.isClosed()) {
					conn.close();
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
