package ru.relz.km.model.Response.cave;

import ru.relz.km.model.position.PositionInterface;

public interface CaveInterface {
	PositionInterface getPosition();
	boolean isGold();
	boolean isMonster();
	boolean isHole();
	boolean isWind();
	boolean isBones();
}
