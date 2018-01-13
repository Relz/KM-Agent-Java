package ru.relz.km.model.Response.text;

import ru.relz.km.model.Response.agent.AgentInterface;
import ru.relz.km.model.Response.cave.CaveInterface;

public class Text implements TextInterface {
	Text(String notification, Code code, CaveInterface currentCave, AgentInterface agent) {
		this.notification = notification;
		this.code = code;
		this.currentCave = currentCave;
		this.agent = agent;
	}

	private String notification;
	public String getNotification() {
		return notification;
	}

	private Code code;
	public Code getCode() {
		return code;
	}

	private CaveInterface currentCave;
	public CaveInterface getCurrentCave() {
		return currentCave;
	}

	private AgentInterface agent;
	public AgentInterface getAgent() {
		return agent;
	}
}
