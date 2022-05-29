package game;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonGameConfigProvider implements IGameConfigProvider {

    public JsonGameConfigProvider(Path path) {
        this.path = path;
    }

    @Override
    public HashMap<String, HashMap<Character, Double>> getConfig() {
        Stream<String> lines = null;
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        JsonObject object = (new JsonParser()).parse(data).getAsJsonObject();
        JsonArray weights = object.get("weightsTable").getAsJsonArray();

        HashMap<String, HashMap<Character, Double>> config = new HashMap<>();
        for(JsonElement weightElement : weights) {
            JsonObject weightListObject = weightElement.getAsJsonObject();
            JsonArray objectWeights = weightListObject.getAsJsonArray("weights");
            HashMap<Character, Double> mapping = new HashMap<>();
            for(JsonElement weight : objectWeights) {
                JsonObject weightObject = weight.getAsJsonObject();
                mapping.put(weightObject.get("symbol").getAsCharacter(), weightObject.get("value").getAsDouble());
            }
            config.put(weightListObject.get("name").getAsString(), mapping);
        }
        return config;
    }

    private Path path;
}
