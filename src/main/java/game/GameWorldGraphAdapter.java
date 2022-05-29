package game;

import pathfinder.IGraph;

import java.util.List;

public class GameWorldGraphAdapter implements IGraph<WorldNode> {

    public GameWorldGraphAdapter(GameWorldGrid grid, PathConverter<Integer> converter, String perspective) {
        this.grid = grid;
        this.converter = converter;
        this.perspective = perspective;
    }

    @Override
    public List<WorldNode> getNeighbours(WorldNode node) {
        return grid.getNeighbours(node);
    }

    @Override
    public double distance(WorldNode from, WorldNode to) {
        return converter.getWeight(to.getKey(), perspective);
    }

    private GameWorldGrid grid;
    private String perspective;
    PathConverter<Integer> converter;
}
