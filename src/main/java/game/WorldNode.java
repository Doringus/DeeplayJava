package game;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        WorldNode other = (WorldNode)o;
        return  this.row == other.row &&
                this.col == other.col &&
                this.key == other.key;
    }

    private int row, col;
    private char key;
}