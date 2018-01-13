package ru.relz.km.model.Response;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import ru.relz.km.model.Response.text.Text;
import ru.relz.km.model.Response.text.TextConverter;

import java.lang.reflect.Type;

public class ResponseConverter implements JsonDeserializer<ResponseInterface> {
	public ResponseInterface deserialize(
			JsonElement json, Type type, JsonDeserializationContext context
	) throws JsonParseException {
		JsonObject object = json.getAsJsonObject();
		Gson gson = new GsonBuilder().registerTypeAdapter(Text.class, new TextConverter()).create();
		JsonElement error = object.get("error");
		JsonElement errorType = object.get("error_type");
		return new Response(
				gson.fromJson(object.getAsJsonObject("text"), new TypeToken<Text>(){}.getType()),
				(error.isJsonNull()) ? null : error.getAsString(),
				ErrorType.createFromString((errorType.isJsonNull()) ? null : errorType.getAsString())
		);
	}
}