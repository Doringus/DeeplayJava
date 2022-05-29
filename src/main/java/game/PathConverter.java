package game;

import java.util.HashMap;

public class PathConverter {

    public PathConverter(HashMap<String, HashMap<Character, Double>> mappings) {
        this.mappings = mappings;
    }

    Double getWeight(char key, String perspective) {
        return mappings.get(perspective).get(key);
    }

    private HashMap<String, HashMap<Character, Double>> mappings;

}
