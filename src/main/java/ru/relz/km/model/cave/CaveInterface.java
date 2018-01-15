package ru.relz.km.model.cave;

import ru.relz.km.model.cave.Probability.ProbabilityInterface;

public interface CaveInterface {
	boolean isVisible();
	void setVisible(boolean visible);

	Boolean hasGold();
	void setHasGold(boolean hasGold);

	Boolean hasWind();
	void setHasWind(boolean hasWind);

	Boolean hasBones();
	void setHasBones(boolean hasBones);

	ProbabilityInterface getProbability();

	void update(boolean isVisible, Boolean hasGold, Boolean hasWind, Boolean hasBones);
}
