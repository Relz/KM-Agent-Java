package ru.relz.km.model.response.cave;

import com.google.gson.*;
import ru.relz.km.model.position.Position;

import java.lang.reflect.Type;

public class CaveConverter implements JsonDeserializer<CaveInterface> {
	public CaveInterface deserialize(
			JsonElement json, Type type, JsonDeserializationContext context
	) throws JsonParseException {
		JsonObject object = json.getAsJsonObject();

		return new Cave(
				new Position(object.get("colN").getAsInt(), object.get("rowN").getAsInt()),
				object.get("isGold").getAsInt() == 1,
				object.get("isMonster").getAsInt() == 1,
				object.get("isHole").getAsInt() == 1,
				object.get("isWind").getAsBoolean(),
				object.get("isBones").getAsBoolean()
		);
	}
}
