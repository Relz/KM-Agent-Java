package ru.relz.km.properties;

import java.io.*;
import java.util.Properties;

public class PropertiesHelper {
	public PropertiesHelper(String configFileName) throws IOException {
		InputStream input = new FileInputStream(configFileName);

		Properties prop = new Properties();
		prop.load(input);

		caseId = prop.getProperty("case_id");
		userId = prop.getProperty("user_id");
		mapNum = prop.getProperty("map_num");

		input.close();
	}

	private final String caseId;
	public String getCaseId() {
		return caseId;
	}

	private final String userId;
	public String getUserId() {
		return userId;
	}

	private final String mapNum;
	public String getMapNum() {
		return mapNum;
	}
}
