package ru.relz.km.model.position;

import java.util.List;

public interface PositionInterface {
	int getX();
	int getY();
	List<PositionInterface> getAroundPositions();
}
