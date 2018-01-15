package ru.relz.km.model.response;

import java.util.*;

public enum ErrorType {
	ERROR("error"),
	NOTIFICATION("notification");

	private final String string;
	ErrorType(String string) {
		this.string = string;
	}

	private static final Map<String, ErrorType> stringToErrorType = new HashMap<>(){{
		put(ERROR.string, ERROR);
		put(NOTIFICATION.string, NOTIFICATION);
	}};

	public String getString() {
		return string;
	}

	public static ErrorType createFromString(String string) {
		return stringToErrorType.get(string);
	}
}
