package ru.relz.km.model.cave;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaveTest {
	private CaveInterface cave;
	@BeforeEach
	void setUp() {
		cave = new Cave(false, false, false, false);
	}

	@Test
	void isVisible() {
		assertFalse(cave.isVisible());
	}

	@Test
	void setVisible() {
		cave.setVisible(true);
		assertTrue(cave.isVisible());
	}

	@Test
	void isHasGold() {
		assertFalse(cave.hasGold());
	}

	@Test
	void setHasGold() {
		cave.setHasGold(true);
		assertTrue(cave.hasGold());
	}

	@Test
	void isHasWind() {
		assertFalse(cave.hasWind());
	}

	@Test
	void setHasWind() {
		cave.setHasWind(true);
		assertTrue(cave.hasWind());
	}

	@Test
	void isHasBones() {
		assertFalse(cave.hasBones());
	}

	@Test
	void setHasBones() {
		cave.setHasBones(true);
		assertTrue(cave.hasBones());
	}

	@Test
	void getProbabilityIsNotNullByDefault() {
		assertNotNull(cave.getProbability());
	}

}