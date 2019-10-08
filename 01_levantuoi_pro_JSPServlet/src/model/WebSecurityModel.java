package model;

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
}
