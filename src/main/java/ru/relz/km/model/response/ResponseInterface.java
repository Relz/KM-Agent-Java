package ru.relz.km.model.response;

import ru.relz.km.model.response.text.TextInterface;

public interface ResponseInterface {
	TextInterface getText();
	String getError();
	ErrorType getErrorType();
}
