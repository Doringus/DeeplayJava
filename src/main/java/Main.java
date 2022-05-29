import game.*;
import pathfinder.AStar;

import java.nio.file.Paths;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        double result = Solution.getResult("STWSWTPPTPTTPWPP", "Human", Paths.get("src/main/resources/config.json"));
    }

}
