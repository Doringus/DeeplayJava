package game;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PathConverterTest {

    @Test
    void getWeight() {
        HashMap<String, HashMap<Character, Double>> mappings = new HashMap<>();
        HashMap<Character, Double> mapping = new HashMap<>();
        mapping.put('a', 1.0);
        mappings.put("Human", mapping);
        PathConverter converter = new PathConverter(mappings);
        assertEquals(1.0, converter.getWeight('a', "Human"));
    }
}