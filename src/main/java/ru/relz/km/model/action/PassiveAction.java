package ru.relz.km.model.action;

public enum PassiveAction {
	NO_ACTION("noAct"),
	TURN_AROUND("upSideDown"),
	TURN_LEFT("onLeft"),
	TURN_RIGHT("onRight");

	private String command;
	private PassiveAction(String command) {
		this.command = command;
	}

	@Override
	public String toString() {
		return command;
	}
}
