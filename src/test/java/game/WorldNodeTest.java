package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldNodeTest {

    @Test
    void getRow() {
        int row = 0, col = 1;
        char ch = 'c';
        WorldNode worldNode = new WorldNode(row, col, ch);
        assertEquals(row, worldNode.getRow());
    }

    @Test
    void getColumn() {
        int row = 0, col = 1;
        char ch = 'c';
        WorldNode worldNode = new WorldNode(row, col, ch);
        assertEquals(col, worldNode.getColumn());
    }

    @Test
    void getKey() {
        int row = 0, col = 1;
        char ch = 'c';
        WorldNode worldNode = new WorldNode(row, col, ch);
        assertEquals(ch, worldNode.getKey());
    }
}