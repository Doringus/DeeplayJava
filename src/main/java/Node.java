import java.util.ArrayList;
import java.util.List;

public class Node {

    public int x, y; /// move to separate class

    public Node() {
        this.neighbours = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        neighbours.add(edge);
    }

    public List<Edge> getNeighbours() {
        return neighbours;
    }

    public static class Edge {
        public double weight;
        public Node node;

        public Edge(double weight, Node neighbour) {
            this.weight = weight;
            this.node = neighbour;
        }
    }

    private List<Edge> neighbours;

}
