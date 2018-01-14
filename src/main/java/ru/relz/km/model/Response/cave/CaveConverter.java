package ru.relz.km.model.Response.cave;

import com.google.gson.*;

import java.lang.reflect.Type;

public class CaveConverter implements JsonDeserializer<CaveInterface> {
	public CaveInterface deserialize(
			JsonElement json, Type type, JsonDeserializationContext context
	) throws JsonParseException {
		JsonObject object = json.getAsJsonObject();

		return new Cave(
				object.get("colN").getAsInt(),
				object.get("rowN").getAsInt(),
				object.get("isGold").getAsBoolean(),
				object.get("isMonster").getAsBoolean(),
				object.get("isHole").getAsBoolean(),
				object.get("isWind").getAsBoolean(),
				object.get("isBones").getAsBoolean()
		);
	}
}