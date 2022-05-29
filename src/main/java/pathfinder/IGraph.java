package pathfinder;

import java.util.List;

public interface IGraph<T> {
    List<T> getNeighbours(T node);
    double distance(T from, T to);
}
