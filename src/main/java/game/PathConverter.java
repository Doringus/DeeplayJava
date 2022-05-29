package game;

import java.util.HashMap;

public class PathConverter<T extends Number> {

    public PathConverter(HashMap<String, HashMap<Character, T>> mappings) {
        this.mappings = mappings;
    }

    T getWeight(char key, String perspective) {
        return mappings.get(perspective).get(key);
    }

    private HashMap<String, HashMap<Character, T>> mappings;

}
