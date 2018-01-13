package ru.relz.km.model.action;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActiveActionTest {
	@Test
	void toStringReturnsActionCommand() {
		assertEquals("noAct", ActiveAction.NO_ACTION.toString());
		assertEquals("Go", ActiveAction.GO.toString());
		assertEquals("Shoot", ActiveAction.SHOOT.toString());
		assertEquals("Take", ActiveAction.TAKE_GOLD.toString());
	}
}