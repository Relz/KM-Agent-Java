package ru.relz.km.model.response.cave;

import ru.relz.km.model.position.PositionInterface;

public interface CaveInterface {
	PositionInterface getPosition();
	boolean hasGold();
	boolean hasMonster();
	boolean hasHole();
	boolean hasWind();
	boolean hasBones();
}
