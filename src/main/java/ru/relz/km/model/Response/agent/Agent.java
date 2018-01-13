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

	private int arrowCount;
	public int getArrowCount() {
		return arrowCount;
	}

	private String name;
	public String getName() {
		return name;
	}

	private Direction direction;
	public Direction getDirection() {
		return direction;
	}

	private int legsCount;
	public int getLegsCount() {
		return legsCount;
	}

	private boolean isAlive;
	public boolean isAlive() {
		return isAlive;
	}
}
