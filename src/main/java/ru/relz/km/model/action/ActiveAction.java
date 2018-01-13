package ru.relz.km.model.action;

public enum ActiveAction {
	NO_ACTION("noAct"),
	GO("Go"),
	SHOOT("Shoot"),
	TAKE_GOLD("Take");

	private String command;
	private ActiveAction(String command) {
		this.command = command;
	}

	@Override
	public String toString() {
		return command;
	}
}
