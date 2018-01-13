package ru.relz.km;

import ru.relz.km.http_request.HttpRequestHelper;
import ru.relz.km.model.action.Action;

public class Agent {
	public static void main(String[] args) {
		HttpRequestHelper.send(new Action());
	}
}
