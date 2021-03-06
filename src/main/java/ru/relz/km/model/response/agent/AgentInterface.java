package ru.relz.km.model.response.agent;

import ru.relz.km.model.response.cave.CaveInterface;
import ru.relz.km.model.agent.Direction;

import java.util.List;

public interface AgentInterface {
	int getArrowCount();
	String getName();
	Direction getDirection();
	int getLegCount();
	boolean isAlive();
	boolean isHasGold();
	List<CaveInterface> getKnownCaves();
}
