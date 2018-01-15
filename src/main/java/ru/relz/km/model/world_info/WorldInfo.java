package ru.relz.km.model.world_info;

import ru.relz.km.model.cave.Cave;
import ru.relz.km.model.cave.CaveInterface;
import ru.relz.km.model.position.Position;
import ru.relz.km.model.position.PositionInterface;

import java.util.*;

public class WorldInfo implements WorldInfoInterface {
	private static final int mapWidth = 4;
	private static final int mapHeight = 4;

	private WorldInfo(
			boolean isMonsterAlive,
			int holeCount,
			boolean doesTreasureTaken,
			List<ru.relz.km.model.response.cave.CaveInterface> knownCaves
	) {
		Position.setLimits(new Position(mapWidth - 1, mapHeight - 1));
		this.isMonsterAlive = isMonsterAlive;
		this.holeCount = holeCount;
		this.doesTreasureTaken = doesTreasureTaken;
		updateCaves(knownCaves);
	}

	private boolean isMonsterAlive;
	public boolean isMonsterAlive() {
		return isMonsterAlive;
	}

	public void setMonsterAlive(boolean isMonsterAlive) {
		this.isMonsterAlive = isMonsterAlive;
	}

	private PositionInterface monsterPosition;
	public PositionInterface getMonsterPosition() {
		return monsterPosition;
	}

	public void setMonsterPosition(PositionInterface monsterPosition) {
		this.monsterPosition = monsterPosition;
	}

	private int holeCount;
	public int getHoleCount() {
		return holeCount;
	}

	public void decreaseHoleCount() {
		--holeCount;
	}

	private boolean doesTreasureTaken;
	public boolean doesTreasureTaken() {
		return doesTreasureTaken;
	}

	public void setDoesTreasureTaken(boolean doesTreasureTaken) {
		this.doesTreasureTaken = doesTreasureTaken;
	}

	private PositionInterface treasurePosition;
	public PositionInterface getTreasurePosition() {
		return treasurePosition;
	}

	public void setTreasurePosition(PositionInterface treasurePosition) {
		this.treasurePosition = treasurePosition;
	}

	private final Map<PositionInterface, CaveInterface> caves = new HashMap<>();
	public Map<PositionInterface, CaveInterface> getCaves() {
		return caves;
	}

	private final Set<PositionInterface> knownCavesPositions = new HashSet<>();

	private void updateCaves(List<ru.relz.km.model.response.cave.CaveInterface> knownCaves) {
		initCaves();
		knownCavesPositions.clear();

		for (ru.relz.km.model.response.cave.CaveInterface knownCave : knownCaves) {
			knownCavesPositions.add(knownCave.getPosition());

			CaveInterface cave = this.caves.get(knownCave.getPosition());
			cave.setVisible(true);
			cave.setHasGold(knownCave.hasGold());
			cave.setHasWind(knownCave.hasWind());
			cave.setHasBones(knownCave.hasBones());

			if (knownCave.hasMonster()) {
				cave.getProbability().setMonsterProbability(1);
				monsterPosition = knownCave.getPosition();
			}
			if (knownCave.hasHole()) {
				cave.getProbability().setHoleProbability(1);
			}
			if (knownCave.hasGold()) {
				treasurePosition = knownCave.getPosition();
			}
		}

		updateCavesProbabilities();
	}

	private void initCaves() {
		for (int y = 0; y < mapHeight; ++y) {
			for (int x = 0; x < mapWidth; ++x) {
				this.caves.put(new Position(x, y), new Cave(false, null, null, null));
			}
		}
	}

	private void updateCavesProbabilities() {
		for (Map.Entry<PositionInterface, CaveInterface> caveEntry : this.caves.entrySet()) {
			PositionInterface cavePosition = caveEntry.getKey();
			CaveInterface cave = caveEntry.getValue();
			if (cave.hasBones() != null && cave.hasBones() && monsterPosition == null) {
				List<PositionInterface> aroundPositions = cavePosition.getAroundPositions();
				for (PositionInterface aroundPosition : aroundPositions) {
					if (isUnknownCave(aroundPosition)) {
						this.caves.get(aroundPosition).getProbability().increaseMonsterProbability(0.25f);
					}
				}
			}
			if (cave.hasWind() != null && cave.hasWind()) {
				List<PositionInterface> aroundPositions = cavePosition.getAroundPositions();
				for (PositionInterface aroundPosition : aroundPositions) {
					if (isUnknownCave(aroundPosition)) {
						this.caves.get(aroundPosition).getProbability().increaseHoleProbability(0.25f);
					}
				}
			}
		}
	}

	private boolean isUnknownCave(PositionInterface position) {
		return !knownCavesPositions.contains(position);
	}

	public static WorldInfoInterface create(List<ru.relz.km.model.response.cave.CaveInterface> knownCaves) {
		return new WorldInfo(true, 2, false, knownCaves);
	}
}
