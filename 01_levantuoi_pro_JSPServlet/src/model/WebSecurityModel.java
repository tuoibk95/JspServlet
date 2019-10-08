package model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class WebSecurityModel {
	public static String encodeHTML(String text) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			switch (text.charAt(i)) {
			case '"':
				str.append("&quot;");
				break;
			case '&':
				str.append("&amp;");
				break;
			case '\'':
				str.append("&#x27;");
				break;
			case '/':
				str.append("&#x2F;");
				break;
			case '<':
				str.append("&lt;");
				break;
			case '>':
				str.append("&gt;");
				break;
			default:
				str.append(text.charAt(i));
				break;
			}
		}
		return str.toString();
	}
	/**
	 * Description ma hoa 1 doan string theo chuan base64SHA-1
	 * @param password doan string can encrypt
	 */
	public void encrypt(String password) {
	    try {
	    	MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	        crypt.reset();
	        crypt.update(password.getBytes("UTF-8"));
	    } catch(NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } catch(UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }
	}
	
	/**
	 * Description lay ngau nhien 1 loai salt
	 * @return tra ve 1 doan duoc bien doi
	 */
	public byte[] getSalt() {
		SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[8];
        random.nextBytes(bytes);
        return bytes;
	}
	
	/**
	 * Description replaceWildcart chuyen hoa input sang de tranh loi wildcart
	 * @param strInput doan string dau vao
	 * @return tra ve chuoi da duoc chuyen hoa
	 */
	public String replaceWildcard(String strInput) {
		strInput.replace("%", "//%");
		strInput.replace("_", "//_");
		return strInput;
	}
}
