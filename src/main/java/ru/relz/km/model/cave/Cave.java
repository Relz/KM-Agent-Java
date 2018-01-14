package ru.relz.km.model.cave;

import ru.relz.km.model.cave.Probability.Probability;
import ru.relz.km.model.cave.Probability.ProbabilityInterface;

public class Cave implements CaveInterface {
	public Cave(boolean isVisible, boolean hasGold, boolean hasWind, boolean hasBones) {
		this.isVisible = isVisible;
		this.hasGold = hasGold;
		this.hasWind = hasWind;
		this.hasBones = hasBones;
	}

	private boolean isVisible;
	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean visible) {
		isVisible = visible;
	}

	private boolean hasGold;
	public boolean hasGold() {
		return hasGold;
	}

	public void setHasGold(boolean hasGold) {
		this.hasGold = hasGold;
	}

	private boolean hasWind;
	public boolean hasWind() {
		return hasWind;
	}

	public void setHasWind(boolean hasWind) {
		this.hasWind = hasWind;
	}

	private boolean hasBones;
	public boolean hasBones() {
		return hasBones;
	}

	public void setHasBones(boolean hasBones) {
		this.hasBones = hasBones;
	}

	private final ProbabilityInterface probability = new Probability();
	public ProbabilityInterface getProbability() {
		return probability;
	}
}
