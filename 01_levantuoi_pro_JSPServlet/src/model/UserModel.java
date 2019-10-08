/**
 * Copyright(C) 2019  Luvina Software Company
 * ListUser.java, 2019-10-04 TuoiLV
 */
package model;

import java.sql.Date;

/**
 * Description
 * @author TuoiLV
 */
public class UserModel {
	public String ID;
	public String Name;
	public Date Birthday;
	public String Birthplace;
	/**
	 * @return the iD
	 */
	public UserModel() {
	}
	
	public String getID() {
		return ID;
	}
	/**
	 * @param string the iD to set
	 */
	public void setID(String string) {
		ID = string;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return Birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}
	/**
	 * @return the birthspace
	 */
	public String getBirthplace() {
		return Birthplace;
	}
	/**
	 * @param birthspace the birthspace to set
	 */
	public void setBirthspace(String birthplace) {
		Birthplace = birthplace;
	}
	
	
}
