package pathfinder;

public interface IHeuristic <T> {
    double calculateDistance(T lhs, T rhs);
}
