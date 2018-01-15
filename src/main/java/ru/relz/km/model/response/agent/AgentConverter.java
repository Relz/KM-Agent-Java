package ru.relz.km.model.response.agent;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import ru.relz.km.model.response.cave.Cave;
import ru.relz.km.model.response.cave.CaveConverter;
import ru.relz.km.model.response.cave.CaveInterface;
import ru.relz.km.model.agent.Direction;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
				object.get("isagentalive").getAsInt() == 1,
				deserializeKnownCaves(object.getAsJsonObject("knowCaves"))
		);
	}

	private List<CaveInterface> deserializeKnownCaves(JsonObject object) {
		List<CaveInterface> result = new ArrayList<>();
		Gson gson = new GsonBuilder().registerTypeAdapter(Cave.class, new CaveConverter()).create();
		Set<Map.Entry<String, JsonElement>> entries = object.entrySet();
		for (Map.Entry<String, JsonElement> entry : entries) {
			JsonElement cave = entry.getValue();
			result.add(gson.fromJson(cave, new TypeToken<Cave>(){}.getType()));
		}

		return result;
	}
}
