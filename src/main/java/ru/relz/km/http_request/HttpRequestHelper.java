package ru.relz.km.http_request;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import jdk.incubator.http.*;
import ru.relz.km.model.response.*;
import ru.relz.km.model.action.Action;
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

	private static String createURL(Action action) {
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

	public static ResponseInterface send(Action action) {
		HttpRequest request;
		try {
			request = HttpRequest.newBuilder().uri(new URI(createURL(action))).GET().build();
			HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandler.asString());
			Gson gson = new GsonBuilder().registerTypeAdapter(Response.class, new ResponseConverter()).create();

			return gson.fromJson(httpResponse.body(), new TypeToken<Response>(){}.getType());
		} catch (URISyntaxException | UnresolvedAddressException e) {
			System.out.println("Пожалуйста, проверьте ссылку на правильность: ");
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
