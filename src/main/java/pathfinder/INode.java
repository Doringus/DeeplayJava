package pathfinder;

import java.util.List;

public interface INode {

    void addEdge(Edge edge);
    List<Edge> getNeighbours();

    public static class Edge {
        public double weight;
        public INode neighbour;

        public Edge(double weight, INode neighbour) {
            this.weight = weight;
            this.neighbour = neighbour;
        }
    }
}
