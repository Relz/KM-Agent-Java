package ru.relz.km.model.cave;

import ru.relz.km.model.cave.Probability.ProbabilityInterface;

public interface CaveInterface {
	boolean isVisible();
	void setVisible(boolean visible);

	boolean hasGold();
	void setHasGold(boolean hasGold);

	boolean hasWind();
	void setHasWind(boolean hasWind);

	boolean hasBones();
	void setHasBones(boolean hasBones);

	ProbabilityInterface getProbability();
}
