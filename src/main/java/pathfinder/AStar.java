package pathfinder;

import java.util.HashMap;
import java.util.PriorityQueue;


public class AStar<T> {

    private class NodeWrapper implements Comparable<NodeWrapper> {

        NodeWrapper(T node) {
            this(node, null, Double.MAX_VALUE, Double.MAX_VALUE);
        }

        NodeWrapper(T node, NodeWrapper parent, double trueWeight, double predictedWeight) {
            this.node = node;
            this.parent = parent;
            this.trueWeight = trueWeight;
            this.predictedWeight = predictedWeight;
        }

        public int compareTo(NodeWrapper other) {
            return Double.compare(this.predictedWeight, other.predictedWeight);
        }

        public T node;
        public NodeWrapper parent;
        public double trueWeight;
        public double predictedWeight;
    }

    public AStar(IGraph<T> graph, IHeuristic<T> heuristic) {
        this.graph = graph;
        this.heuristic = heuristic;
    }

    public double solve (T start, T end) {
        PriorityQueue<NodeWrapper> frontier = new PriorityQueue<>();
        HashMap<T, NodeWrapper> visitedNodes = new HashMap<>();

        NodeWrapper startNodeWrapper = new NodeWrapper(start);
        startNodeWrapper.trueWeight = 0.0;
        startNodeWrapper.predictedWeight = heuristic.calculateDistance(start, end);
        frontier.add(startNodeWrapper);
        visitedNodes.put(start, startNodeWrapper);
        while (!frontier.isEmpty()) {
            NodeWrapper topNode = frontier.poll();
            if(topNode.node == end) {
                return topNode.trueWeight;
            }
            for (T neighbour: graph.getNeighbours(topNode.node)) {
                double weight = topNode.trueWeight + graph.distance(topNode.node, neighbour);
                NodeWrapper visitedNode = visitedNodes.getOrDefault(neighbour, new NodeWrapper(neighbour));
                visitedNodes.put(neighbour, visitedNode);
                if(weight < visitedNode.trueWeight) {
                    visitedNode.trueWeight = weight;
                    visitedNode.parent = topNode;
                    visitedNode.predictedWeight = weight + heuristic.calculateDistance(neighbour, end);
                    frontier.add(visitedNode);
                }
            }
        }

        return 0;
    }

    private IHeuristic<T> heuristic;
    private IGraph<T> graph;
}
