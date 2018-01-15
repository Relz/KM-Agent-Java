package ru.relz.km.model.cave;

import ru.relz.km.model.cave.Probability.Probability;
import ru.relz.km.model.cave.Probability.ProbabilityInterface;

public class Cave implements CaveInterface {
	public Cave(boolean isVisible, Boolean hasGold, Boolean hasWind, Boolean hasBones) {
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

	private Boolean hasGold;
	public Boolean hasGold() {
		return hasGold;
	}

	public void setHasGold(boolean hasGold) {
		this.hasGold = hasGold;
	}

	private Boolean hasWind;
	public Boolean hasWind() {
		return hasWind;
	}

	public void setHasWind(boolean hasWind) {
		this.hasWind = hasWind;
	}

	private Boolean hasBones;
	public Boolean hasBones() {
		return hasBones;
	}

	public void setHasBones(boolean hasBones) {
		this.hasBones = hasBones;
	}

	private final ProbabilityInterface probability = new Probability();
	public ProbabilityInterface getProbability() {
		return probability;
	}

	public void update(boolean isVisible, Boolean hasGold, Boolean hasWind, Boolean hasBones) {
		this.isVisible = isVisible;
		this.hasGold = hasGold;
		this.hasWind = hasWind;
		this.hasBones = hasBones;
		this.getProbability().setMonsterProbability(0);
		this.getProbability().setHoleProbability(0);
	}
}
