package ru.relz.km.http_request;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import jdk.incubator.http.*;
import ru.relz.km.model.action.ActionInterface;
import ru.relz.km.model.response.*;
import ru.relz.km.properties.PropertiesHelper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.UnresolvedAddressException;

public class HttpRequestHelper {
	private static final String configFileName = "src/main/resources/config.properties";
	private static final HttpClient httpClient = HttpClient.newHttpClient();

	private static String caseId;
	private static String userId;
	private static String mapNum;

	private static void setUp() {
		PropertiesHelper propertiesHelper = null;
		try {
			propertiesHelper = new PropertiesHelper(configFileName);
		} catch (IOException e) {
			System.out.println("Не найден файл конфигурации: " + configFileName);
			System.exit(1);
		}
		caseId = propertiesHelper.getCaseId();
		userId = propertiesHelper.getUserId();
		mapNum = propertiesHelper.getMapNum();
	}

	private static String createURL(ActionInterface action) {
		if (caseId == null || userId == null || mapNum == null) {
			setUp();
		}

		return "https://mooped.net/local/its/game/agentaction/?"
				+ "caseid="
				+ caseId
				+ "&userid="
				+ userId
				+ "&mapnum="
				+ mapNum
				+ "&passive="
				+ action.getPassive()
				+ "&active="
				+ action.getActive();
	}

	public static ResponseInterface send(ActionInterface action) {
		HttpRequest request;
		try {
			request = HttpRequest.newBuilder().uri(new URI(createURL(action))).GET().build();
			HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandler.asString());
			Gson gson = new GsonBuilder().registerTypeAdapter(Response.class, new ResponseConverter()).create();

			ResponseInterface response = gson.fromJson(httpResponse.body(), new TypeToken<Response>(){}.getType());
			if (response == null) {
				System.out.println("Сервер прислал неожидаемый формат ответа");

				return null;
			}
			showServerMessages(response);

			return response;

		} catch (URISyntaxException | UnresolvedAddressException e) {
			System.out.println("Пожалуйста, проверьте ссылку на правильность: ");
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private static void showServerMessages(ResponseInterface response) {
		if (response.getErrorType() != null) {
			switch (response.getErrorType()) {
				case ERROR:
					if (response.getError() != null) {
						System.out.printf(
								"Сервер вернул ошибку с кодом %d: %s\n",
								response.getText().getCode().getNumber(),
								response.getError()
						);
					} else {
						System.out.println("Сервер вернул непонятную ошибку");
					}
				case NOTIFICATION:
					if (response.getError() != null) {
						System.out.printf("Сервер вернул уведомление: %s\n", response.getError());
					} else {
						System.out.println("Сервер вернул непонятное уведомление");
					}
			}
		}

		if (response.getText().getNotification() != null) {
			System.out.printf("Сервер отправил сообщение: %s\n", response.getText().getNotification());
		}
	}
}
