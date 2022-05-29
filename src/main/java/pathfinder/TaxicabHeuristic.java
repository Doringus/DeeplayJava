package pathfinder;

import game.WorldNode;

public class TaxicabHeuristic implements IHeuristic<WorldNode> {

    @Override
    public double calculateDistance(WorldNode lhs, WorldNode rhs) {
        return Math.abs(rhs.getColumn() - lhs.getColumn()) + Math.abs(rhs.getRow() - lhs.getRow());
    }
}
