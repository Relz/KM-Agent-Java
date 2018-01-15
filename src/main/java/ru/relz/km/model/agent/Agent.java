package ru.relz.km.model.agent;

import ru.relz.km.http_request.HttpRequestHelper;
import ru.relz.km.model.action.Action;
import ru.relz.km.model.action.ActionInterface;
import ru.relz.km.model.action.ActiveAction;
import ru.relz.km.model.action.PassiveAction;
import ru.relz.km.model.cave.Probability.ProbabilityInterface;
import ru.relz.km.model.position.Position;
import ru.relz.km.model.position.PositionInterface;
import ru.relz.km.model.response.ResponseInterface;
import ru.relz.km.model.cave.CaveInterface;
import ru.relz.km.model.response.text.Code;
import ru.relz.km.model.world_info.WorldInfo;
import ru.relz.km.model.world_info.WorldInfoInterface;

import java.util.*;

public class Agent implements AgentInterface {
	private final List<ActionInterface> actions = new ArrayList<>();

	private Agent(
			PositionInterface position,
			int arrowCount,
			String name,
			Direction direction,
			int legCount,
			boolean isAlive,
			boolean hasGold,
			WorldInfoInterface worldInfo
	) {
		update(position, arrowCount, name, direction, legCount, isAlive, hasGold);
		this.worldInfo = worldInfo;
	}

	public Agent() {
		doAction(new Action());
	}

	private PositionInterface position;
	public PositionInterface getPosition() {
		return position;
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

	private boolean hasGold;
	public boolean isHasGold() {
		return hasGold;
	}

	private WorldInfoInterface worldInfo;
	public void setWorldInfo(WorldInfoInterface worldInfo) {
		this.worldInfo = worldInfo;
	}

	public boolean proceed() {
		if (!actions.isEmpty()) {
			if (!doAction(actions.get(0))) {
				return false;
			}
			ActiveAction activeAction = actions.remove(0).getActive();
			switch (activeAction) {
				case SHOOT:
					System.out.println("Requiescat in pace, bastardo!");
					if (worldInfo.isMonsterAlive()) {
						System.out.println("Похоже, монстр был не там");
					} else {
						System.out.println("Отлично! Главный агрессор обезврежен");
					}
			}
			return true;
		}
		if (createMonsterKillingActivity()) {
			return true;
		}
		if (createTreasureReachingActivity()) {
			return true;
		}
		createDiscoveryActivity();
		return true;
	}

	private boolean doAction(ActionInterface action) {
		ResponseInterface response = HttpRequestHelper.send(action);
		if (response == null) {
			return false;
		}
		PositionInterface newPosition = response.getText().getCurrentCave().getPosition();
		ru.relz.km.model.response.agent.AgentInterface agent = response.getText().getAgent();

		update(
				newPosition,
				agent.getArrowCount(),
				agent.getName(),
				agent.getDirection(),
				agent.getLegCount(),
				agent.isAlive(),
				agent.isHasGold()
		);
		if (action.isNoAction()) {
			worldInfo = WorldInfo.create(agent.getKnownCaves());
		}
		if (hasGold) {
			System.out.println("Золото взял!");
			return false;
		}
		worldInfo.setMonsterAlive(response.getText().isMonsterAlive());
		System.out.printf("Я в пещере %s\n", newPosition.toString());

		ru.relz.km.model.response.cave.CaveInterface currentCave = response.getText().getCurrentCave();
		worldInfo.getCaves().get(newPosition).update(
				true, currentCave.hasGold(), currentCave.hasWind(), currentCave.hasBones()
		);
		if (currentCave.hasHole()) {
			if (getLegCount() > 0) {
				worldInfo.getCaves().get(newPosition).getProbability().setHoleProbability(1.f);
				System.out.println("Чёрт! Я провалился в пропасть и сломал ногу!");
			} else {
				System.out.println("*Хруст сломанной ноги и медленно затухающие в пустоту вопли*");
			}
		}
		if (currentCave.hasBones()) {
			if (worldInfo.isMonsterAlive()) {
				System.out.println("Пещера полна чьих-то костей... монстр где-то рядом");
				List<PositionInterface> aroundPositions = newPosition.getAroundPositions();
				removeVisiblePositions(aroundPositions);
				for (PositionInterface aroundPosition : aroundPositions) {
					worldInfo.getCaves().get(aroundPosition).getProbability().increaseMonsterProbability(1.f / aroundPositions.size());
					if (worldInfo.getCaves().get(aroundPosition).getProbability().getMonsterProbability() > 0.5f) {
						worldInfo.setMonsterPosition(aroundPosition);
					}
				}
			} else {
				System.out.println("Хожу по костям, а ведь я мог пополнить коллекцию своими...");
			}
		} else {
			List<PositionInterface> aroundPositions = newPosition.getAroundPositions();
			removeVisiblePositions(aroundPositions);
			for (PositionInterface aroundPosition : aroundPositions) {
				worldInfo.getCaves().get(aroundPosition).getProbability().setMonsterProbability(0);
			}
		}
		if (currentCave.hasWind()) {
			System.out.println("Дует ветер... значит пропасть где-то по близости");
			List<PositionInterface> aroundPositions = newPosition.getAroundPositions();
			for (PositionInterface aroundPosition : aroundPositions) {
				worldInfo.getCaves().get(aroundPosition).getProbability().increaseHoleProbability(1.f / aroundPositions.size());
			}
		} else {
			List<PositionInterface> aroundPositions = newPosition.getAroundPositions();
			removeVisiblePositions(aroundPositions);
			for (PositionInterface aroundPosition : aroundPositions) {
				worldInfo.getCaves().get(aroundPosition).getProbability().setHoleProbability(0);
			}
		}
		if (currentCave.hasMonster() && worldInfo.isMonsterAlive()) {
			if (currentCave.hasGold()) {
				System.out.print("Я вижу золото, и... ");
			}
			System.out.println("НЕЕЕЕЕТ!!!!! МОНСТР!!! *страшные звуки разрывания плоти*");
		} else if (currentCave.hasGold()) {
			System.out.println("Золото! Да! Победа!");
			worldInfo.setTreasurePosition(currentCave.getPosition());
		}
		if (!agent.isAlive()) {
			System.out.println("Жизнь великого рейнджера закончилась...");
			return false;
		}

		if (response.getText().getCode() == Code.MOVING_LIMIT) {
			System.out.println("Превышен лимит дейсвтий на карте");
			return false;
		}

		return true;
	}

	private void update(
			PositionInterface position,
			int arrowCount,
			String name,
			Direction direction,
			int legCount,
			boolean isAlive,
			boolean hasGold
	) {
		this.position = position;
		this.arrowCount = arrowCount;
		this.name = name;
		this.direction = direction;
		this.legCount = legCount;
		this.isAlive = isAlive;
		this.hasGold = hasGold;
	}

	private boolean createMonsterKillingActivity() {
		final PositionInterface monsterPosition = worldInfo.getMonsterPosition();
		if (monsterPosition == null || arrowCount == 0) {
			return false;
		}
		final List<PositionInterface> attackPositions = monsterPosition.getCrossPositions();

		removeInvisiblePositions(attackPositions);
		List<PositionInterface> safestAttackPositions =
				getMapFirstElement(sortPositionsBySafety(attackPositions)).getValue();
		List<PositionInterface> lessDistancesAttackPositions =
				getMapFirstElement(sortPositionsByDistance(this.position, safestAttackPositions)).getValue();
		List<PositionInterface> way = new ArrayList<>();
		PositionInterface goal = null;
		for (PositionInterface optimalAttackPosition : lessDistancesAttackPositions) {
			if (computeWay(position, optimalAttackPosition, way)) {
				goal = optimalAttackPosition;
				break;
			}
		}
		if (goal == null) {
			System.out.printf(
					"Вот вроде бы монстр находится в пещере %s, но я не могу подобраться к нему для выстрела\n",
					monsterPosition.toString()
			);
			return false;
		}

		Direction futureDirection = createMovingActivity(way);
		System.out.printf(
				"Похоже, монстр находится в пещере %s. Выстрелю в него из пещеры %s\n",
				monsterPosition.toString(),
				goal.toString()
		);
		createAttackActivity(futureDirection, goal, monsterPosition);

		return true;
	}

	private void removeVisiblePositions(List<PositionInterface> positions) {
		removePositionsByVisible(positions, true);
	}

	private void removeInvisiblePositions(List<PositionInterface> positions) {
		removePositionsByVisible(positions, false);
	}

	private void removePositionsByVisible(List<PositionInterface> positions, boolean visible) {
		Iterator<PositionInterface> positionIterator = positions.iterator();
		while (positionIterator.hasNext()) {
			PositionInterface position = positionIterator.next();
			CaveInterface cave = worldInfo.getCaves().get(position);
			if (cave.isVisible() == visible) {
				positionIterator.remove();
			}
		}
	}

	private boolean createTreasureReachingActivity() {
		if (worldInfo.getTreasurePosition() == null) {
			return false;
		}
		List<PositionInterface> way = new ArrayList<>();
		computeWay(position, worldInfo.getTreasurePosition(), way);
		createMovingActivity(way);
		if (!position.equals(worldInfo.getTreasurePosition())) {
			System.out.printf("Ооо! Вижу золото в пещере %s, бегу за ним", worldInfo.getTreasurePosition());
		}
		createTreasureTakingActivity();

		return true;
	}

	private boolean computeWay(PositionInterface from, PositionInterface to, List<PositionInterface> result) {
		if (position.equals(to)) {
			return true;
		}
		Set<PositionInterface> visited = new HashSet<>();
		Queue<PositionInterface> queue = new LinkedList<>();
		queue.add(from);
		while (!queue.isEmpty()) {
			PositionInterface position = queue.peek();
			if (visited.contains(position)) {
				queue.remove();
				continue;
			}
			visited.add(position);
			List<PositionInterface> aroundPositions = position.getAroundPositions();
			for (PositionInterface aroundPosition : aroundPositions) {
				aroundPosition.setPrevious(position);
				if (aroundPosition.equals(to)) {
					result.addAll(aroundPosition.getPreviousChain());
					result.add(aroundPosition);

					return true;
				}
				if (worldInfo.getCaves().get(aroundPosition).isVisible()) {
					queue.offer(aroundPosition);
				}
			}
			queue.remove();
		}

		return false;
	}

	private void createAttackActivity(
			Direction direction,
			PositionInterface position,
			PositionInterface monsterPosition
	) {
		ActionInterface action = new Action();
		Direction toMonsterDirection = Direction.createToPosition(position, monsterPosition);
		action.setPassive(PassiveAction.getRotateAction(direction, toMonsterDirection));
		action.setActive(ActiveAction.SHOOT);
		actions.add(action);
	}

	private void createDiscoveryActivity() {
		List<PositionInterface> reachablePositions = new ArrayList<>();
		Set<PositionInterface> visited = new HashSet<>();
		Queue<PositionInterface> queue = new LinkedList<>();
		queue.add(position);
		while (!queue.isEmpty()) {
			PositionInterface position = queue.peek();
			if (visited.contains(position)) {
				queue.remove();
				continue;
			}
			visited.add(position);
			List<PositionInterface> aroundPositions = position.getAroundPositions();
			for (PositionInterface aroundPosition : aroundPositions) {
				if (worldInfo.getCaves().get(aroundPosition).isVisible()) {
					queue.offer(aroundPosition);
				} else {
					reachablePositions.add(aroundPosition);
				}
			}
			queue.remove();
		}

		List<PositionInterface> safestReachablePositions =
				getMapFirstElement(sortPositionsBySafety(reachablePositions)).getValue();
		List<PositionInterface> lessDistanceReachablePositions =
				getMapFirstElement(sortPositionsByDistance(position, safestReachablePositions)).getValue();
		List<PositionInterface> way = new ArrayList<>();
		for (PositionInterface optimalReachablePosition : lessDistanceReachablePositions) {
			if (computeWay(position, optimalReachablePosition, way)) {
				System.out.printf("Пойду открою новую пещеру %s\n", optimalReachablePosition);
				break;
			}
		}
		createMovingActivity(way);
	}

	private Direction createMovingActivity(List<PositionInterface> way) {
		if (way.isEmpty()) {
			return direction;
		}
		Direction futureDirection = direction;
		PositionInterface futurePosition = position;
		for (PositionInterface goal : way) {
			ActionInterface action = new Action();
			Direction goalDirection = Direction.createToPosition(futurePosition, goal);
			action.setPassive(PassiveAction.getRotateAction(futureDirection, goalDirection));
			action.setActive(ActiveAction.GO);
			actions.add(action);
			futureDirection = goalDirection;
			futurePosition = goal;
		}

		return futureDirection;
	}

	private Map<Float, List<PositionInterface>> sortPositionsBySafety(List<PositionInterface> positions) {
		Map<Float, List<PositionInterface>> probabilitiesToPositions = new TreeMap<>();
		for (PositionInterface position : positions) {
			ProbabilityInterface caveProbability = worldInfo.getCaves().get(position).getProbability();
			mapSafeAdd(
					probabilitiesToPositions,
					caveProbability.getMonsterProbability() + caveProbability.getHoleProbability(),
					position
			);
		}

		return probabilitiesToPositions;
	}

	private Map<Integer, List<PositionInterface>> sortPositionsByDistance(
			PositionInterface from,
			List<PositionInterface> toPositions
	) {
		Map<Integer, List<PositionInterface>> result = new HashMap<>();
		for (PositionInterface position : toPositions) {
			mapSafeAdd(result, Position.calculateDistance(from, position), position);
		}

		return result;
	}

	private void createTreasureTakingActivity() {
		ActionInterface action = new Action();
		action.setPassive(PassiveAction.NO_ACTION);
		action.setActive(ActiveAction.TAKE_GOLD);
		actions.add(action);
	}

	private <K, V> void mapSafeAdd(Map<K, List<V>> map, K key, V value) {
		if (!map.containsKey(key)) {
			map.put(key, new ArrayList<>());
		}
		map.get(key).add(value);
	}

	private <K, V> Map.Entry<K, V> getMapFirstElement(Map<K, V> map) {
		return map.entrySet().iterator().next();
	}
}
