package ru.relz.km.model.Response.cave;

import ru.relz.km.model.position.PositionInterface;

public class Cave implements CaveInterface {
	Cave(PositionInterface position, boolean isGold, boolean isMonster, boolean isHole, boolean isWind, boolean isBones) {
		this.position = position;
		this.isGold = isGold;
		this.isMonster = isMonster;
		this.isHole = isHole;
		this.isWind = isWind;
		this.isBones = isBones;
	}

	private final PositionInterface position;
	public PositionInterface getPosition() {
		return position;
	}

	private final boolean isGold;
	public boolean isGold() {
		return isGold;
	}

	private final boolean isMonster;
	public boolean isMonster() {
		return isMonster;
	}

	private final boolean isHole;
	public boolean isHole() {
		return isHole;
	}

	private final boolean isWind;
	public boolean isWind() {
		return isWind;
	}

	private final boolean isBones;
	public boolean isBones() {
		return isBones;
	}
}
