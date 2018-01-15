package ru.relz.km.model.agent;

import ru.relz.km.model.position.PositionInterface;
import ru.relz.km.model.world_info.WorldInfoInterface;

public interface AgentInterface {
	PositionInterface getPosition();
	int getArrowCount();
	String getName();
	Direction getDirection();
	int getLegCount();
	boolean isAlive();
	boolean isHasGold();
	void setWorldInfo(WorldInfoInterface worldInfo);
	boolean proceed();
}
