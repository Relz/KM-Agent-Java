package ru.relz.km.model.response.agent;

import ru.relz.km.model.response.cave.CaveInterface;
import ru.relz.km.model.agent.Direction;

import java.util.List;

public class Agent implements AgentInterface {
	Agent(
			int arrowCount,
			String name,
			Direction direction,
			int legCount,
			boolean isAlive,
			boolean hasGold,
			List<CaveInterface> knownCaves
	) {
		this.arrowCount = arrowCount;
		this.name = name;
		this.direction = direction;
		this.legCount = legCount;
		this.isAlive = isAlive;
		this.hasGold = hasGold;
		this.knownCaves = knownCaves;
	}

	private final int arrowCount;
	public int getArrowCount() {
		return arrowCount;
	}

	private final String name;
	public String getName() {
		return name;
	}

	private final Direction direction;
	public Direction getDirection() {
		return direction;
	}

	private final int legCount;
	public int getLegCount() {
		return legCount;
	}

	private final boolean isAlive;
	public boolean isAlive() {
		return isAlive;
	}

	private boolean hasGold;
	public boolean isHasGold() {
		return hasGold;
	}

	private final List<CaveInterface> knownCaves;
	public List<CaveInterface> getKnownCaves() {
		return knownCaves;
	}
}
