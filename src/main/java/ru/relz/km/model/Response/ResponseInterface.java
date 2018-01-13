package ru.relz.km.model.Response;

import ru.relz.km.model.Response.text.TextInterface;

public interface ResponseInterface {
	TextInterface getText();
	String getError();
	ErrorType getErrorType();
}
