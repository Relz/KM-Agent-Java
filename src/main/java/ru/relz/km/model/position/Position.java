package ru.relz.km.model.position;

public class Position implements PositionInterface {
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	private int x;
	public int getX() {
		return x;
	}

	private int y;
	public int getY() {
		return y;
	}
}
