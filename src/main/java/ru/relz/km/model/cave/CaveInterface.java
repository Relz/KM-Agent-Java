package ru.relz.km.model.cave;

import ru.relz.km.model.cave.Probability.ProbabilityInterface;

public interface CaveInterface {
	boolean isVisible();
	void setVisible(boolean visible);

	boolean isHasGold();
	void setHasGold(boolean hasGold);

	boolean isHasWind();
	void setHasWind(boolean hasWind);

	boolean isHasBones();
	void setHasBones(boolean hasBones);

	ProbabilityInterface getProbability();
}
