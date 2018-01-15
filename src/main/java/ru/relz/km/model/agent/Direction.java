package ru.relz.km.model.agent;

import ru.relz.km.model.position.PositionInterface;

import java.util.*;

public enum Direction {
	UP("Up"),
	RIGHT("Right"),
	DOWN("Down"),
	LEFT("Left");

	private String string;
	Direction(String string) {
		this.string = string;
	}

	private static Map<String, Direction> stringToDirection = new HashMap<>(){{
		put(UP.string, UP);
		put(RIGHT.string, RIGHT);
		put(DOWN.string, DOWN);
		put(LEFT.string, LEFT);
	}};

	private static Map<Direction, Direction> inversions = new HashMap<>(){{
		put(UP, DOWN);
		put(RIGHT, LEFT);
		put(DOWN, UP);
		put(LEFT, RIGHT);
	}};

	private static Map<Direction, Direction> lefts = new HashMap<>(){{
		put(UP, LEFT);
		put(LEFT, DOWN);
		put(DOWN, RIGHT);
		put(RIGHT, UP);
	}};

	private static Map<Direction, Direction> rights = new HashMap<>(){{
		put(UP, RIGHT);
		put(RIGHT, DOWN);
		put(DOWN, LEFT);
		put(LEFT, UP);
	}};

	public String getString() {
		return string;
	}

	public static Direction createFromString(String string) {
		return stringToDirection.get(string);
	}

	public static Direction getInversion(Direction direction) {
		return inversions.get(direction);
	}

	public static Direction getLeft(Direction direction) {
		return lefts.get(direction);
	}

	public static Direction getRight(Direction direction) {
		return rights.get(direction);
	}

	public static Direction createToPosition(PositionInterface from, PositionInterface to) {
		if (from.getY() < to.getY()) {
			return Direction.DOWN;
		}
		if (from.getX() < to.getX()) {
			return Direction.RIGHT;
		}
		if (from.getY() > to.getY()) {
			return Direction.UP;
		}
		if (from.getX() > to.getX()) {
			return Direction.LEFT;
		}

		return null;
	}
}
