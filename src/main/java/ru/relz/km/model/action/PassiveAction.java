package ru.relz.km.model.action;

import ru.relz.km.model.agent.Direction;

public enum PassiveAction {
	NO_ACTION("noAct"),
	TURN_AROUND("upSideDn"),
	TURN_LEFT("onLeft"),
	TURN_RIGHT("onRight");

	private String command;
	PassiveAction(String command) {
		this.command = command;
	}

	@Override
	public String toString() {
		return command;
	}

	public static PassiveAction getRotateAction(Direction from, Direction to) {
		if (Direction.getInversion(from) == to) {
			return TURN_AROUND;
		} else if (Direction.getLeft(from) == to) {
			return TURN_LEFT;
		} else if (Direction.getRight(from) == to) {
			return TURN_RIGHT;
		}

		return NO_ACTION;
	}
}
