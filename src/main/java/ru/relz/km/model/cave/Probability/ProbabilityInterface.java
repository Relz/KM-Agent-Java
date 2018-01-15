package ru.relz.km.model.cave.Probability;

public interface ProbabilityInterface {
	float getMonsterProbability();
	void setMonsterProbability(float monsterProbability);
	void increaseMonsterProbability(float increaseValue);
	float getHoleProbability();
	void setHoleProbability(float holeProbability);
	void increaseHoleProbability(float increaseValue);
}
