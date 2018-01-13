package ru.relz.km.model.cave;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaveTest {
	private CaveInterface cave;
	@BeforeEach
	void setUp() {
		cave = new Cave();
	}

	@Test
	void isVisibleIsFalseByDefault() {
		assertEquals(false, cave.isVisible());
	}

	@Test
	void setVisible() {
		cave.setVisible(true);
		assertTrue(cave.isVisible());
	}

	@Test
	void isHasGoldIsFalseByDefault() {
		assertEquals(false, cave.isHasGold());
	}

	@Test
	void setHasGold() {
		cave.setHasGold(true);
		assertTrue(cave.isHasGold());
	}

	@Test
	void isHasWindIsFalseByDefault() {
		assertEquals(false, cave.isHasWind());
	}

	@Test
	void setHasWind() {
		cave.setHasWind(true);
		assertTrue(cave.isHasWind());
	}

	@Test
	void isHasBonesIsFalseByDefault() {
		assertEquals(false, cave.isHasBones());
	}

	@Test
	void setHasBones() {
		cave.setHasBones(true);
		assertTrue(cave.isHasBones());
	}

	@Test
	void getProbabilityIsNotNullByDefault() {
		assertNotNull(cave.getProbability());
	}

}