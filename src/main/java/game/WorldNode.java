package game;

public  class WorldNode {

    public WorldNode(int row, int col, char key) {
        this.row = row;
        this.col = col;
        this.key = key;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }

    public char getKey() {
        return key;
    }

    private int row, col;
    private char key;
}