package ru.relz.km.model.world_info;

import ru.relz.km.model.cave.CaveInterface;
import ru.relz.km.model.position.PositionInterface;

import java.util.Map;

public interface WorldInfoInterface {
	boolean isMonsterAlive();
	void setMonsterAlive(boolean isMonsterAlive);

	PositionInterface getMonsterPosition();
	void setMonsterPosition(PositionInterface monsterPosition);

	int getHoleCount();
	void decreaseHoleCount();

	boolean doesTreasureTaken();
	void setDoesTreasureTaken(boolean doesTreasureTaken);

	void setTreasurePosition(PositionInterface treasurePosition);
	PositionInterface getTreasurePosition();

	Map<PositionInterface, CaveInterface> getCaves();
}
