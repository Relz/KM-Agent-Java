package ru.relz.km.model.position;

import java.util.ArrayList;
import java.util.List;

public class Position implements PositionInterface {
	private static PositionInterface limits;

	public Position(int x, int y) {
		this.x = limits == null ? x : Math.min(x, limits.getX());
		this.y = limits == null ? y : Math.min(y, limits.getY());
	}

	private int x;
	public int getX() {
		return x;
	}

	private int y;
	public int getY() {
		return y;
	}

	public List<PositionInterface> getAroundPositions() {
		List<PositionInterface> result = new ArrayList<>();
		if (y - 1 >= 0) {
			result.add(new Position(x, y - 1));
		}
		if (limits == null || x + 1 <= limits.getX()) {
			result.add(new Position(x + 1, y));
		}
		if (limits == null || y + 1 <= limits.getY()) {
			result.add(new Position(x, y + 1));
		}
		if (x - 1 >= 0) {
			result.add(new Position(x - 1, y));
		}

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PositionInterface other = (PositionInterface) obj;

		return x == other.getX() && y == other.getY();
	}

	@Override
	public int hashCode() {
		return x + y * limits.getX() * limits.getY();
	}

	public static void setLimits(PositionInterface limits) {
		Position.limits = limits;
	}
}
