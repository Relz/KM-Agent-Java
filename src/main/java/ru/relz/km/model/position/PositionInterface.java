package ru.relz.km.model.position;

import java.util.List;

public interface PositionInterface {
	int getX();
	int getY();

	List<PositionInterface> getAroundPositions();

	PositionInterface getUpPosition();
	List<PositionInterface> getUpPositions();

	PositionInterface getRightPosition();
	List<PositionInterface> getRightPositions();

	PositionInterface getDownPosition();
	List<PositionInterface> getDownPositions();

	PositionInterface getLeftPosition();
	List<PositionInterface> getLeftPositions();

	PositionInterface getPrevious();
	void setPrevious(PositionInterface previous);

	List<PositionInterface> getPreviousChain();
}
