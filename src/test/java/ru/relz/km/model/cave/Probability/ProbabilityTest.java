package ru.relz.km.model.cave.Probability;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProbabilityTest {
	private ProbabilityInterface probability;
	@BeforeEach
	void setUp() {
		probability = new Probability();
	}

	@Test
	void getMonsterProbabilityIsZeroByDefault() {
		assertEquals(0, probability.getMonsterProbability());
	}

	@Test
	void setMonsterProbability() {
		probability.setMonsterProbability(0.5f);
		assertEquals(0.5f, probability.getMonsterProbability());

		probability.setMonsterProbability(1.5f);
		assertEquals(1.f, probability.getMonsterProbability());
	}

	@Test
	void getHoleProbabilityIsZeroByDefault() {
		assertEquals(0, probability.getHoleProbability());
	}

	@Test
	void setHoleProbability() {
		probability.setHoleProbability(0.7f);
		assertEquals(0.7f, probability.getHoleProbability());

		probability.setHoleProbability(1.5f);
		assertEquals(1.f, probability.getHoleProbability());
	}

}