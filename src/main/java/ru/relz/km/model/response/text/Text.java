package ru.relz.km.model.response.text;

import ru.relz.km.model.response.agent.AgentInterface;
import ru.relz.km.model.response.cave.CaveInterface;
import ru.relz.km.model.response.world_info.WorldInfoInterface;

public class Text implements TextInterface {
	Text(String notification, Code code, CaveInterface currentCave, AgentInterface agent, WorldInfoInterface worldInfo) {
		this.notification = notification;
		this.code = code;
		this.currentCave = currentCave;
		this.agent = agent;
		this.isMonsterAlive = worldInfo.isMonsterAlive();
	}

	private final String notification;
	public String getNotification() {
		return notification;
	}

	private final Code code;
	public Code getCode() {
		return code;
	}

	private final CaveInterface currentCave;
	public CaveInterface getCurrentCave() {
		return currentCave;
	}

	private final AgentInterface agent;
	public AgentInterface getAgent() {
		return agent;
	}

	private final boolean isMonsterAlive;
	public boolean isMonsterAlive() {
		return isMonsterAlive;
	}
}
