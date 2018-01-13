package ru.relz.km.model.Response;

import ru.relz.km.model.Response.text.TextInterface;

public class Response implements ResponseInterface {
	public Response(TextInterface text, String error, ErrorType errorType) {
		this.text = text;
		this.error = error;
		this.errorType = errorType;
	}

	private TextInterface text;
	public TextInterface getText() {
		return text;
	}

	private String error;
	public String getError() {
		return error;
	}

	private ErrorType errorType;
	public ErrorType getErrorType() {
		return errorType;
	}
}
