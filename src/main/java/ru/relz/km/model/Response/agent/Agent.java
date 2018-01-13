package ru.relz.km.model.Response.agent;

import ru.relz.km.model.agent.Direction;

public class Agent implements AgentInterface {
	Agent(int arrowCount, String name, Direction direction, int legsCount, boolean isAlive) {
		this.arrowCount = arrowCount;
		this.name = name;
		this.direction = direction;
		this.legsCount = legsCount;
		this.isAlive = isAlive;
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
}
