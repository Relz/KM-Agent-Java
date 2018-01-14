package ru.relz.km.model.response.text;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import ru.relz.km.model.response.agent.Agent;
import ru.relz.km.model.response.agent.AgentConverter;
import ru.relz.km.model.response.cave.Cave;
import ru.relz.km.model.response.cave.CaveConverter;

import java.lang.reflect.Type;

public class TextConverter implements JsonDeserializer<TextInterface> {
	public TextInterface deserialize(
			JsonElement json, Type type, JsonDeserializationContext context
	) throws JsonParseException {
		JsonObject object = json.getAsJsonObject();
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(Cave.class, new CaveConverter())
				.registerTypeAdapter(Agent.class, new AgentConverter())
				.create();
		JsonElement notification = object.get("notification");

		return new Text(
				notification != null ? notification.getAsString() : null,
				Code.createFromNumber(object.get("code").getAsInt()),
				gson.fromJson(object.getAsJsonObject("currentcave"), new TypeToken<Cave>(){}.getType()),
				gson.fromJson(object.getAsJsonObject("iagent"), new TypeToken<Agent>(){}.getType())
		);
	}
}
