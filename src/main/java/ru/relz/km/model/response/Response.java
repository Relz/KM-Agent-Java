package ru.relz.km.model.response;

import ru.relz.km.model.response.text.TextInterface;

public class Response implements ResponseInterface {
	Response(TextInterface text, String error, ErrorType errorType) {
		this.text = text;
		this.error = error;
		this.errorType = errorType;
	}

	private final TextInterface text;
	public TextInterface getText() {
		return text;
	}

	private final String error;
	public String getError() {
		return error;
	}

	private final ErrorType errorType;
	public ErrorType getErrorType() {
		return errorType;
	}
}
