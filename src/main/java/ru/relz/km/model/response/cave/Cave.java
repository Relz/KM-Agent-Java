package ru.relz.km.model.response.cave;

import ru.relz.km.model.position.PositionInterface;

public class Cave implements CaveInterface {
	Cave(PositionInterface position, boolean hasGold, boolean hasMonster, boolean hasHole, boolean hasWind, boolean hasBones) {
		this.position = position;
		this.hasGold = hasGold;
		this.hasMonster = hasMonster;
		this.hasHole = hasHole;
		this.hasWind = hasWind;
		this.hasBones = hasBones;
	}

	private final PositionInterface position;
	public PositionInterface getPosition() {
		return position;
	}

	private final boolean hasGold;
	public boolean hasGold() {
		return hasGold;
	}

	private final boolean hasMonster;
	public boolean hasMonster() {
		return hasMonster;
	}

	private final boolean hasHole;
	public boolean hasHole() {
		return hasHole;
	}

	private final boolean hasWind;
	public boolean hasWind() {
		return hasWind;
	}

	private final boolean hasBones;
	public boolean hasBones() {
		return hasBones;
	}
}
