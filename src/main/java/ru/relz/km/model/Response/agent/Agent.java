package ru.relz.km.model.Response.agent;

import ru.relz.km.model.Response.cave.CaveInterface;
import ru.relz.km.model.agent.Direction;

import java.util.List;

public class Agent implements AgentInterface {
	Agent(
			int arrowCount,
			String name,
			Direction direction,
			int legsCount,
			boolean isAlive,
			List<CaveInterface> knownCaves
	) {
		this.arrowCount = arrowCount;
		this.name = name;
		this.direction = direction;
		this.legsCount = legsCount;
		this.isAlive = isAlive;
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

	private final int legsCount;
	public int getLegsCount() {
		return legsCount;
	}

	private final boolean isAlive;
	public boolean isAlive() {
		return isAlive;
	}

	private final List<CaveInterface> knownCaves;
	public List<CaveInterface> getKnownCaves() {
		return knownCaves;
	}
}
