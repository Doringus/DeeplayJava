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
        visitedNodes.put(start, startNodeWrapper);
        while (!frontier.isEmpty()) {
            AStarNodeWrapper topNode = frontier.poll();
            if(topNode.node == end) {
                return topNode.localWeight;
            }
            for (Node.Edge neighbour: topNode.node.getNeighbours()) {
                double weight = topNode.localWeight + neighbour.weight;
                AStarNodeWrapper visitedNode = visitedNodes.getOrDefault(neighbour.node, new AStarNodeWrapper(neighbour.node));
                visitedNodes.put(neighbour.node, visitedNode);
                if(weight < visitedNode.localWeight) {
                    visitedNode.localWeight = weight;
                    visitedNode.parent = topNode.node;
                    visitedNode.globalWeight = weight + heuristic.calculateDistance(neighbour.node, end);
                    frontier.add(visitedNode);
                }
            }
        }

        return 0;
    }

}
