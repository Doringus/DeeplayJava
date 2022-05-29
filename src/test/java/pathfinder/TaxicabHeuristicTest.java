package pathfinder;

import game.WorldNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxicabHeuristicTest {

    @Test
    void calculateDistance() {
        WorldNode lhs = new WorldNode(0, 0, 'A');
        WorldNode rhs = new WorldNode(2, 1, 'B');
        assertEquals(3, new TaxicabHeuristic().calculateDistance(lhs, rhs));
    }
}