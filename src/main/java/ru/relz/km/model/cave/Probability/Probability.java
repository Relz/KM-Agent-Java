package ru.relz.km.model.cave.Probability;

public class Probability implements ProbabilityInterface {
	private float monsterProbability;
	public float getMonsterProbability() {
		return monsterProbability;
	}

	public void setMonsterProbability(float monsterProbability) {
		this.monsterProbability = monsterProbability;
	}

	private float holeProbability;
	public float getHoleProbability() {
		return holeProbability;
	}

	public void setHoleProbability(float holeProbability) {
		this.holeProbability = holeProbability;
	}
}
