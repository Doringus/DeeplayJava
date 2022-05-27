import java.util.List;

public class Node {

    public Node(List<Edge> neighbours) {
        this.neighbours = neighbours;
    }

    public List<Edge> getNeighbours() {
        return neighbours;
    }

    public static class Edge {
        public int weight;
        public Node node;
    }

    private List<Edge> neighbours;

}
