package ru.relz.km.model.response.text;

import ru.relz.km.model.response.agent.AgentInterface;
import ru.relz.km.model.response.cave.CaveInterface;

public interface TextInterface {
	String getNotification();
	Code getCode();
	CaveInterface getCurrentCave();
	AgentInterface getAgent();
}
