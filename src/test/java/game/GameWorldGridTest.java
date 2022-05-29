package game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameWorldGridTest {

    @Test
    void getNeighboursCorner() {
        GameWorldGrid grid = new GameWorldGrid("ABCDABCDA");
        List<WorldNode> expectedNodes = new ArrayList<>();
        expectedNodes.add(new WorldNode(1, 0, 'D'));
        expectedNodes.add(new WorldNode(0, 1, 'B'));
        List<WorldNode> nodes = grid.getNeighbours(grid.getNode(0, 0));
        assertTrue(expectedNodes.containsAll(nodes) && nodes.containsAll(expectedNodes));
    }

    @Test
    void getNeighboursCenter() {
        GameWorldGrid grid = new GameWorldGrid("ABCDABCDA");
        List<WorldNode> expectedNodes = new ArrayList<>();
        expectedNodes.add(new WorldNode(0, 1, 'B'));
        expectedNodes.add(new WorldNode(1, 0, 'D'));
        expectedNodes.add(new WorldNode(1, 2, 'B'));
        expectedNodes.add(new WorldNode(2, 1, 'D'));
        List<WorldNode> nodes = grid.getNeighbours(grid.getNode(1, 1));
        assertTrue(expectedNodes.containsAll(nodes) && nodes.containsAll(expectedNodes));
    }

    @Test
    void getNode() {
        GameWorldGrid grid = new GameWorldGrid("ABCDABCDA");
        WorldNode node = new WorldNode(0, 0, 'A');
        assertEquals(node, grid.getNode(0, 0));
    }
}