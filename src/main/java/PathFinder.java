import game.GameWorldGraphAdapter;
import game.GameWorldGrid;
import game.PathConverter;
import game.WorldNode;
import pathfinder.AStar;

import java.util.HashMap;

public class PathFinder {

    public static void main(String[] args) {
        System.out.println("hello");
        GameWorldGrid graph = new GameWorldGrid("STWSWTPPTPTTPWPP");
        HashMap<String, HashMap<Character, Integer>> mappings = new HashMap<>();
        HashMap<Character, Integer> human = new HashMap<>();
        human.put('T', 3);
        human.put('W', 2);
        human.put('P', 1);
        human.put('S', 5);
        mappings.put("Human", human);
        HashMap<Character, Integer> orc = new HashMap<>();
        orc.put('T', 1);
        orc.put('W', 2);
        orc.put('P', 6);
        orc.put('S', 0);
        mappings.put("Orc", orc);
        PathConverter<Integer> pathConverter = new PathConverter<>(mappings);
        GameWorldGraphAdapter graphAdapter = new GameWorldGraphAdapter(graph, pathConverter, "Human");
        AStar<WorldNode> aStar = new AStar<WorldNode>(graphAdapter, (lhs, rhs) ->
                Math.abs(rhs.getColumn() - lhs.getColumn()) + Math.abs(rhs.getRow() - lhs.getRow()));
        aStar.solve(graph.getNode(0, 0), graph.getNode(3, 3));
    }

}
