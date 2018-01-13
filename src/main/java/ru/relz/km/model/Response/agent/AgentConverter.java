package ru.relz.km.model.Response.agent;

import com.google.gson.*;
import ru.relz.km.model.agent.Direction;

import java.lang.reflect.Type;

public class AgentConverter implements JsonDeserializer<AgentInterface> {
	public AgentInterface deserialize(
			JsonElement json, Type type, JsonDeserializationContext context
	) throws JsonParseException {
		JsonObject object = json.getAsJsonObject();
		return new Agent(
				object.get("arrowcount").getAsInt(),
				object.get("aname").getAsString(),
				Direction.createFromString(object.get("dir").getAsString()),
				object.get("legscount").getAsInt(),
				object.get("isagentalive").getAsBoolean()
		);
	}
}
