package ru.relz.km.model.cave.Probability;

public class Probability implements ProbabilityInterface {
	private float monsterProbability;
	public float getMonsterProbability() {
		return monsterProbability;
	}

	public void setMonsterProbability(float monsterProbability) {
		this.monsterProbability = clamp(monsterProbability);
	}

	private float holeProbability;
	public float getHoleProbability() {
		return holeProbability;
	}

	public void setHoleProbability(float holeProbability) {
		this.holeProbability = clamp(holeProbability);
	}

	private static float clamp(float val) {
		return Math.max(0, Math.min(1, val));
	}
}
