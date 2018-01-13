package ru.relz.km.model.Response.text;

import java.util.*;

public enum Code {
	OK(200),
	WRONG_AGENT_TYPE(406),
	BAD_REQUEST(501),
	AGENT_IS_DEAD(0),
	MOVING_LIMIT(1),
	VICTORY(2),
	NO_GOLD_IN_CAVE(3),
	NO_ARROWS(4),
	WALL_AHEAD(5);

	private int number;
	Code(int number) {
		this.number = number;
	}

	private static Map<Integer, Code> codeToCode = new HashMap<>(){{
		put(OK.number, OK);
		put(WRONG_AGENT_TYPE.number, WRONG_AGENT_TYPE);
		put(BAD_REQUEST.number, BAD_REQUEST);
		put(AGENT_IS_DEAD.number, AGENT_IS_DEAD);
		put(MOVING_LIMIT.number, MOVING_LIMIT);
		put(VICTORY.number, VICTORY);
		put(NO_GOLD_IN_CAVE.number, NO_GOLD_IN_CAVE);
		put(NO_ARROWS.number, NO_ARROWS);
		put(WALL_AHEAD.number, WALL_AHEAD);
	}};

	public int getNumber() {
		return number;
	}

	public static Code createFromNumber(int code) {
		return codeToCode.get(code);
	}
}
