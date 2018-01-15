package ru.relz.km.model.cave.Probability;

public class Probability implements ProbabilityInterface {
	private float monsterProbability;
	public float getMonsterProbability() {
		return monsterProbability;
	}

	public void setMonsterProbability(float monsterProbability) {
		this.monsterProbability = clamp(monsterProbability);
	}

	public void increaseMonsterProbability(float increaseValue) {
		setMonsterProbability(monsterProbability + increaseValue);
	}

	private float holeProbability;
	public float getHoleProbability() {
		return holeProbability;
	}

	public void setHoleProbability(float holeProbability) {
		this.holeProbability = clamp(holeProbability);
	}

	public void increaseHoleProbability(float increaseValue) {
		setHoleProbability(holeProbability + increaseValue);
	}

	private static float clamp(float val) {
		return Math.max(0, Math.min(1, val));
	}
}
