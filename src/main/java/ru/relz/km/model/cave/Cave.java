package ru.relz.km.model.cave;

import ru.relz.km.model.cave.Probability.ProbabilityInterface;

public class Cave implements CaveInterface {
	private boolean isVisible;
	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean visible) {
		isVisible = visible;
	}

	private boolean hasGold;
	public boolean isHasGold() {
		return hasGold;
	}

	public void setHasGold(boolean hasGold) {
		this.hasGold = hasGold;
	}

	private boolean hasWind;
	public boolean isHasWind() {
		return hasWind;
	}

	public void setHasWind(boolean hasWind) {
		this.hasWind = hasWind;
	}

	private boolean hasBones;
	public boolean isHasBones() {
		return hasBones;
	}

	public void setHasBones(boolean hasBones) {
		this.hasBones = hasBones;
	}

	private ProbabilityInterface probability;
	public ProbabilityInterface getProbability() {
		return probability;
	}

	public void setProbability(ProbabilityInterface probability) {
		this.probability = probability;
	}
}
