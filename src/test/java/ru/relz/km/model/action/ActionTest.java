package ru.relz.km.model.action;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {
	private ActionInterface action;
	@BeforeEach
	void setUp() {
		action = new Action();
	}

	@Test
	void getPassiveIsNoActionByDefault() {
		assertEquals(PassiveAction.NO_ACTION, action.getPassive());
	}

	@Test
	void setPassive() {
		action.setPassive(PassiveAction.NO_ACTION);
		assertEquals(PassiveAction.NO_ACTION, action.getPassive());
	}

	@Test
	void getActiveIsNoActionByDefault() {
		assertEquals(ActiveAction.NO_ACTION, action.getActive());
	}

	@Test
	void setActive() {
		action.setActive(ActiveAction.NO_ACTION);
		assertEquals(ActiveAction.NO_ACTION, action.getActive());
	}

}