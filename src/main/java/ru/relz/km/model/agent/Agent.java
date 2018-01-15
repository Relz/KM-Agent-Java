package ru.relz.km.model.agent;

import ru.relz.km.http_request.HttpRequestHelper;
import ru.relz.km.model.action.Action;
import ru.relz.km.model.response.ResponseInterface;
import ru.relz.km.model.world_info.WorldInfo;
import ru.relz.km.model.world_info.WorldInfoInterface;

import java.util.ArrayList;
import java.util.List;

public class Agent implements AgentInterface {
	private List<Action> actions = new ArrayList<>();

	private Agent(
			int arrowCount,
			String name,
			Direction direction,
			int legCount,
			boolean isAlive,
			WorldInfoInterface worldInfo
	) {
		update(arrowCount, name, direction, legCount, isAlive, worldInfo);
	}

	public Agent() {
		doAction(new Action());
	}

	private int arrowCount;
	public int getArrowCount() {
		return arrowCount;
	}

	private String name;
	public String getName() {
		return name;
	}

	private Direction direction;
	public Direction getDirection() {
		return direction;
	}

	private int legCount;
	public int getLegCount() {
		return legCount;
	}

	private boolean isAlive;
	public boolean isAlive() {
		return isAlive;
	}

	private WorldInfoInterface worldInfo;
	public void setWorldInfo(WorldInfoInterface worldInfo) {
		this.worldInfo = worldInfo;
	}

	public boolean proceed() {
		if (!actions.isEmpty()) {
			doAction(actions.get(0));
			return true;
		}
		return false;
	}

	private void doAction(Action action) {
		ResponseInterface response = HttpRequestHelper.send(action);
		if (response == null) {
			System.exit(1);
		}
		ru.relz.km.model.response.agent.AgentInterface agent = response.getText().getAgent();

		update(
				agent.getArrowCount(),
				agent.getName(),
				agent.getDirection(),
				agent.getLegCount(),
				agent.isAlive(),
				WorldInfo.create(agent.getKnownCaves())
		);
	}

	private void update(
			int arrowCount,
			String name,
			Direction direction,
			int legCount,
			boolean isAlive,
			WorldInfoInterface worldInfo
	) {
		this.arrowCount = arrowCount;
		this.name = name;
		this.direction = direction;
		this.legCount = legCount;
		this.isAlive = isAlive;
		this.worldInfo = worldInfo;
	}
}
