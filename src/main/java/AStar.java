import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class AStar {

    private static class AStarNodeWrapper implements Comparable<AStarNodeWrapper> {
        public Node parent;
        public Node node;
        public double localWeight;
        public double globalWeight;

        AStarNodeWrapper(Node node) {
            this.node = node;
            this.parent = null;
            this.localWeight = Double.MAX_VALUE;
            this.globalWeight = Double.MAX_VALUE;
        }

        public int compareTo(AStarNodeWrapper other) {
            return Double.compare(this.globalWeight, other.globalWeight);
        }
    }

    @FunctionalInterface
    public interface Heuristic {
        double calculateDistance(Node lhs, Node rhs);
    }

    public static double solve(Node start, Node end, Heuristic heuristic) {
        PriorityQueue<AStarNodeWrapper> frontier = new PriorityQueue<>();
        HashMap<Node, AStarNodeWrapper> visitedNodes = new HashMap<>();

        AStarNodeWrapper startNodeWrapper = new AStarNodeWrapper(start);
        startNodeWrapper.globalWeight = heuristic.calculateDistance(start, end);
        startNodeWrapper.localWeight = 0.0;
        frontier.add(startNodeWrapper);
        Node currentNode = start;
        while (!frontier.isEmpty() && currentNode != end) {
            AStarNodeWrapper topNode = frontier.poll();
            currentNode = topNode.node;
            for (Node.Edge neighbour: currentNode.getNeighbours()) {
                double weight = topNode.localWeight + neighbour.weight;
                if(!visitedNodes.containsKey(neighbour.node) || weight < topNode.localWeight) {

                }
            }
        }

        return 0;
    }

}
