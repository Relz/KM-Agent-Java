package ru.relz.km.model.response.world_info;

public class WorldInfo implements WorldInfoInterface {
	WorldInfo(boolean isMonsterAlive) {
		this.isMonsterAlive = isMonsterAlive;
	}

	private boolean isMonsterAlive;
	public boolean isMonsterAlive() {
		return isMonsterAlive;
	}
}
