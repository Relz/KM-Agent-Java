package ru.relz.km.model.Response.agent;

import ru.relz.km.model.agent.Direction;

public interface AgentInterface {
	int getArrowCount();
	String getName();
	Direction getDirection();
	int getLegsCount();
	boolean isAlive();
}
