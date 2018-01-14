package ru.relz.km.properties;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesHelperTest {
	private static final String configFileName = "src/main/resources/config.properties";
	private static final String emptyConfigFileName = "src/main/resources/empty.properties";
	private static final String nonExistentConfigFileName = "src/main/resources/non-existent.properties";

	@Test
	void nonExistentConfigFileThrowsException() {
		try {
			new PropertiesHelper(nonExistentConfigFileName);
		} catch (IOException e) {
			return;
		}
		fail("Попытка открыть несуществующий файл для чтения конфигурации должна увенчаться исключением");
	}

	@Test
	void getCaseId() {
		{
			PropertiesHelper propertiesHelper = null;
			try {
				propertiesHelper = new PropertiesHelper(configFileName);
			} catch (IOException e) {
				fail("Передача правильного файла для считывания конфигурации не должна вызывать ислючение");
			}
			assertNotNull(propertiesHelper.getCaseId());
		}
		{
			PropertiesHelper propertiesHelper = null;
			try {
				propertiesHelper = new PropertiesHelper(emptyConfigFileName);
			} catch (IOException e) {
				fail("Передача пустого файла для считывания конфигурации не должна вызывать ислючение");
			}
			assertNull(propertiesHelper.getCaseId());
		}
	}

	@Test
	void getUserIdReturnsNotNull() {
		{
			PropertiesHelper propertiesHelper = null;
			try {
				propertiesHelper = new PropertiesHelper(configFileName);
			} catch (IOException e) {
				fail("Передача правильного файла для считывания конфигурации не должна вызывать ислючение");
			}
			assertNotNull(propertiesHelper.getUserId());
		}
		{
			PropertiesHelper propertiesHelper = null;
			try {
				propertiesHelper = new PropertiesHelper(emptyConfigFileName);
			} catch (IOException e) {
				fail("Передача пустого файла для считывания конфигурации не должна вызывать ислючение");
			}
			assertNull(propertiesHelper.getUserId());
		}
	}

	@Test
	void getMapNumReturnsNotNull() {
		{
			PropertiesHelper propertiesHelper = null;
			try {
				propertiesHelper = new PropertiesHelper(configFileName);
			} catch (IOException e) {
				fail("Передача правильного файла для считывания конфигурации не должна вызывать ислючение");
			}
			assertNotNull(propertiesHelper.getMapNum());
		}
		{
			PropertiesHelper propertiesHelper = null;
			try {
				propertiesHelper = new PropertiesHelper(emptyConfigFileName);
			} catch (IOException e) {
				fail("Передача пустого файла для считывания конфигурации не должна вызывать ислючение");
			}
			assertNull(propertiesHelper.getMapNum());
		}
	}
}
