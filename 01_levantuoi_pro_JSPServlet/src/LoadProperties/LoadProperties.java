package LoadProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
	public static Properties readFile() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = LoadProperties.class.getClassLoader().getResourceAsStream("config.properties");
			if (input != null) {
				prop.load(input);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return prop;
	}
}
