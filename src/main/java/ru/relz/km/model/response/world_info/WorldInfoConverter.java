package ru.relz.km.model.response.world_info;

import com.google.gson.*;

import java.lang.reflect.Type;

public class WorldInfoConverter implements JsonDeserializer<WorldInfoInterface> {
	public WorldInfoInterface deserialize(
			JsonElement json, Type type, JsonDeserializationContext context
	) throws JsonParseException {
		JsonObject object = json.getAsJsonObject();

		return new WorldInfo(object.get("ismonsteralive").getAsInt() == 1);
	}
}
