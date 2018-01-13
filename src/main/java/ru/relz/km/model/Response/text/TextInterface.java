package ru.relz.km.model.Response.text;

import ru.relz.km.model.Response.agent.AgentInterface;
import ru.relz.km.model.Response.cave.CaveInterface;

public interface TextInterface {
	String getNotification();
	Code getCode();
	CaveInterface getCurrentCave();
	AgentInterface getAgent();
}
