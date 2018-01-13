package ru.relz.km.model.action;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassiveActionTest {
	@Test
	void toStringReturnsActionCommand() {
		assertEquals("noAct", PassiveAction.NO_ACTION.toString());
		assertEquals("upSideDown", PassiveAction.TURN_AROUND.toString());
		assertEquals("onLeft", PassiveAction.TURN_LEFT.toString());
		assertEquals("onRight", PassiveAction.TURN_RIGHT.toString());
	}
}