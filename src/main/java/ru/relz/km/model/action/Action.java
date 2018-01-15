package ru.relz.km.model.action;

public class Action implements ActionInterface {
	private PassiveAction passive = PassiveAction.NO_ACTION;
	public PassiveAction getPassive() {
		return passive;
	}

	public void setPassive(PassiveAction passive) {
		this.passive = passive;
	}

	private ActiveAction active = ActiveAction.NO_ACTION;
	public ActiveAction getActive() {
		return active;
	}

	public void setActive(ActiveAction active) {
		this.active = active;
	}

	public boolean isNoAction() {
		return passive == PassiveAction.NO_ACTION && active == ActiveAction.NO_ACTION;
	}
}
