import game.*;
import pathfinder.AStar;
import pathfinder.TaxicabHeuristic;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Solution {

    public static double getResult(String world, String perspective, Path configPath) {
        JsonGameConfigProvider provider = new JsonGameConfigProvider(configPath);
        HashMap<String, HashMap<Character, Double>> mappings = provider.getConfig();
        GameWorldGrid graph = new GameWorldGrid(world);
        PathConverter pathConverter = new PathConverter(mappings);
        GameWorldGraphAdapter graphAdapter = new GameWorldGraphAdapter(graph, pathConverter, perspective);
        AStar<WorldNode> aStar = new AStar<WorldNode>(graphAdapter, new TaxicabHeuristic());
        return aStar.solve(graph.getNode(0, 0), graph.getNode(3, 3));
    }

}
