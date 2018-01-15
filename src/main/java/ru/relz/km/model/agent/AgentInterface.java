package ru.relz.km.model.agent;

import ru.relz.km.model.world_info.WorldInfoInterface;

public interface AgentInterface {
	int getArrowCount();
	String getName();
	Direction getDirection();
	int getLegCount();
	boolean isAlive();
	void setWorldInfo(WorldInfoInterface worldInfo);
	boolean proceed();
}
