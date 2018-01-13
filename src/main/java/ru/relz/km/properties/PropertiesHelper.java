package ru.relz.km.properties;

import java.io.*;
import java.util.Properties;

public class PropertiesHelper {
	private static final String configFileName = "src/main/resources/config.properties";

	public PropertiesHelper() {
		InputStream input = null;
		try {
			input = new FileInputStream(configFileName);

			Properties prop = new Properties();
			prop.load(input);

			caseId = prop.getProperty("case_id");
			userId = prop.getProperty("user_id");
			mapNum = prop.getProperty("map_num");
		} catch (IOException ex) {
			System.out.println("Не найден файл конфигурации " + configFileName);
			System.exit(1);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String caseId;
	public String getCaseId() {
		return caseId;
	}

	private String userId;
	public String getUserId() {
		return userId;
	}

	private String mapNum;
	public String getMapNum() {
		return mapNum;
	}
}
