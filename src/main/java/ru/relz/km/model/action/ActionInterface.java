package ru.relz.km.model.action;

public interface ActionInterface {
	PassiveAction getPassive();
	void setPassive(PassiveAction passive);

	ActiveAction getActive();
	void setActive(ActiveAction active);

	boolean isNoAction();
}
