package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameWorldGrid {

    public GameWorldGrid(String world) {
        nodes = new HashMap<>();
        ArrayList<WorldNode> matrix = new ArrayList<>();
        int size = (int) Math.sqrt(world.length());
        int stringIndex = 0;
        for(int i = 0; i < size; ++i) {
            for(int j = 0; j < size; ++j) {
                matrix.add(new WorldNode(i, j, world.charAt(stringIndex)));
                ++stringIndex;
            }
        }
        /// Create connections
        int nodeIndex = 0;
        for(int i = 0; i < size; ++i) {
            for(int j = 0; j < size; ++j) {
                ArrayList<WorldNode> neighbours = new ArrayList<>();
                if(i > 0) {
                    neighbours.add(matrix.get((i - 1) * size + j));
                }
                if(i < size - 1) {
                    neighbours.add(matrix.get((i + 1) * size + j));
                }
                if(j > 0) {
                    neighbours.add(matrix.get(i * size + (j - 1)));
                }
                if(j < size - 1) {
                    neighbours.add(matrix.get(i * size + (j + 1)));
                }
                nodes.put(matrix.get(nodeIndex), neighbours);
                nodeIndex++;
            }
        }
    }

    public List<WorldNode> getNeighbours(WorldNode node) {
        return nodes.getOrDefault(node, new ArrayList<>());
    }

    public WorldNode getNode(int row, int col) {
        return nodes.keySet().stream().filter(node -> node.getColumn() == col &&
                                                      node.getRow() == row).findFirst().orElse(null);
    }

    HashMap<WorldNode, List<WorldNode>> nodes;
}
