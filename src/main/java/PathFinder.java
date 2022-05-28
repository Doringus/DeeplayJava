public class PathFinder {

    public static void main(String[] args) {
        System.out.println("hello");
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        Node f = new Node();

        a.addEdge(new Node.Edge(3, b));
        a.addEdge(new Node.Edge(1, d));
        a.x = 0; a.y = 0;
        b.addEdge(new Node.Edge(3, a));
        b.addEdge(new Node.Edge(5, c));
        b.x = 1; b.y = 0;
        c.addEdge(new Node.Edge(5, b));
        c.addEdge(new Node.Edge(1, f));
        c.x = 2; c.y = 0;
        f.addEdge(new Node.Edge(1, c));
        f.addEdge(new Node.Edge(8, e));
        f.x = 2; f.y = 1;
        e.addEdge(new Node.Edge(8, f));
        e.addEdge(new Node.Edge(2, d));
        e.x = 1; e.y = 1;
        d.addEdge(new Node.Edge(2, e));
        d.addEdge(new Node.Edge(1, a));
        d.x = 0; d.y = 1;

        double r = AStar.solve(a, f, (lhs, rhs)-> Math.abs(lhs.x - rhs.x) + Math.abs(lhs.y - rhs.y));
    }

}
