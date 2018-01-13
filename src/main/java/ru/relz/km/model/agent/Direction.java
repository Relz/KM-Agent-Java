package ru.relz.km.model.agent;

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

	public String getString() {
		return string;
	}

	public static Direction createFromString(String string) {
		return stringToDirection.get(string);
	}
}
