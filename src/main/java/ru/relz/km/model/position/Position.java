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
		return new ArrayList<>(){{
			PositionInterface upPosition = getUpPosition();
			if (upPosition != null) {
				add(getUpPosition());
			}
			PositionInterface rightPosition = getRightPosition();
			if (rightPosition != null) {
				add(rightPosition);
			}
			PositionInterface downPosition = getDownPosition();
			if (downPosition != null) {
				add(downPosition);
			}
			PositionInterface leftPosition = getLeftPosition();
			if (leftPosition != null) {
				add(leftPosition);
			}
		}};
	}

	public PositionInterface getUpPosition() {
		if (y - 1 >= 0) {
			return new Position(x, y - 1);
		}

		return null;
	}

	public List<PositionInterface> getUpPositions() {
		return getSidePositions(PositionInterface::getUpPosition);
	}

	public PositionInterface getRightPosition() {
		if (limits == null || x + 1 <= limits.getX()) {
			return new Position(x + 1, y);
		}

		return null;
	}

	public List<PositionInterface> getRightPositions() {
		return getSidePositions(PositionInterface::getRightPosition);
	}

	public PositionInterface getDownPosition() {
		if (limits == null || y + 1 <= limits.getY()) {
			return new Position(x, y + 1);
		}

		return null;
	}

	public List<PositionInterface> getDownPositions() {
		return getSidePositions(PositionInterface::getDownPosition);
	}

	public PositionInterface getLeftPosition() {
		if (x - 1 >= 0) {
			return new Position(x - 1, y);
		}

		return null;
	}

	public List<PositionInterface> getLeftPositions() {
		return getSidePositions(PositionInterface::getLeftPosition);
	}

	private PositionInterface previous;
	public PositionInterface getPrevious() {
		return previous;
	}

	public void setPrevious(PositionInterface previous) {
		this.previous = previous;
	}

	public List<PositionInterface> getPreviousChain() {
		return new ArrayList<>() {{
			if (previous != null && previous.getPrevious() != null) {
				add(previous);
				addAll(previous.getPreviousChain());
			}
		}};
	}

	private List<PositionInterface> getSidePositions(getSidePositionInterface getSidePosition) {
		List<PositionInterface> result = new ArrayList<>();
		PositionInterface sidePosition = getSidePosition.method(this);
		while (sidePosition != null) {
			result.add(sidePosition);
			sidePosition = getSidePosition.method(sidePosition);
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

	public static int calculateDistance(PositionInterface from, PositionInterface to) {
		int greaterX = Math.max(from.getX(), to.getX());
		int lessX = Math.min(from.getX(), to.getX());
		int greaterY = Math.max(from.getY(), to.getY());
		int lessY = Math.min(from.getY(), to.getY());

		return greaterX - lessX + greaterY - lessY;
	}
}
