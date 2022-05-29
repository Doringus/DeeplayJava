import game.*;
import pathfinder.AStar;

import java.nio.file.Paths;
import java.util.HashMap;

public class PathFinder {

    public static void main(String[] args) {
        JsonGameConfigProvider provider = new JsonGameConfigProvider(Paths.get("src/main/resources/config.json"));
        HashMap<String, HashMap<Character, Double>> mappings = provider.getConfig();
        GameWorldGrid graph = new GameWorldGrid("STWSWTPPTPTTPWPP");
        PathConverter pathConverter = new PathConverter(mappings);
        GameWorldGraphAdapter graphAdapter = new GameWorldGraphAdapter(graph, pathConverter, "Human");
        AStar<WorldNode> aStar = new AStar<WorldNode>(graphAdapter, (lhs, rhs) ->
                Math.abs(rhs.getColumn() - lhs.getColumn()) + Math.abs(rhs.getRow() - lhs.getRow()));
        aStar.solve(graph.getNode(0, 0), graph.getNode(3, 3));
    }

}
