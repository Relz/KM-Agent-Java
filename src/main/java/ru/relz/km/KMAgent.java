package ru.relz.km;

import ru.relz.km.http_request.HttpRequestHelper;
import ru.relz.km.model.action.Action;
import ru.relz.km.model.response.ResponseInterface;
import ru.relz.km.model.world_info.WorldInfo;
import ru.relz.km.model.world_info.WorldInfoInterface;

public class KMAgent {
	public static void main(String[] args) {
		ResponseInterface response = HttpRequestHelper.send(new Action());
		if (response == null) {
			System.out.println("Сервер прислал неожидаемый формата ответа");
			System.exit(1);
		}
		WorldInfoInterface worldInfo = WorldInfo.create(response.getText().getAgent().getKnownCaves());
	}
}
