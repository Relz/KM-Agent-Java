package ru.relz.km.model.Response.cave;

public class Cave implements CaveInterface {
	Cave(int x, int y, boolean isGold, boolean isMonster, boolean isHole, boolean isWind, boolean isBones) {
		this.x = x;
		this.y = y;
		this.isGold = isGold;
		this.isMonster = isMonster;
		this.isHole = isHole;
		this.isWind = isWind;
		this.isBones = isBones;
	}

	private int x;
	public int getX() {
		return x;
	}

	private int y;
	public int getY() {
		return y;
	}

	private boolean isGold;
	public boolean isGold() {
		return isGold;
	}

	private boolean isMonster;
	public boolean isMonster() {
		return isMonster;
	}

	private boolean isHole;
	public boolean isHole() {
		return isHole;
	}

	private boolean isWind;
	public boolean isWind() {
		return isWind;
	}

	private boolean isBones;
	public boolean isBones() {
		return isBones;
	}
}
